namespace updateClient

{
    partial class UserControlSerialPortReader
    {
        /// <summary> 
        /// Variable nécessaire au concepteur.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Nettoyage des ressources utilisées.
        /// </summary>
        /// <param name="disposing">true si les ressources managées doivent être supprimées ; sinon, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Code généré par le Concepteur de composants

        /// <summary> 
        /// Méthode requise pour la prise en charge du concepteur - ne modifiez pas 
        /// le contenu de cette méthode avec l'éditeur de code.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.serialPort1 = new System.IO.Ports.SerialPort(this.components);
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.labelDebug_info = new System.Windows.Forms.Label();
            this.labelSolarData = new System.Windows.Forms.Label();
            this.labelWindData = new System.Windows.Forms.Label();
            this.textBoxSolarData = new System.Windows.Forms.TextBox();
            this.textBoxWindData = new System.Windows.Forms.TextBox();
            this.button_start = new System.Windows.Forms.Button();
            this.button_stop = new System.Windows.Forms.Button();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.labelChosenPortName = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.panelCOMLinkConfiguration = new System.Windows.Forms.Panel();
            this.panelStartAndStop = new System.Windows.Forms.Panel();
            this.comboBoxCOMPorts = new System.Windows.Forms.ComboBox();
            this.labelTitle = new System.Windows.Forms.Label();
            this.labelError = new System.Windows.Forms.Label();
            this.panel_debug_info = new System.Windows.Forms.Panel();
            this.labelCorruptFrameNumber = new System.Windows.Forms.Label();
            this.labelTotalFrameNumber = new System.Windows.Forms.Label();
            this.labelCorruptFrameNumberTitle = new System.Windows.Forms.Label();
            this.labelTotalFrameNumberTitle = new System.Windows.Forms.Label();
            this.textBoxDebugInfo = new System.Windows.Forms.TextBox();
            this.panelData = new System.Windows.Forms.Panel();
            this.button1 = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panelCOMLinkConfiguration.SuspendLayout();
            this.panelStartAndStop.SuspendLayout();
            this.panel_debug_info.SuspendLayout();
            this.panelData.SuspendLayout();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // serialPort1
            // 
            this.serialPort1.BaudRate = 115200;
            this.serialPort1.DataReceived += new System.IO.Ports.SerialDataReceivedEventHandler(this.serialPort1_DataReceived);
            // 
            // labelDebug_info
            // 
            this.labelDebug_info.AutoSize = true;
            this.labelDebug_info.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelDebug_info.Location = new System.Drawing.Point(12, 11);
            this.labelDebug_info.Name = "labelDebug_info";
            this.labelDebug_info.Size = new System.Drawing.Size(130, 13);
            this.labelDebug_info.TabIndex = 0;
            this.labelDebug_info.Text = "Informations de débogage";
            // 
            // labelSolarData
            // 
            this.labelSolarData.AutoSize = true;
            this.labelSolarData.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelSolarData.Location = new System.Drawing.Point(19, 13);
            this.labelSolarData.Name = "labelSolarData";
            this.labelSolarData.Size = new System.Drawing.Size(89, 13);
            this.labelSolarData.TabIndex = 1;
            this.labelSolarData.Text = "Données : solaire";
            // 
            // labelWindData
            // 
            this.labelWindData.AutoSize = true;
            this.labelWindData.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelWindData.Location = new System.Drawing.Point(19, 179);
            this.labelWindData.Name = "labelWindData";
            this.labelWindData.Size = new System.Drawing.Size(87, 13);
            this.labelWindData.TabIndex = 2;
            this.labelWindData.Text = "Données : éolien";
            // 
            // textBoxSolarData
            // 
            this.textBoxSolarData.Location = new System.Drawing.Point(22, 29);
            this.textBoxSolarData.Multiline = true;
            this.textBoxSolarData.Name = "textBoxSolarData";
            this.textBoxSolarData.Size = new System.Drawing.Size(280, 124);
            this.textBoxSolarData.TabIndex = 4;
            // 
            // textBoxWindData
            // 
            this.textBoxWindData.Location = new System.Drawing.Point(22, 197);
            this.textBoxWindData.Multiline = true;
            this.textBoxWindData.Name = "textBoxWindData";
            this.textBoxWindData.Size = new System.Drawing.Size(280, 108);
            this.textBoxWindData.TabIndex = 5;
            // 
            // button_start
            // 
            this.button_start.Location = new System.Drawing.Point(10, 11);
            this.button_start.Name = "button_start";
            this.button_start.Size = new System.Drawing.Size(75, 23);
            this.button_start.TabIndex = 6;
            this.button_start.Text = "Start";
            this.button_start.UseVisualStyleBackColor = true;
            this.button_start.Click += new System.EventHandler(this.button1_Click);
            // 
            // button_stop
            // 
            this.button_stop.Location = new System.Drawing.Point(91, 11);
            this.button_stop.Name = "button_stop";
            this.button_stop.Size = new System.Drawing.Size(75, 23);
            this.button_stop.TabIndex = 7;
            this.button_stop.Text = "Stop";
            this.button_stop.UseVisualStyleBackColor = true;
            this.button_stop.Click += new System.EventHandler(this.button2_Click);
            // 
            // labelChosenPortName
            // 
            this.labelChosenPortName.AutoSize = true;
            this.labelChosenPortName.BackColor = System.Drawing.SystemColors.GradientActiveCaption;
            this.labelChosenPortName.Location = new System.Drawing.Point(60, 39);
            this.labelChosenPortName.Name = "labelChosenPortName";
            this.labelChosenPortName.Size = new System.Drawing.Size(82, 13);
            this.labelChosenPortName.TabIndex = 8;
            this.labelChosenPortName.Text = "Port COM utilisé";
            // 
            // label5
            // 
            this.label5.Location = new System.Drawing.Point(0, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(100, 23);
            this.label5.TabIndex = 17;
            // 
            // panelCOMLinkConfiguration
            // 
            this.panelCOMLinkConfiguration.BackColor = System.Drawing.Color.PowderBlue;
            this.panelCOMLinkConfiguration.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panelCOMLinkConfiguration.Controls.Add(this.panelStartAndStop);
            this.panelCOMLinkConfiguration.Controls.Add(this.comboBoxCOMPorts);
            this.panelCOMLinkConfiguration.Controls.Add(this.labelTitle);
            this.panelCOMLinkConfiguration.Controls.Add(this.label5);
            this.panelCOMLinkConfiguration.Controls.Add(this.labelError);
            this.panelCOMLinkConfiguration.Controls.Add(this.labelChosenPortName);
            this.panelCOMLinkConfiguration.Location = new System.Drawing.Point(3, 3);
            this.panelCOMLinkConfiguration.Name = "panelCOMLinkConfiguration";
            this.panelCOMLinkConfiguration.Size = new System.Drawing.Size(323, 133);
            this.panelCOMLinkConfiguration.TabIndex = 13;
            // 
            // panelStartAndStop
            // 
            this.panelStartAndStop.BackColor = System.Drawing.Color.PowderBlue;
            this.panelStartAndStop.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panelStartAndStop.Controls.Add(this.button_start);
            this.panelStartAndStop.Controls.Add(this.button_stop);
            this.panelStartAndStop.Location = new System.Drawing.Point(63, 63);
            this.panelStartAndStop.Name = "panelStartAndStop";
            this.panelStartAndStop.Size = new System.Drawing.Size(176, 45);
            this.panelStartAndStop.TabIndex = 15;
            // 
            // comboBoxCOMPorts
            // 
            this.comboBoxCOMPorts.FormattingEnabled = true;
            this.comboBoxCOMPorts.Location = new System.Drawing.Point(175, 36);
            this.comboBoxCOMPorts.Name = "comboBoxCOMPorts";
            this.comboBoxCOMPorts.Size = new System.Drawing.Size(64, 21);
            this.comboBoxCOMPorts.TabIndex = 15;
            // 
            // labelTitle
            // 
            this.labelTitle.AutoSize = true;
            this.labelTitle.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.labelTitle.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.labelTitle.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTitle.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.labelTitle.Location = new System.Drawing.Point(40, 4);
            this.labelTitle.Name = "labelTitle";
            this.labelTitle.Size = new System.Drawing.Size(218, 22);
            this.labelTitle.TabIndex = 12;
            this.labelTitle.Text = "configuration du lien COM";
            // 
            // labelError
            // 
            this.labelError.AutoSize = true;
            this.labelError.Location = new System.Drawing.Point(69, 112);
            this.labelError.Name = "labelError";
            this.labelError.Size = new System.Drawing.Size(0, 13);
            this.labelError.TabIndex = 16;
            // 
            // panel_debug_info
            // 
            this.panel_debug_info.BackColor = System.Drawing.Color.PowderBlue;
            this.panel_debug_info.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel_debug_info.Controls.Add(this.panel2);
            this.panel_debug_info.Controls.Add(this.panel1);
            this.panel_debug_info.Controls.Add(this.textBoxDebugInfo);
            this.panel_debug_info.Controls.Add(this.labelDebug_info);
            this.panel_debug_info.Location = new System.Drawing.Point(3, 151);
            this.panel_debug_info.Name = "panel_debug_info";
            this.panel_debug_info.Size = new System.Drawing.Size(323, 214);
            this.panel_debug_info.TabIndex = 14;
            // 
            // labelCorruptFrameNumber
            // 
            this.labelCorruptFrameNumber.AutoSize = true;
            this.labelCorruptFrameNumber.Location = new System.Drawing.Point(61, 33);
            this.labelCorruptFrameNumber.Name = "labelCorruptFrameNumber";
            this.labelCorruptFrameNumber.Size = new System.Drawing.Size(13, 13);
            this.labelCorruptFrameNumber.TabIndex = 20;
            this.labelCorruptFrameNumber.Text = "0";
            // 
            // labelTotalFrameNumber
            // 
            this.labelTotalFrameNumber.AutoSize = true;
            this.labelTotalFrameNumber.Location = new System.Drawing.Point(60, 32);
            this.labelTotalFrameNumber.Name = "labelTotalFrameNumber";
            this.labelTotalFrameNumber.Size = new System.Drawing.Size(13, 13);
            this.labelTotalFrameNumber.TabIndex = 19;
            this.labelTotalFrameNumber.Text = "0";
            // 
            // labelCorruptFrameNumberTitle
            // 
            this.labelCorruptFrameNumberTitle.AutoSize = true;
            this.labelCorruptFrameNumberTitle.Location = new System.Drawing.Point(14, 10);
            this.labelCorruptFrameNumberTitle.Name = "labelCorruptFrameNumberTitle";
            this.labelCorruptFrameNumberTitle.Size = new System.Drawing.Size(108, 13);
            this.labelCorruptFrameNumberTitle.TabIndex = 18;
            this.labelCorruptFrameNumberTitle.Text = "Corrupt frame number";
            // 
            // labelTotalFrameNumberTitle
            // 
            this.labelTotalFrameNumberTitle.AutoSize = true;
            this.labelTotalFrameNumberTitle.Location = new System.Drawing.Point(10, 10);
            this.labelTotalFrameNumberTitle.Name = "labelTotalFrameNumberTitle";
            this.labelTotalFrameNumberTitle.Size = new System.Drawing.Size(115, 13);
            this.labelTotalFrameNumberTitle.TabIndex = 17;
            this.labelTotalFrameNumberTitle.Text = "Total number of frames";
            // 
            // textBoxDebugInfo
            // 
            this.textBoxDebugInfo.AcceptsReturn = true;
            this.textBoxDebugInfo.Location = new System.Drawing.Point(15, 33);
            this.textBoxDebugInfo.Multiline = true;
            this.textBoxDebugInfo.Name = "textBoxDebugInfo";
            this.textBoxDebugInfo.Size = new System.Drawing.Size(290, 103);
            this.textBoxDebugInfo.TabIndex = 4;
            // 
            // panelData
            // 
            this.panelData.BackColor = System.Drawing.Color.PowderBlue;
            this.panelData.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panelData.Controls.Add(this.button1);
            this.panelData.Controls.Add(this.textBoxSolarData);
            this.panelData.Controls.Add(this.labelSolarData);
            this.panelData.Controls.Add(this.labelWindData);
            this.panelData.Controls.Add(this.textBoxWindData);
            this.panelData.Location = new System.Drawing.Point(332, 3);
            this.panelData.Name = "panelData";
            this.panelData.Size = new System.Drawing.Size(321, 362);
            this.panelData.TabIndex = 16;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(123, 332);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 7;
            this.button1.Text = "Start";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // panel1
            // 
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel1.Controls.Add(this.labelTotalFrameNumberTitle);
            this.panel1.Controls.Add(this.labelTotalFrameNumber);
            this.panel1.Location = new System.Drawing.Point(17, 142);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(133, 57);
            this.panel1.TabIndex = 8;
            // 
            // panel2
            // 
            this.panel2.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel2.Controls.Add(this.labelCorruptFrameNumberTitle);
            this.panel2.Controls.Add(this.labelCorruptFrameNumber);
            this.panel2.Location = new System.Drawing.Point(156, 142);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(137, 57);
            this.panel2.TabIndex = 8;
            // 
            // UserControlSerialPortReader
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.Controls.Add(this.panelData);
            this.Controls.Add(this.panel_debug_info);
            this.Controls.Add(this.panelCOMLinkConfiguration);
            this.Name = "UserControlSerialPortReader";
            this.Size = new System.Drawing.Size(661, 384);
            this.Load += new System.EventHandler(this.UserControl1_Load);
            this.panelCOMLinkConfiguration.ResumeLayout(false);
            this.panelCOMLinkConfiguration.PerformLayout();
            this.panelStartAndStop.ResumeLayout(false);
            this.panel_debug_info.ResumeLayout(false);
            this.panel_debug_info.PerformLayout();
            this.panelData.ResumeLayout(false);
            this.panelData.PerformLayout();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.IO.Ports.SerialPort serialPort1;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Label labelDebug_info;
        private System.Windows.Forms.Label labelSolarData;
        private System.Windows.Forms.Label labelWindData;
        private System.Windows.Forms.TextBox textBoxSolarData;
        private System.Windows.Forms.TextBox textBoxWindData;
        private System.Windows.Forms.Button button_start;
        private System.Windows.Forms.Button button_stop;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.Label labelChosenPortName;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Panel panelCOMLinkConfiguration;
        private System.Windows.Forms.Label labelTitle;
        private System.Windows.Forms.ComboBox comboBoxCOMPorts;
        private System.Windows.Forms.Panel panel_debug_info;
        private System.Windows.Forms.TextBox textBoxDebugInfo;
        private System.Windows.Forms.Label labelError;
        private System.Windows.Forms.Panel panelStartAndStop;
        private System.Windows.Forms.Panel panelData;
        private System.Windows.Forms.Label labelCorruptFrameNumber;
        private System.Windows.Forms.Label labelTotalFrameNumber;
        private System.Windows.Forms.Label labelCorruptFrameNumberTitle;
        private System.Windows.Forms.Label labelTotalFrameNumberTitle;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel1;
    }
}
