<html>
<meta http-equiv="refresh" content="5" />
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
			
				<div class="menu site<?php echo 1+$i; ?>">
					<a href="<?php echo 1+$i; ?>.php"><?php echo $site->site[$i]->title;?>
					<span><?php echo $site->site[$i]->description;?></span></a>
					  </div>
			<?php } ?>
</div>
</head>

<body>
<table>
<th>
DEMONSTRATION - SITE DE SOPHIA ANTIPOLLIS
</th>
</table>
<table>
<tr>
    <th></th>
    <th>Capteur N&deg;1</th>
    
</tr>
<tr>
    <td>Temp&eacute;rature :</td>
    <td> 23&deg;C</td>
    
</tr>
<tr>
    <td>Signal</td>
    <td><div class="signal-strenght"><div class="signal seven"></div></div></td>
   
</tr>
<tr>
    <td>RSSI</td>
    <td> </td>
    
</tr>
<tr>
    <td>Image vid&eacute;o</td>
    <td><img src="capteur.jpg"></td>
  
</tr>
</table>

<table>
<tr>
	<dl class="csslinegraph">
			
			
			<dd class="first"><span class="pd18 d d8"><em></em></span></dd>	 
			<dd><span class="pi10 i1"><em></em></span></dd>	
			<dd><span class="pd11 d d4"><em></em></span></dd>	
			<dd><span class="pi7 i10"><em></em></span></dd>	
			<dd><span class="pd17 d d0"><em></em></span></dd>	
			<dd><span class="pd17 d d7"><em></em></span></dd>		
			<dd><span class="pi10 i14"><em></em></span></dd>	
			<dd><span class="pd24 d d2"><em></em></span></dd>	
			<dd><span class="pi22 i1"><em></em></span></dd>	
			<dd><span class="pi23 i2"><em></em></span></dd>	
			<dd><span class="pd25 d d15"><em></em></span></dd>
			<dd><span class="pi10 i2"><em></em></span></dd>											
					
		</dl>
</tr>
</table>
<br />
<table>
<tr>
    <th></th>
    <th>Capteur N&deg;2</th>
    
</tr>
<tr>
    <td>Temp&eacute;rature :</td>
    <td> 23&deg;C</td>
    
</tr>

<tr>
    <td>Signal</td>
    <td><div class="signal-strenght"><div class="signal nine"></div></div></td>
   
</tr>
<tr>
    <td>RSSI</td>
    <td> </td>
    
</tr>
<tr>
    <td>Image vid&eacute;o</td>
    <td><img src="capteur.jpg"></td>
  
</tr>
</table>
<table>
<tr>
	<dl class="csslinegraph">
			
			
			<dd class="first"><span class="pi1 i0"><em></em></span></dd>	 
			<dd><span class="pi1 i1"><em></em></span></dd>	
			<dd><span class="pd2 d d0"><em></em></span></dd>	
			<dd><span class="pi2 i10"><em></em></span></dd>	
			<dd><span class="pd12 d d0"><em></em></span></dd>	
			<dd><span class="pd12 d d2"><em></em></span></dd>		
			<dd><span class="pi10 i2"><em></em></span></dd>	
			<dd><span class="pd12 d d2"><em></em></span></dd>	
			<dd><span class="pi10 i1"><em></em></span></dd>	
			<dd><span class="pi11 i2"><em></em></span></dd>	
			<dd><span class="pd13 d d5"><em></em></span></dd>
			<dd><span class="pi8 i0"><em></em></span></dd>											
					
		</dl>
</tr>
</table>

<br />

</body>
</html>