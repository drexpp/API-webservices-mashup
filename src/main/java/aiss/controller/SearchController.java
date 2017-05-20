package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.JSONException;

import aiss.model.Spotify.Item;
import aiss.model.resources.GoogleTranslateResource;
import aiss.model.resources.MusixMatchResource;
import aiss.model.resources.SpotifyResource;
import aiss.model.resources.YouTubeResource;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String artista = request.getParameter("searchArtist");
		String cancion = request.getParameter("searchSong");
		
		request.getSession().setAttribute("artista", artista);
		request.getSession().setAttribute("cancion", cancion);
		
		RequestDispatcher rd = null;
		
	
		

		try {
			
			//Search for video in YouTube
			log.log(Level.FINE,"Searching for YouTube videos of"+artista);
			YouTubeResource youtube = new YouTubeResource();
			String youtubeID = youtube.getId(artista, cancion);
			
			//Search for music in Spotify
			log.log(Level.FINE,"Searching Spotify music of"+artista);
			SpotifyResource spotify = new SpotifyResource();
			Item spotifyResult = spotify.getTrack(artista, cancion);
			
			
			//Search for music in MusixMatch
			log.log(Level.FINE,"Searching Lyrics");
			MusixMatchResource musixMatch = new MusixMatchResource();
			String musixMatchResults = musixMatch.getSongLyrics(artista,cancion);
			
			//Search for music in Google Translate
			log.log(Level.FINE,"Searching trasnlation");
			GoogleTranslateResource translation = new GoogleTranslateResource();
			String TranslateResult = translation.getTranslation(musixMatchResults);
			
			
			
			
			
			if(youtubeID!=null || spotifyResult != null || TranslateResult != null || musixMatchResults != null){

				rd=request.getRequestDispatcher("/ResultsView.jsp");
				request.setAttribute("ID", youtubeID);
				request.setAttribute("AlbumIMG", spotifyResult.getAlbum().getImages().get(1).getUrl());
				request.setAttribute("AlbumID", spotifyResult.getAlbum().getId());
				request.setAttribute("ArtistID", spotifyResult.getArtists().get(0).getId());
				request.setAttribute("Translation", TranslateResult);
				request.setAttribute("Lyrics", musixMatchResults);
			}else{
				rd=request.getRequestDispatcher("/error.jsp"); 
				
			}
			
		} catch (JSONException e) {
			rd = request.getRequestDispatcher("/error.jsp");
		}

		rd.forward(request, response);
		
		

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
