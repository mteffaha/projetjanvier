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
            this.textBoxDebugInfoCOMPort = new System.Windows.Forms.TextBox();
            this.textBoxSolarData = new System.Windows.Forms.TextBox();
            this.textBoxWindData = new System.Windows.Forms.TextBox();
            this.button_start = new System.Windows.Forms.Button();
            this.button_stop = new System.Windows.Forms.Button();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.labelChosenPortName = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.panelCOMLinkConfiguration = new System.Windows.Forms.Panel();
            this.labelError = new System.Windows.Forms.Label();
            this.comboBoxCOMPorts = new System.Windows.Forms.ComboBox();
            this.labelTitle = new System.Windows.Forms.Label();
            this.panel_debug_info = new System.Windows.Forms.Panel();
            this.textBoxDebugInfo = new System.Windows.Forms.TextBox();
            this.panelStartAndStop = new System.Windows.Forms.Panel();
            this.panelData = new System.Windows.Forms.Panel();
            this.panelCOMLinkConfiguration.SuspendLayout();
            this.panel_debug_info.SuspendLayout();
            this.panelStartAndStop.SuspendLayout();
            this.panelData.SuspendLayout();
            this.SuspendLayout();
            // 
            // serialPort1
            // 
            this.serialPort1.BaudRate = 115200;
            this.serialPort1.DataReceived += new System.IO.Ports.SerialDataReceivedEventHandler(this.serialPort1_DataReceived);
            // 
            // label_informations_debogage
            // 
            this.labelDebug_info.AutoSize = true;
            this.labelDebug_info.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelDebug_info.Location = new System.Drawing.Point(12, 11);
            this.labelDebug_info.Name = "label_informations_debogage";
            this.labelDebug_info.Size = new System.Drawing.Size(130, 13);
            this.labelDebug_info.TabIndex = 0;
            this.labelDebug_info.Text = "Informations de débogage";
            // 
            // label_données_solaires
            // 
            this.labelSolarData.AutoSize = true;
            this.labelSolarData.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelSolarData.Location = new System.Drawing.Point(19, 13);
            this.labelSolarData.Name = "label_données_solaires";
            this.labelSolarData.Size = new System.Drawing.Size(87, 13);
            this.labelSolarData.TabIndex = 1;
            this.labelSolarData.Text = "données : solaire";
            // 
            // label_données_éolien
            // 
            this.labelWindData.AutoSize = true;
            this.labelWindData.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelWindData.Location = new System.Drawing.Point(19, 181);
            this.labelWindData.Name = "label_données_éolien";
            this.labelWindData.Size = new System.Drawing.Size(85, 13);
            this.labelWindData.TabIndex = 2;
            this.labelWindData.Text = "données : éolien";
            // 
            // textBox_info_debug_comPORT
            // 
            this.textBoxDebugInfoCOMPort.Location = new System.Drawing.Point(15, 147);
            this.textBoxDebugInfoCOMPort.Multiline = true;
            this.textBoxDebugInfoCOMPort.Name = "textBox_info_debug_comPORT";
            this.textBoxDebugInfoCOMPort.Size = new System.Drawing.Size(290, 103);
            this.textBoxDebugInfoCOMPort.TabIndex = 3;
            // 
            // textBox_données_solaires
            // 
            this.textBoxSolarData.Location = new System.Drawing.Point(22, 29);
            this.textBoxSolarData.Multiline = true;
            this.textBoxSolarData.Name = "textBox_données_solaires";
            this.textBoxSolarData.Size = new System.Drawing.Size(280, 124);
            this.textBoxSolarData.TabIndex = 4;
            // 
            // textBox_données_éolien
            // 
            this.textBoxWindData.Location = new System.Drawing.Point(22, 197);
            this.textBoxWindData.Multiline = true;
            this.textBoxWindData.Name = "textBox_données_éolien";
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
            this.labelChosenPortName.Location = new System.Drawing.Point(12, 39);
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
            // panel_config_lien_COM
            // 
            this.panelCOMLinkConfiguration.BackColor = System.Drawing.Color.PowderBlue;
            this.panelCOMLinkConfiguration.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panelCOMLinkConfiguration.Controls.Add(this.labelError);
            this.panelCOMLinkConfiguration.Controls.Add(this.panelStartAndStop);
            this.panelCOMLinkConfiguration.Controls.Add(this.comboBoxCOMPorts);
            this.panelCOMLinkConfiguration.Controls.Add(this.labelTitle);
            this.panelCOMLinkConfiguration.Controls.Add(this.label5);
            this.panelCOMLinkConfiguration.Controls.Add(this.labelChosenPortName);
            this.panelCOMLinkConfiguration.Location = new System.Drawing.Point(3, 3);
            this.panelCOMLinkConfiguration.Name = "panel_config_lien_COM";
            this.panelCOMLinkConfiguration.Size = new System.Drawing.Size(211, 142);
            this.panelCOMLinkConfiguration.TabIndex = 13;
            // 
            // labelError
            // 
            this.labelError.AutoSize = true;
            this.labelError.Location = new System.Drawing.Point(17, 112);
            this.labelError.Name = "labelError";
            this.labelError.Size = new System.Drawing.Size(0, 13);
            this.labelError.TabIndex = 16;
            // 
            // comboBox_COM_ports
            // 
            this.comboBoxCOMPorts.FormattingEnabled = true;
            this.comboBoxCOMPorts.Location = new System.Drawing.Point(127, 36);
            this.comboBoxCOMPorts.Name = "comboBox_COM_ports";
            this.comboBoxCOMPorts.Size = new System.Drawing.Size(64, 21);
            this.comboBoxCOMPorts.TabIndex = 15;
            // 
            // labelTitle
            // 
            this.labelTitle.AutoSize = true;
            this.labelTitle.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.labelTitle.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.labelTitle.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTitle.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.labelTitle.Location = new System.Drawing.Point(14, 7);
            this.labelTitle.Name = "labelTitle";
            this.labelTitle.Size = new System.Drawing.Size(161, 18);
            this.labelTitle.TabIndex = 12;
            this.labelTitle.Text = "configuration du lien COM";
            // 
            // panel_debug_info
            // 
            this.panel_debug_info.BackColor = System.Drawing.Color.PowderBlue;
            this.panel_debug_info.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel_debug_info.Controls.Add(this.textBoxDebugInfo);
            this.panel_debug_info.Controls.Add(this.labelDebug_info);
            this.panel_debug_info.Controls.Add(this.textBoxDebugInfoCOMPort);
            this.panel_debug_info.Location = new System.Drawing.Point(3, 151);
            this.panel_debug_info.Name = "panel_debug_info";
            this.panel_debug_info.Size = new System.Drawing.Size(323, 268);
            this.panel_debug_info.TabIndex = 14;
            // 
            // textBox_info_debug_interface
            // 
            this.textBoxDebugInfo.AcceptsReturn = true;
            this.textBoxDebugInfo.Location = new System.Drawing.Point(15, 33);
            this.textBoxDebugInfo.Multiline = true;
            this.textBoxDebugInfo.Name = "textBox_info_debug_interface";
            this.textBoxDebugInfo.Size = new System.Drawing.Size(290, 103);
            this.textBoxDebugInfo.TabIndex = 4;
            // 
            // panel_start_stop
            // 
            this.panelStartAndStop.BackColor = System.Drawing.Color.PowderBlue;
            this.panelStartAndStop.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panelStartAndStop.Controls.Add(this.button_start);
            this.panelStartAndStop.Controls.Add(this.button_stop);
            this.panelStartAndStop.Location = new System.Drawing.Point(15, 63);
            this.panelStartAndStop.Name = "panel_start_stop";
            this.panelStartAndStop.Size = new System.Drawing.Size(176, 45);
            this.panelStartAndStop.TabIndex = 15;
            // 
            // panel_donneés
            // 
            this.panelData.BackColor = System.Drawing.Color.PowderBlue;
            this.panelData.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panelData.Controls.Add(this.textBoxSolarData);
            this.panelData.Controls.Add(this.labelSolarData);
            this.panelData.Controls.Add(this.labelWindData);
            this.panelData.Controls.Add(this.textBoxWindData);
            this.panelData.Location = new System.Drawing.Point(400, 3);
            this.panelData.Name = "panel_donneés";
            this.panelData.Size = new System.Drawing.Size(321, 457);
            this.panelData.TabIndex = 16;
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
            this.Size = new System.Drawing.Size(736, 476);
            this.Load += new System.EventHandler(this.UserControl1_Load);
            this.panelCOMLinkConfiguration.ResumeLayout(false);
            this.panelCOMLinkConfiguration.PerformLayout();
            this.panel_debug_info.ResumeLayout(false);
            this.panel_debug_info.PerformLayout();
            this.panelStartAndStop.ResumeLayout(false);
            this.panelData.ResumeLayout(false);
            this.panelData.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.IO.Ports.SerialPort serialPort1;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Label labelDebug_info;
        private System.Windows.Forms.Label labelSolarData;
        private System.Windows.Forms.Label labelWindData;
        private System.Windows.Forms.TextBox textBoxDebugInfoCOMPort;
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
    }
}
