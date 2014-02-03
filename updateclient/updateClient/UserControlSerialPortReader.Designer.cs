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
            this.label_informations_debogage = new System.Windows.Forms.Label();
            this.label_données_solaires = new System.Windows.Forms.Label();
            this.label_données_éolien = new System.Windows.Forms.Label();
            this.textBox_info_debug_comPORT = new System.Windows.Forms.TextBox();
            this.textBox_données_solaires = new System.Windows.Forms.TextBox();
            this.textBox_données_éolien = new System.Windows.Forms.TextBox();
            this.button_start = new System.Windows.Forms.Button();
            this.button_stop = new System.Windows.Forms.Button();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.textBox_baudRate = new System.Windows.Forms.TextBox();
            this.panel_config_lien_COM = new System.Windows.Forms.Panel();
            this.label_erreur_connexion = new System.Windows.Forms.Label();
            this.comboBox_COM_ports = new System.Windows.Forms.ComboBox();
            this.label6 = new System.Windows.Forms.Label();
            this.panel_debug_info = new System.Windows.Forms.Panel();
            this.textBox_info_debug_interface = new System.Windows.Forms.TextBox();
            this.panel_start_stop = new System.Windows.Forms.Panel();
            this.panel_donneés = new System.Windows.Forms.Panel();
            this.panel_config_lien_COM.SuspendLayout();
            this.panel_debug_info.SuspendLayout();
            this.panel_start_stop.SuspendLayout();
            this.panel_donneés.SuspendLayout();
            this.SuspendLayout();
            // 
            // serialPort1
            // 
            this.serialPort1.BaudRate = 115200;
            this.serialPort1.DataReceived += new System.IO.Ports.SerialDataReceivedEventHandler(this.serialPort1_DataReceived);
            // 
            // label_informations_debogage
            // 
            this.label_informations_debogage.AutoSize = true;
            this.label_informations_debogage.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label_informations_debogage.Location = new System.Drawing.Point(12, 11);
            this.label_informations_debogage.Name = "label_informations_debogage";
            this.label_informations_debogage.Size = new System.Drawing.Size(130, 13);
            this.label_informations_debogage.TabIndex = 0;
            this.label_informations_debogage.Text = "Informations de débogage";
            // 
            // label_données_solaires
            // 
            this.label_données_solaires.AutoSize = true;
            this.label_données_solaires.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label_données_solaires.Location = new System.Drawing.Point(19, 13);
            this.label_données_solaires.Name = "label_données_solaires";
            this.label_données_solaires.Size = new System.Drawing.Size(87, 13);
            this.label_données_solaires.TabIndex = 1;
            this.label_données_solaires.Text = "données : solaire";
            // 
            // label_données_éolien
            // 
            this.label_données_éolien.AutoSize = true;
            this.label_données_éolien.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label_données_éolien.Location = new System.Drawing.Point(19, 181);
            this.label_données_éolien.Name = "label_données_éolien";
            this.label_données_éolien.Size = new System.Drawing.Size(85, 13);
            this.label_données_éolien.TabIndex = 2;
            this.label_données_éolien.Text = "données : éolien";
            // 
            // textBox_info_debug_comPORT
            // 
            this.textBox_info_debug_comPORT.Location = new System.Drawing.Point(15, 147);
            this.textBox_info_debug_comPORT.Multiline = true;
            this.textBox_info_debug_comPORT.Name = "textBox_info_debug_comPORT";
            this.textBox_info_debug_comPORT.Size = new System.Drawing.Size(290, 103);
            this.textBox_info_debug_comPORT.TabIndex = 3;
            // 
            // textBox_données_solaires
            // 
            this.textBox_données_solaires.Location = new System.Drawing.Point(22, 29);
            this.textBox_données_solaires.Multiline = true;
            this.textBox_données_solaires.Name = "textBox_données_solaires";
            this.textBox_données_solaires.Size = new System.Drawing.Size(280, 124);
            this.textBox_données_solaires.TabIndex = 4;
            // 
            // textBox_données_éolien
            // 
            this.textBox_données_éolien.Location = new System.Drawing.Point(22, 197);
            this.textBox_données_éolien.Multiline = true;
            this.textBox_données_éolien.Name = "textBox_données_éolien";
            this.textBox_données_éolien.Size = new System.Drawing.Size(280, 108);
            this.textBox_données_éolien.TabIndex = 5;
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
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.BackColor = System.Drawing.SystemColors.GradientActiveCaption;
            this.label4.Location = new System.Drawing.Point(12, 42);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(82, 13);
            this.label4.TabIndex = 8;
            this.label4.Text = "Port COM utilisé";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.BackColor = System.Drawing.Color.DarkOrange;
            this.label5.Location = new System.Drawing.Point(12, 66);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(113, 13);
            this.label5.TabIndex = 9;
            this.label5.Text = "Vitesse du lien (bauds)";
            // 
            // textBox_baudRate
            // 
            this.textBox_baudRate.Location = new System.Drawing.Point(140, 66);
            this.textBox_baudRate.Name = "textBox_baudRate";
            this.textBox_baudRate.Size = new System.Drawing.Size(64, 20);
            this.textBox_baudRate.TabIndex = 11;
            this.textBox_baudRate.Text = "115200";
            // 
            // panel_config_lien_COM
            // 
            this.panel_config_lien_COM.BackColor = System.Drawing.Color.PowderBlue;
            this.panel_config_lien_COM.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel_config_lien_COM.Controls.Add(this.label_erreur_connexion);
            this.panel_config_lien_COM.Controls.Add(this.comboBox_COM_ports);
            this.panel_config_lien_COM.Controls.Add(this.label6);
            this.panel_config_lien_COM.Controls.Add(this.textBox_baudRate);
            this.panel_config_lien_COM.Controls.Add(this.label5);
            this.panel_config_lien_COM.Controls.Add(this.label4);
            this.panel_config_lien_COM.Location = new System.Drawing.Point(3, 3);
            this.panel_config_lien_COM.Name = "panel_config_lien_COM";
            this.panel_config_lien_COM.Size = new System.Drawing.Size(211, 142);
            this.panel_config_lien_COM.TabIndex = 13;
            // 
            // label_erreur_connexion
            // 
            this.label_erreur_connexion.AutoSize = true;
            this.label_erreur_connexion.Location = new System.Drawing.Point(15, 96);
            this.label_erreur_connexion.Name = "label_erreur_connexion";
            this.label_erreur_connexion.Size = new System.Drawing.Size(0, 13);
            this.label_erreur_connexion.TabIndex = 16;
            // 
            // comboBox_COM_ports
            // 
            this.comboBox_COM_ports.FormattingEnabled = true;
            this.comboBox_COM_ports.Location = new System.Drawing.Point(140, 42);
            this.comboBox_COM_ports.Name = "comboBox_COM_ports";
            this.comboBox_COM_ports.Size = new System.Drawing.Size(64, 21);
            this.comboBox_COM_ports.TabIndex = 15;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.label6.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.label6.Location = new System.Drawing.Point(9, 7);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(161, 18);
            this.label6.TabIndex = 12;
            this.label6.Text = "configuration du lien COM";
            // 
            // panel_debug_info
            // 
            this.panel_debug_info.BackColor = System.Drawing.Color.PowderBlue;
            this.panel_debug_info.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel_debug_info.Controls.Add(this.textBox_info_debug_interface);
            this.panel_debug_info.Controls.Add(this.label_informations_debogage);
            this.panel_debug_info.Controls.Add(this.textBox_info_debug_comPORT);
            this.panel_debug_info.Location = new System.Drawing.Point(3, 151);
            this.panel_debug_info.Name = "panel_debug_info";
            this.panel_debug_info.Size = new System.Drawing.Size(323, 268);
            this.panel_debug_info.TabIndex = 14;
            // 
            // textBox_info_debug_interface
            // 
            this.textBox_info_debug_interface.AcceptsReturn = true;
            this.textBox_info_debug_interface.Location = new System.Drawing.Point(15, 33);
            this.textBox_info_debug_interface.Multiline = true;
            this.textBox_info_debug_interface.Name = "textBox_info_debug_interface";
            this.textBox_info_debug_interface.Size = new System.Drawing.Size(290, 103);
            this.textBox_info_debug_interface.TabIndex = 4;
            // 
            // panel_start_stop
            // 
            this.panel_start_stop.BackColor = System.Drawing.Color.PowderBlue;
            this.panel_start_stop.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel_start_stop.Controls.Add(this.button_start);
            this.panel_start_stop.Controls.Add(this.button_stop);
            this.panel_start_stop.Location = new System.Drawing.Point(220, 3);
            this.panel_start_stop.Name = "panel_start_stop";
            this.panel_start_stop.Size = new System.Drawing.Size(176, 45);
            this.panel_start_stop.TabIndex = 15;
            // 
            // panel_donneés
            // 
            this.panel_donneés.BackColor = System.Drawing.Color.PowderBlue;
            this.panel_donneés.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panel_donneés.Controls.Add(this.textBox_données_solaires);
            this.panel_donneés.Controls.Add(this.label_données_solaires);
            this.panel_donneés.Controls.Add(this.label_données_éolien);
            this.panel_donneés.Controls.Add(this.textBox_données_éolien);
            this.panel_donneés.Location = new System.Drawing.Point(400, 3);
            this.panel_donneés.Name = "panel_donneés";
            this.panel_donneés.Size = new System.Drawing.Size(321, 457);
            this.panel_donneés.TabIndex = 16;
            // 
            // UserControl1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.Controls.Add(this.panel_donneés);
            this.Controls.Add(this.panel_start_stop);
            this.Controls.Add(this.panel_debug_info);
            this.Controls.Add(this.panel_config_lien_COM);
            this.Name = "UserControl1";
            this.Size = new System.Drawing.Size(736, 476);
            this.Load += new System.EventHandler(this.UserControl1_Load);
            this.panel_config_lien_COM.ResumeLayout(false);
            this.panel_config_lien_COM.PerformLayout();
            this.panel_debug_info.ResumeLayout(false);
            this.panel_debug_info.PerformLayout();
            this.panel_start_stop.ResumeLayout(false);
            this.panel_donneés.ResumeLayout(false);
            this.panel_donneés.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.IO.Ports.SerialPort serialPort1;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Label label_informations_debogage;
        private System.Windows.Forms.Label label_données_solaires;
        private System.Windows.Forms.Label label_données_éolien;
        private System.Windows.Forms.TextBox textBox_info_debug_comPORT;
        private System.Windows.Forms.TextBox textBox_données_solaires;
        private System.Windows.Forms.TextBox textBox_données_éolien;
        private System.Windows.Forms.Button button_start;
        private System.Windows.Forms.Button button_stop;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textBox_baudRate;
        private System.Windows.Forms.Panel panel_config_lien_COM;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.ComboBox comboBox_COM_ports;
        private System.Windows.Forms.Panel panel_debug_info;
        private System.Windows.Forms.TextBox textBox_info_debug_interface;
        private System.Windows.Forms.Label label_erreur_connexion;
        private System.Windows.Forms.Panel panel_start_stop;
        private System.Windows.Forms.Panel panel_donneés;
    }
}
