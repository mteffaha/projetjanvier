<?php




class NodeManAPI  {
	
		/*
	 	 * Data Base credential
	 	 */
		const DB_SERVER = "mysql1.alwaysdata.com";
		const DB_USER = "razielone";
		const DB_PASSWORD = "jesuisla1";
		const DB = "razielone_nodeman";
		
		
		private $dbconnection = NULL;
		
		/*
		 * Header Related variables
		 */
		private $content_type = "text/xml";
		
		
		private $status = array(
						100 => 'Continue',  
						101 => 'Switching Protocols',  
						200 => 'OK',
						201 => 'Created',  
						202 => 'Accepted',  
						203 => 'Non-Authoritative Information',  
						204 => 'No Content',  
						205 => 'Reset Content',  
						206 => 'Partial Content',  
						300 => 'Multiple Choices',  
						301 => 'Moved Permanently',  
						302 => 'Found',  
						303 => 'See Other',  
						304 => 'Not Modified',  
						305 => 'Use Proxy',  
						306 => '(Unused)',  
						307 => 'Temporary Redirect',  
						400 => 'Bad Request',  
						401 => 'Unauthorized',  
						402 => 'Payment Required',  
						403 => 'Forbidden',  
						404 => 'Not Found',  
						405 => 'Method Not Allowed',  
						406 => 'Not Acceptable',  
						407 => 'Proxy Authentication Required',  
						408 => 'Request Timeout',  
						409 => 'Conflict',  
						410 => 'Gone',  
						411 => 'Length Required',  
						412 => 'Precondition Failed',  
						413 => 'Request Entity Too Large',  
						414 => 'Request-URI Too Long',  
						415 => 'Unsupported Media Type',  
						416 => 'Requested Range Not Satisfiable',  
						417 => 'Expectation Failed',  
						500 => 'Internal Server Error',  
						501 => 'Not Implemented',  
						502 => 'Bad Gateway',  
						503 => 'Service Unavailable',  
						504 => 'Gateway Timeout',  
						505 => 'HTTP Version Not Supported');
		
		
		
		public function __construct(){
				// DB Connnection
			$this->dbconnection = mysql_connect(self::DB_SERVER,self::DB_USER,self::DB_PASSWORD);
			if($this->dbconnection){
				mysql_select_db(self::DB,$this->dbconnection);
			}
			 
		}
		
		
		
		// Runs the API
		public function processAPI(){
			
			if(isset($_GET['oper'])){
				$func = $_GET["oper"];
				if(method_exists($this,$func)){
					$this->$func();
				}else{
					$this->response('',404);
				}
			}else{
				$xml = new SimpleXMLElement("<response/>");
				$this->response($xml->asXML(),200);
			}
				
		}
		
		
		
		
		/*
		 * Writes the response
		 */
		private function response($response,$code){
			header("HTTP/1.1 ".$code." ".$status[$code]);
			header("Content-Type:".$this->_content_type);
		
			echo $response;	
			exit;
		}
		
		
		
		
		/*
		 * 
		 * Service related functions 
		 */
		 
		
		
		
		
		private function getListSites(){
				$sql = mysql_query("SELECT id, title,description  FROM sites", $this->dbconnection);
				$xml = new SimpleXMLElement('<response/>');
				if(mysql_num_rows($sql) > 0){
					while($rlt = mysql_fetch_array($sql,MYSQL_ASSOC)){
						// Generating childs									
						$site= $xml->addChild('site');
						$site->addChild("id",$rlt["id"]);
						$site->addChild("title",$rlt["title"]);
						$site->addChild("description",$rlt["description"]);
					}
					$this->response($xml->asXML(), 200); // return the formated xml			
				}
				
				$this->response('',204); // return No Content Status
		 }
		
		
		private function getListStations(){
				
			$siteid =$_GET["siteid"];
			$sql = mysql_query("SELECT id, title FROM stations where site_id=".$siteid,$this->dbconnection);
			$xml = new SimpleXMLElement('<response/>');
			if(mysql_num_rows($sql) > 0){
				while($rlt = mysql_fetch_array($sql,MYSQL_ASSOC)){
					$station = $xml->addChild('station');
					$station->addChild('id',$rlt['id']);
					$station->addChild('title',$rlt['title']);
					$station->addChild('siteid',$sideid);
				}
				// If success everythig is good send header as "OK" and return list of users in JSON format
				
			}
			$this->response($xml->asXML(), 200);
		}
		
