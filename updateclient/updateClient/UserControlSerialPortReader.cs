using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net;
using System.Web;
using System.IO;

namespace updateClient
{
    public partial class UserControlSerialPortReader : UserControl
    {
        //Constant declaration
        int FRAME_LENGTH = 5, BAUD_RATE = 115200, DATA_BITS = 8 ;

        //Variables declaration
        List<int> bufferSerialPorts = new List<int>();
        Frame currentFrameInfo = new Frame();
        delegate void SetTextCallback(string text);
        int frameCounter = 0; // total number of frame received, used in combination with frameExceptionCounter
        int frameExceptionCounter = 0; // Is used to count the number of corrupt incoming frame
        int solarFrameCounter = 0;
        int windFrameCounter = 0;
        /*
         * User Control gathering all the tools used to connect the application to the serial port
         */
        public UserControlSerialPortReader()
        {
            InitializeComponent();

            string[] ports = System.IO.Ports.SerialPort.GetPortNames();

            /*
             * Adding the working COM ports to the proper comboBox
             */
            comboBoxCOMPorts.BeginUpdate();
            for (int i = 0; i < ports.Length; i++)
            {
                comboBoxCOMPorts.Items.Add(ports[i]);

            }
            if (ports.Length == 0)
            {
                comboBoxCOMPorts.Items.Add("Vide");
                comboBoxCOMPorts.SelectedItem = "Vide";
            }
            else
            {
                comboBoxCOMPorts.SelectedItem = ports[0];
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                beginReception();
            }
            catch(BadParameterException bpe)
            {
                button_start.Enabled = true;
                labelError.Text = bpe.getErrorMessage();
            }
        }

        /*
         * Function called to initialize the COM port data access
         */
        private void beginReception()
        {
            button_start.Enabled = false;

            // Configuration du port série
            serialPort1.BaudRate = BAUD_RATE;
            serialPort1.DataBits = DATA_BITS;
            //Récupération des données de connexion série
            if (comboBoxCOMPorts.SelectedItem == null)
            {
               throw new BadParameterException("No port name");
            }
            String portName = comboBoxCOMPorts.SelectedItem.ToString();
            if(portName == "Vide")
            {
                throw new BadParameterException("Bad port name");
            }
            //Initialisation de la connexion
            if (serialPort1.IsOpen)
            {
                serialPort1.Close();
            }
            try
            {
                serialPortInit(portName, BAUD_RATE);
            }
            catch(Exception e)
            {
                labelError.Text += " \r\nERREUR A L'OUVERTURE";
                labelError.BackColor = Color.OrangeRed;
            }
            
            if (button_stop.Enabled == false)
            {
                button_stop.Enabled = true;
            }
        }
        
        /*
         * Function that fills the serialPort parameters and open it
         */
        private void serialPortInit(string portName, int baudRate)
        {
            serialPort1.PortName = portName;
            serialPort1.Open();
        }

        /*
         * Event function called when the serialPortReader receives data
         */
        private void serialPort1_DataReceived(object sender, System.IO.Ports.SerialDataReceivedEventArgs e)
        {
            receiveData();
        }

        private void receiveData()
        {
            bufferSerialPorts.Clear();
            
            int count = serialPort1.BytesToRead;
            for (int i = 0; i < count; i++)
            {
                //Bytes are returned in a "int" type
                int temp = serialPort1.ReadByte();
                bufferSerialPorts.Add(temp);

            }
            serialPort1.DiscardInBuffer();

            if (bufferSerialPorts.Count > 0)
            {
                //SetText(InputData.Substring(0, InputData.Length - 1));
                try
                {
                    
                    processData("");
                }
                catch(CorruptFrameException cfe)
                {
                    frameExceptionCounter++;
                    labelCorruptFrameNumber.Text = frameExceptionCounter.ToString();

                    if(frameExceptionCounter % 5 == 0)// we fit up to five frame exception info
                    {

                        textBoxDebugInfo.Text = cfe.getErrorMessage();               
                    }
                    else
                    {
                        textBoxDebugInfo.Text += cfe.getErrorMessage(); 
                    }
                    textBoxDebugInfo.Text += "\r\n";
                }
            }
        }

