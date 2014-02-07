<html>
<meta http-equiv="refresh" content="1" />
<link type="text/css" rel="stylesheet" href="capteur.css" />
<link href="csslinegraph/csslinegraph.css" rel="stylesheet" type="text/css" media="screen" />
<head>
<div class="nav">
<div class="menu home">
    <a href="index.php"> Information
    <span>Projet capteur</span></a>
     </div>
<div class="menu demo">
    <a href="demo.php"> D&eacute;monstration
   <span>Temp&eacute;rature moyenne : 23&deg;C
		<br />Nombre de capteur : 2</span></a>
      </div>
	  
	  	<?php
		
			$site_url = "http://razielone.alwaysdata.net/?oper=getListSites";
			$station_url = "http://razielone.alwaysdata.net/?oper=getListStations&siteid=";
			$sensor_url ="http://razielone.alwaysdata.net/?oper=getSensorInfos&stationid=";
			$sites= simplexml_load_file($site_url);
		
			
			
			for($i=0;$i<$sites->site->count();$i++){ ?>
			
				<div class="menu site<?php echo 1+$i;?>">
					<a href="<?php echo 1+$i; ?>.php"><?php echo $site->site[$i]->title;?>
					<span><?php echo $site->site[$i]->description;?></span></a>
					  </div>
			<?php } ?>
</div>
</head>

<body>
<table>
<th>
<?php echo $site->site[$i]->title;?>
</th>
</table>
<?php for($i=0;$i<$sites->site->count();$i++){ 
							$stations=simplexml_load_file($station_url.$sites->site[$i]->id);
							for($j=0;$j< $stations->station->count();$j++){
							?>
								<table><th>Station <?php echo $stations->station[$j]->id;?>
								</th></table>
										<?php
										$sensors = simplexml_load_file($sensor_url.$stations->station[$j]->id);
										for($k=0;$k< $sensors->sensorinfo->count();$k++){
										?>
															<table>
															<tr>
																<th></th>
																<th>Capteur N&deg;<?php echo $k; ?></th>
																
															</tr>
															<tr>
																<td>ID:</td>
																<td> <?php echo $sensors->sensorinfo[$k]->id;?></td>
																
															</tr>
															<tr>
																<td>Type:</td>
																<td> <?php echo $sensors->sensorinfo[$k]->type;?></td>
																
															</tr>
															<tr>
																<td>Periode :</td>
																<td><?php echo $sensors->sensorinfo[$k]->periode;?></td>
															   
															</tr>
															<tr>
																<td>Temperature</td>
																<td><?php echo $sensors->sensorinfon[$k]->temperature;?></td>
															   
															</tr>
															<tr>
																<td>Soc</td>
																<td><?php echo $sensors->sensorinfo[$k]->soc;?> </td>
																
															</tr>
															<tr>
																<td>RSSI</td>
																<td><?php echo $sensors->sensorinfo[$k]->rssi;?></td>
															  
															</tr>
															</table>

										
										<?php
										}
										}
										?>
									</div>
								</li>
							<?php
							}
						?>

<br />

</body>
</html>