		private function getSensorInfos(){
				$xml = new SimpleXMLElement("<response/>");
				if(!isset($_GET["stationid"])){
					$xml->addChild("error","Missing GET Attributes : stationid");
					$this->response($xml->asXML(),400);
					
				}
				$stationid =$_GET["stationid"];
				
				if($stationid != 99){
						
						$sql = mysql_query("SELECT type,period,charge,temp,rssi FROM info where station_id=".$stationid,$this->dbconnection);
						
						if(mysql_num_rows($sql) > 0){
							$rlt = mysql_fetch_array($sql,MYSQL_ASSOC);
							
							$sensorinfo = $xml->addChild("sensorinfo");
							
							$id 			= $stationid;
							$sensorinfo->addChild('type',$rlt['type']);
							$sensorinfo->addChild('period',$rlt['period']);
							$sensorinfo->addChild('charge',$rlt['charge']);
							$sensorinfo->addChild('temp',$rlt['temp']);
							$sensorinfo->addChild('rssi',$rlt['rssi']);
							$sensorinfo->addChild('id',''.$id."");  
							
							
						}
												
					}else{
					
					$id = $i;
					$type = rand(0,1);
					$period =rand(10,90);
					$soc = rand(0,100);
					$temperature =  rand(0,100);
					$rssi = rand(0,100);
					
					$sensorinfo = $xml->addChild("sensorinfo");
					
					$sensorinfo->addChild("id",99);
					$sensorinfo->addChild("type",$type);
					$sensorinfo->addChild("periode",$period);
					$sensorinfo->addChild("temperature",$temperature);
					$sensorinfo->addChild("soc",$soc);
					$sensorinfo->addChild("rssi",$rssi);
					  
					 
					 }
					 $this->response($xml->asXML(), 200);
			
		}		
		
		
		private function getOneSensorInfo(){
				$xml = new SimpleXMLElement("<response/>");
			
				$stationid =$_GET["sensorid"];
				
				
					
				
				
			
					$id = $stationid;
					$type = rand(0,1);
					$period =rand(10,90);
					$soc = rand(0,100);
					$temperature =  rand(0,100);
					$rssi = rand(0,100);
					  
					
					
					$sensorinfo = $xml->addChild("sensorinfo");
					
					
					$sensorinfo->addChild("type",$type);
					$sensorinfo->addChild("periode",$period);
					$sensorinfo->addChild("temperature",$temperature);
					$sensorinfo->addChild("soc",$soc);
					$sensorinfo->addChild("rssi",$rssi);
					$sensorinfo->addChild("id",99);
				
					  
					 
					 
					 $this->response($xml->asXML(), 200);
			
		}	
		
		
		
		
		

  			private function createSite(){
  				$xml = new SimpleXMLElement("<response/>");
  				if(!isset($_POST["title"]) || !isset($_POST["description"])){
					$xml->addChild("error","Missing POST Attributes : Title or description");
					$this->response($xml->asXML(),400);
  				}
				
				$title = $_POST["title"];
				$description = $_POST["description"];
				
				
				if(mysql_query("insert into sites(description,title) values('".$description."','".$title."')")){
					$xml->addChild("Success","Operation succeeded");				
				}else{ 
					$xml->addChild("error","A Database related error occured");		
					$xml->addChild("request","insert into sites(description,title) values('".$description.",".$title."')");			
				}
				
				$this->response($xml->asXML(),200);
		  }

   
  			private function addStation(){
  				$xml = new SimpleXMLElement("<response/>");	
  				if(!isset($_POST['siteid']) || !isset($_POST["description"])){
  					$xml->addChild("error","Missing POST Attributes : siteid");
  				}   
				
				$siteID= $_POST["siteid"];
				$description=$_POST["description"];
				
				if(mysql_query("insert into stations(title,site_id) values('".$description."',".$siteID.")")){
					$xml->addChild("Success","Operation succeeded");				
				}else{
					$xml->addChild("error","A Database related error occured");					
				}
				$this->response($xml->asXML(), 200);
				
			  }
			
			
			
			
			
			
			private function updateSensor(){
				$xml = new SimpleXMLElement("<response/>");	
  				if(
                   !isset($_POST["type"])||
                   !isset($_POST["wakeUpPeriod"])||
                   !isset($_POST["stateOfCharge"])||
                   !isset($_POST["temperature"])||
                   !isset($_POST["RSSI"])){
  					$xml->addChild("error","Missing POST Attributes : stationId, id,type,wakeupPeriod,stateofcharge,temperature,RSSI");
  					$this->response($xml->asXML(),400);
  				}   
  				
				// TODO Check if ID exists otherwise create it
				
                $type			=	$_POST["type"];
                $wakeUpPeriod	=	$_POST["wakeUpPeriod"];
                $stateOfCharg	=	$_POST["stateOfCharge"];
                $temperature	=	$_POST["temperature"];
                $RSSI			=	$_POST["RSSI"];
				
				
				/*
				 *  type,period,charge,temp,rssi 
				 * 
				 * mysql_query("update infos SET period=".$wakeUpPeriod.", charge=".$stateOfCharg." ,temp=".$temperature.", rssi=".$RSSI." WHERE type=".$type)
				 */
				// TODO Implement Update Logic
				/*
				if(mysql_query("insert into infos values(".$stationID+",".$type+","
								.$wakeUpPeriod+",".$stateOfCharge+",".$temperature+",".$RSSI+",TIMESTAMP())")){
					$xml->addChild("Success","Operation succeeded");				
				}else{
					$xml->addChild("error","A Database related error occured");					
				}
				 */
				 
				 if(mysql_query("update info SET period=".$wakeUpPeriod.", charge=".$stateOfCharg." ,temp=".$temperature.", rssi=".$RSSI." WHERE type=".$type)){
					$xml->addChild("Success","Operation succeeded");				
				}else{
					$xml->addChild("error","A Database related error occured".mysql_error());					
				}
				 
				$this->response($xml->asXML(),200);
				
				}
		
}
		

$API = new NodeManAPI();
$API->processAPI();
?>