        private void processData(string text)// throw CorruptFrameException
        {
            int count = 0;
            //InvokeRequired required compares the thread ID of the
            //calling thread to the thread ID of the creating thread.
            // If these threads are different, it returns true.
            if (this.textBoxSolarData.InvokeRequired)
            {
                SetTextCallback d = new SetTextCallback(processData);
                this.Invoke(d, new object[] { text });
            }
            else//process incoming data
            {
                frameCounter++;
                labelTotalFrameNumber.Text = frameCounter.ToString();

                textBoxSolarData.Text += "";
                byte[] arr_bytes = new byte[bufferSerialPorts.Count];
                for (int i = 0; i < bufferSerialPorts.Count; i++)
                {
                    
                    arr_bytes[i] = Convert.ToByte(bufferSerialPorts[i]);

                    if (bufferSerialPorts[i] == 10) //the id of '*' wich means end of frame
                    {
                        //frame processing algorithm begins here
                        count = i + 1;                        
                        string temp = new System.Text.ASCIIEncoding().GetString(arr_bytes, 0, i + 1);

                        if (temp.Length > FRAME_LENGTH) // correct frame format
                        {
                            DateTime dateTime = DateTime.Now;
                            String dateString = dateTime.ToShortTimeString();

                            string[] temp2 = temp.Split(','); // each field is separated by a comma (Ox46)
                            if(temp2.Length != 5)
                            {
                                throw new CorruptFrameException("Incomplete data stream");
                            }
                            else
                            {
                                if (temp2[0] == "")
                                {
                                    throw new CorruptFrameException("Empty ID frame field");
                                }
                                else
                                {
                                    currentFrameInfo.ID = Convert.ToInt32(temp2[0]); //ID frame object filling
                                    currentFrameInfo.SoC = Convert.ToInt32(temp2[1]); //State of Charge frame object filling

                                    if (currentFrameInfo.SoC > 100)
                                    {
                                        throw new CorruptFrameException("State of charge > 100");
                                    }
                                    if (currentFrameInfo.SoC < 0)
                                    {
                                        throw new CorruptFrameException("State of charge < 0");
                                    }
                                    // Twu frame object filling
                                    currentFrameInfo.Twu = Convert.ToInt32(temp2[2]) / 10;
                                    //Temperature frame object filling
                                    currentFrameInfo.Temp = Convert.ToInt32(((Convert.ToDouble(temp2[3]) * 2500 / 4095) - 986) / 3.55);
                                    //RSSI frame object filling
                                    currentFrameInfo.RSSI = Convert.ToInt32(temp2[4].Remove(temp2[4].Length - 1, 1)) - 53 - 45;

                                    currentFrameInfo.timestamp = dateString;

                                    int type;
                                    string parameters = "stationid=1&type="+temp2[0]+"&wakeUpPeriod="+currentFrameInfo.Twu+"&stateOfCharge="+currentFrameInfo.SoC+"&temperature="+currentFrameInfo.Temp;
                                    try
                                    {
                                        sendData("razielone.alwaysdata.net/?oper=updateSensor", parameters);
                                    }
                                    catch(Exception fe)
                                    {

                                    }
                                    
                                    string t = ""; // the frame text value


                                    t += " ID : " + currentFrameInfo.ID;
                                    t += " SoC : " + currentFrameInfo.SoC;
                                    t += " Twu : " + currentFrameInfo.Twu;
                                    t += " Temp : " + currentFrameInfo.Temp;
                                    t += " RSSI : " + currentFrameInfo.RSSI;
                                    t += Environment.NewLine; // raw data

                                    if (Convert.ToInt32(temp2[0]) == 3)/* solar energy node */
                                    {
                                       solarFrameCounter++;
                                       if(solarFrameCounter % 7 == 0)
                                       {
                                           textBoxSolarData.Text = t;
                                       }
                                       else
                                       {
                                           textBoxSolarData.Text += t;
                                       }
                                    }
                                    else if (Convert.ToInt32(temp2[0]) == 2)/* wind energy node */
                                    {
                                        windFrameCounter++;
                                        if (windFrameCounter %5 == 0)
                                        {
                                            textBoxWindData.Text = t;
                                        }
                                        else
                                        {
                                            textBoxWindData.Text += t;
                                        }
                                       
                                    }
                                }
                                
                            }
                            

                        }
                        else
                        {
                            throw new CorruptFrameException("Incorrect frame format");
                        }
                        try
                        {
                            bufferSerialPorts.RemoveRange(0, count);
                        }
                        catch(Exception e)
                        {
                            textBoxDebugInfo.Text += "Serial port buffer removal error";
                        }
                        i = -1;

                    }
                }
            }
        }

        /*
         * The frame object represent what we will send to the server
         * Compared to the received data, it contains one more field : the timestamp
         * (nb : keep in mind that the Base Station only receive the first four fields, it calculate itself the RSSI)
         */
        public class Frame
        {
            public int ID;
            public int SoC;
            public int Twu;
            public int Temp;
            public int RSSI;
            public string timestamp;
        }

        private void UserControl1_Load(object sender, EventArgs e)
        {           
            button_stop.Enabled = false; //start-stop state machine init
        }

        private void button2_Click(object sender, EventArgs e)
        {
            endReception();
            
        }

        private void endReception()
        {
            button_stop.Enabled = false;
            if (serialPort1.IsOpen)
            {
                serialPort1.Close();
            }

            if (button_start.Enabled == false)
            {
                button_start.Enabled = true;
            }
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            sendData("http://razielone.alwaysdata.net/?oper=createsite", "title=newTitle&description=longdescriptionfromc");
        }

        /*
         * The function that will send the incoming data to the webservice
         */
        private void sendData(string url, string data)
        {
            /*
             * Request creation
             */
            HttpWebRequest httpRequest = (HttpWebRequest)HttpWebRequest.Create(url);
            httpRequest.Method = "POST";
            String dataToSend = data;
            Byte[] dPost = Encoding.ASCII.GetBytes(dataToSend);
            httpRequest.ContentType = "application/x-www-form-urlencoded";
            httpRequest.ContentLength = dPost.Length;
            MessageBox.Show(System.Text.Encoding.Default.GetString(dPost)); //Debug messagebox : sent data
            Stream requestStream = httpRequest.GetRequestStream();
            requestStream.Write(dPost, 0, dPost.Length);
            requestStream.Close();

            HttpWebResponse httpResponse = (HttpWebResponse)httpRequest.GetResponse();
            Stream responseStream = httpResponse.GetResponseStream();
            StreamReader reader = new StreamReader(responseStream, Encoding.Default);

            string response = reader.ReadToEnd();
            reader.Close();
            responseStream.Close();
            httpResponse.Close();

            index++;
            textBoxDebugInfo.Text += response+index.ToString();
         
        }

        private int index = 0;
    }

}
