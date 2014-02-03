using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace updateClient
{
    public partial class UserControlSerialPortReader : UserControl
    {

        List<int> bufferSerialPort = new List<int>();
        
        solarFrame curSolarFrame = new solarFrame();
        thermalFrame curThermalFrame = new thermalFrame();

        delegate void SetTextCallback(string text);

        public UserControlSerialPortReader()
        {
            InitializeComponent();

            string[] ports = System.IO.Ports.SerialPort.GetPortNames();

            comboBox_COM_ports.BeginUpdate();
            for (int i = 0; i < ports.Length; i++)
            {
                comboBox_COM_ports.Items.Add(ports[i]);

            }
            if (ports.Length == 0)
            {
                comboBox_COM_ports.Items.Add("Vide");
                comboBox_COM_ports.SelectedItem = "Vide";
            }
            else
            {
                comboBox_COM_ports.SelectedItem = ports[0];
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            beginReception();
        }

        private void beginReception()
        {
            button_start.Enabled = false;

            //Récupération des données de connexion série
            String portName = comboBox_COM_ports.SelectedItem.ToString();
            int baudRate = int.Parse(textBox_baudRate.Text);

            //Affichage de débogage

            //Affichage des données de l'interface
            textBox_info_debug_interface.Text = "Affichage des données de l'interface : ";
            textBox_info_debug_interface.Text += " \r\nPort COM du menu : ";
            textBox_info_debug_interface.Text += portName;

            textBox_info_debug_interface.Text += " \r\nVitesse du lien du menu : ";
            textBox_info_debug_interface.Text += baudRate;

            //Initialisation de la connexion
            if (serialPort1.IsOpen)
            {
                serialPort1.Close();
            }
            try
            {
                serialPort1.PortName = portName;
                serialPort1.BaudRate = baudRate;
                serialPort1.Open();
            }
            catch
            {
                label_erreur_connexion.Text += " \r\nERREUR A L'OUVERTURE";
            }


            //Affichage des caractéristiques du lien COM
            textBox_info_debug_comPORT.Text = "Affichage des caractéristiques du lien COM : ";

            textBox_info_debug_comPORT.Text += " \r\nPort COM de l'objet serialReader : ";
            textBox_info_debug_comPORT.Text += serialPort1.PortName;

            textBox_info_debug_comPORT.Text += " \r\nVitesse du lien de l'objet portCOM : ";
            textBox_info_debug_comPORT.Text += serialPort1.BaudRate.ToString();

            textBox_info_debug_comPORT.Text += " \r\nParité du menu de l'objet portCOM : ";
            textBox_info_debug_comPORT.Text += serialPort1.Parity.ToString();

            textBox_info_debug_comPORT.Text += " \r\nNombre de bits d'arrêt du menu de l'objet portCOM : ";
            textBox_info_debug_comPORT.Text += serialPort1.StopBits.ToString();

            if (button_stop.Enabled == false)
            {
                button_stop.Enabled = true;
            }
        }
        

        //Fonction lancée à la réception de données via le port COM
        private void serialPort1_DataReceived(object sender, System.IO.Ports.SerialDataReceivedEventArgs e)
        {
            receiveData();
        }

        private void receiveData()
        {
            bufferSerialPort.Clear();
            
            int count = serialPort1.BytesToRead;
            for (int i = 0; i < count; i++)
            {
                //Bytes are returned in a "int" type
                int temp = serialPort1.ReadByte();
                bufferSerialPort.Add(temp);

            }
            serialPort1.DiscardInBuffer();

            if (bufferSerialPort.Count > 0)
            {
                //SetText(InputData.Substring(0, InputData.Length - 1));
                SetText("");
            }
        }

        private void SetText(string text)
        {
            //InvokeRequired required compares the thread ID of the
            //calling thread to the thread ID of the creating thread.
            // If these threads are different, it returns true.
            int count = 0;
            if (this.textBox_données_solaires.InvokeRequired)
            {
                SetTextCallback d = new SetTextCallback(SetText);
                this.Invoke(d, new object[] { text });
            }
            else
            {
                //process incoming data
                textBox_données_solaires.Text = "";
                byte[] arr_bytes = new byte[bufferSerialPort.Count];
                for (int i = 0; i < bufferSerialPort.Count; i++)
                {
                    
                    arr_bytes[i] = Convert.ToByte(bufferSerialPort[i]);

                    if (bufferSerialPort[i] == 10) //the id of '*' wich means end of frame
                    {
                        //frame processing algorithm
                        count = i + 1;//count the 
                        string temp = new System.Text.ASCIIEncoding().GetString(arr_bytes, 0, i + 1);

                        if (temp.Length > 5) // correct frame format
                        {
                            string[] temp2 = temp.Split(',');
                            if (Convert.ToInt32(temp2[0]) == 3)//solar node type
                            {
                                curSolarFrame.ID = Convert.ToInt32(temp2[0]);
                                curSolarFrame.SoC = Convert.ToInt32(temp2[1]);

                                if (curSolarFrame.SoC > 100)
                                {
                                    textBox_données_solaires.Text += "Error : state of charge > 100";
                                    curSolarFrame.SoC = 100;
                                }
                                if (curSolarFrame.SoC < 0)
                                {
                                    textBox_données_solaires.Text += "Error : state of charge > 100";
                                    curSolarFrame.SoC = 0;
                                }
                                curSolarFrame.Twu = Convert.ToInt32(temp2[2]) / 10;
                                curSolarFrame.Temp = Convert.ToInt32(((Convert.ToDouble(temp2[3]) * 2500 / 4095) - 986) / 3.55);
                                //
                                curSolarFrame.RSSI = Convert.ToInt32(temp2[4].Remove(temp2[4].Length - 1, 1)) - 53 - 45;
                                textBox_données_solaires.Text += temp + Environment.NewLine;
                            }
                            else if (Convert.ToInt32(temp2[0]) == 2)//wind node type
                            {
                                curThermalFrame.ID = Convert.ToInt32(temp2[0]);
                                curThermalFrame.SoC = Convert.ToInt32(temp2[1]);
                                if (curThermalFrame.SoC > 100)
                                    curThermalFrame.SoC = 100;
                                if (curThermalFrame.SoC < 0)
                                    curThermalFrame.SoC = 0;
                                curThermalFrame.Twu = Convert.ToInt32(temp2[2]) / 10;
                                curThermalFrame.Temp = Convert.ToInt32(((Convert.ToDouble(temp2[3]) * 2500 / 4095) - 986) / 3.55);
                                curThermalFrame.RSSI = Convert.ToInt32(temp2[4].Remove(temp2[4].Length - 1, 1)) - 53 - 45;
                                textBox_données_éolien.Text += temp + Environment.NewLine;
                            }
                        }

                        bufferSerialPort.RemoveRange(0, count);
                        i = -1;

                    }
                }
            }
        }

        public class solarFrame
        {
            public int ID;
            public int SoC;
            public int Twu;
            public int Temp;
            public int RSSI;
        }
        public class thermalFrame
        {
            public int ID;
            public int SoC;
            public int Twu;
            public int Temp;
            public int RSSI;
        }

        private void UserControl1_Load(object sender, EventArgs e)
        {           
            button_stop.Enabled = false;
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
    }

}
