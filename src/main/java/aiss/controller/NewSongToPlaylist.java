package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyResource;

public class NewSongToPlaylist extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSongToPlaylist() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String artista = request.getSession().getAttribute("artista").toString();
		String cancion = request.getSession().getAttribute("cancion").toString();
		
		String playlist1uri =  request.getParameter("playlist0");
		String playlist2uri =  request.getParameter("playlist1");
		String playlist3uri =  request.getParameter("playlist2");

		
		
		
		
		
		RequestDispatcher rd = null;
		
		String accessToken = (String)request.getSession().getAttribute("Spotify-token");
		System.out.println("Token usado: " + accessToken);
		
		if(accessToken != null && !"".equals(accessToken)){
			SpotifyResource spotify = new SpotifyResource(accessToken);
			String songUri = spotify.getTrack(artista, cancion).getUri();
			log.log(Level.FINE,"The song uri to add to playlist is: "+ songUri);
			
			if(playlist1uri != null && !"".equals(playlist1uri)){
				spotify.addSong(songUri, playlist1uri);
			}
			if(playlist2uri != null && !"".equals(playlist2uri)){
				spotify.addSong(songUri, playlist2uri);
			}
			if(playlist3uri != null && !"".equals(playlist3uri)){
				spotify.addSong(songUri, playlist3uri);
			}

			String message = "La cancion se ha añadido a tu playlist";
			
			request.setAttribute("message2", message);
			rd = request.getRequestDispatcher("/PlaylistController");
			
		}else{
			rd = request.getRequestDispatcher("/error.jsp");
			System.err.println("The token is not working properly, either null or empty string");
			log.log(Level.SEVERE,"The token is not working properly");
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
