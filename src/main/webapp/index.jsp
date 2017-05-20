<%@include file="includes/header.jsp"%>
<body>

<img src="mm.jpg">

	<div id="searchDiv">
		<form id="searchForm" action="SearchController" method="post">
			<div id="artistaDiv">
			Artista
			<input class="searchArtist" type="text" name="searchArtist" required/>
			</div>
			<div id="cancionDiv">
			Cancion
			<input class="searchSong" type="text" name="searchSong" required/>
			</div>
			<input type="submit" name="searchBtn" id="button" class="btn btn-primary btn-responsive" title="search" value="Buscar">
		</form>
</div>

</body>


<!--  header -->
<%@include file="includes/footer.html"%>


