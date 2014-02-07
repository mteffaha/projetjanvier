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
Pr&eacute;sentation du projet
</th>
<tr>
<td>
<p></br>Le laboratoire LEAT (Laboratoire d&rsquo;Electronique, Antennes et T&eacute;l&eacute;communications) est un laboratoire de l&rsquo;Universit&eacute; Nice-Sophia Antipolis disposant d&rsquo;un r&eacute;seau de capteurs pouvant mesurer et transmettre des informations.
  Ces capteurs ont &eacute;t&eacute; con&ccedil;us pour fonctionner avec un minimum d&rsquo;&eacute;nergie et sont reli&eacute;s &agrave; des sources d&rsquo;&eacute;nergie renouvelables (Panneau solaire, &eacute;olienne, etc). 
 Chaque capteur communique sans fil &agrave; une station de base elle m&ecirc;me reli&eacute;e par USB &agrave; un ordinateur. Celui-ci affiche ensuite les informations en temps r&eacute;el.</p>
</br><img src="presentation.jpg" /></br><p>
L&rsquo;objectif du projet est dans un premier temps d&rsquo;&eacute;tendre la port&eacute;e de ces donn&eacute;es afin d&rsquo;&ecirc;tre accessible de l&rsquo;ext&eacute;rieur,  notamment depuis un portable ou une tablette tournant sous Android.
  Le projet consistait &eacute;galement &agrave; impl&eacute;menter une multitude de fonctionnalit&eacute;s non pr&eacute;sentes dans l&rsquo;application originale :  Stockage des informations, gestion de plusieurs stations de base et de plusieurs laboratoires, interface web, etc.
  Enfin, il &eacute;tait propos&eacute; d&rsquo;&eacute;tudier puis d&rsquo;impl&eacute;menter l&rsquo;ajout d&rsquo;une cam&eacute;ra aux capteurs afin de transmettre des images  (Cependant, en raison de soucis techniques, ce fut finalement impossible)
 
</p>
<br></br>
</td></tr>
</table>

<br />

</body>
</html>