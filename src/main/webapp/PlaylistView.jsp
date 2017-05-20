<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<title>Spotify playlist's search</title>
<link rel="stylesheet" type="text/css" href="css/Style_PlaylistView.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

 <div class="topnav" id="myTopnav">
  <a id="home" href="index.jsp">Inicio</a>
  <a href="/PlaylistController">Playlists</a>
</div>


<p>${message}</p>
<p>${message2}</p>


<div class="row" style="margin-left: 20px; margin-top: 25px;">

<div class="col-sm-4">
  <h3>${Playlist0Name}</h3>
<iframe id="playlist" src="https://open.spotify.com/embed?uri=spotify:user:${OwnerId0}:playlist:${PlaylistUri0}" width="400" height="500" frameborder="0" ></iframe>

<form action="/NewSongToPlaylist">
<input type="hidden" name="playlist0" value="${PlaylistUri0}">
<button type="submit" class="buttonCancion">Agregar cancion a playlist 1</button>

</form>
</div>


<div class="col-sm-4">
<h3>${Playlist1Name}</h3>
<iframe id="playlist" src="https://open.spotify.com/embed?uri=spotify:user:${OwnerId1}:playlist:${PlaylistUri1}" width="400" height="500" frameborder="0" ></iframe>

<form action="/NewSongToPlaylist">
<input type="hidden" name="playlist1" value="${PlaylistUri1}">
<button type="submit" class="buttonCancion">Agregar cancion a playlist 2</button>

</form>
</div>


<div class="col-sm-4">
  <h3>${Playlist2Name}</h3>
<iframe id="playlist" src="https://open.spotify.com/embed?uri=spotify:user:${OwnerId2}:playlist:${PlaylistUri2}" width="400" height="500" frameborder="0" ></iframe>

<form action="/NewSongToPlaylist">
<input type="hidden" name="playlist2" value="${PlaylistUri2}">
<button type="submit" class="buttonCancion">Agregar cancion a playlist 3</button>

</form>
</div>
</div>

<form class="NewPlaylist" action="/NewPlaylistController">

<button class="button" type="submit"><span>
    Agregar nueva playlist</span></button>

</form>





</body>
</html>
