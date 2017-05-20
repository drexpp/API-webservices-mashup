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

public class NewPlaylistController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPlaylistController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher rd = null;
		
		String accessToken = (String)request.getSession().getAttribute("Spotify-token");
		System.out.println("Token usado: " + accessToken);
		
		if(accessToken != null && !"".equals(accessToken)){
			SpotifyResource spotify = new SpotifyResource(accessToken);
			spotify.createPlaylist();
			String message = "La playlist se ha creado";
			
			request.setAttribute("message", message);
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
