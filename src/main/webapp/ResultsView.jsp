
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results view</title>
<link rel="stylesheet" type="text/css" href="css/Style_ResultsView.css">

</head>
<body>


 <div class="topnav" id="myTopnav">
  <a id="home" href="index.jsp">Inicio</a>
  <a href="/AuthController/Spotify" title="Es necesario tener 3 playlists creadas">Playlists</a>
</div> 

		
<form class="well">   <!--Este form es para mostrar los dos elementos en linea-->
	<fieldset id="YoutubeField">
			<legend id="YoutubeLegend">Youtube search</legend>
        <div class="video-container">
				<iframe width="500" height="350" src="https://www.youtube.com/embed/${ID}">
				</iframe>
        </div>
				
		</fieldset>
	
	
	
	
		<fieldset id="SpotifyField">
			<legend id="SpotifyLegend">Spotify search</legend>

				<img src="${AlbumIMG}">

			<input type="button" onclick="location.href='https://open.spotify.com/album/${AlbumID}';" value="Información del álbum" style="
    margin-bottom: 5px;" />
		
			<input type="button" onclick="location.href='https://open.spotify.com/artist/${ArtistID}';" value="Información del artista" />
		
		</fieldset>
</form>




<fieldset id="LyricsField">

<legend id="LyricsLegend">MusixMatch search</legend>


<p>${Lyrics}</p>

</fieldset>




<fieldset id="GoogleTranslateField">
<legend id="GoogleTranslateLegend">Google Translate search</legend>

<p>${Translation}</p>

</fieldset>


</body>
</html>