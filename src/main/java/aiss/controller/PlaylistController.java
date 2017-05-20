package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyResource;


public class PlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaylistController() {
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
			List<aiss.model.SpotifyPlaylists.Item> listaPlaylists = spotify.getPlaylists();
			
			
			
			if(listaPlaylists.get(0) != null && listaPlaylists.get(1) != null && listaPlaylists.get(2) != null){
				request.setAttribute("Playlist0Name", listaPlaylists.get(0).getName());
				request.setAttribute("PlaylistUri0", listaPlaylists.get(0).getId());
				request.setAttribute("OwnerId0", listaPlaylists.get(0).getOwner().getId());
				
				
				request.setAttribute("Playlist1Name", listaPlaylists.get(1).getName());
				request.setAttribute("PlaylistUri1", listaPlaylists.get(1).getId());
				request.setAttribute("OwnerId1", listaPlaylists.get(1).getOwner().getId());
				
				request.setAttribute("Playlist2Name", listaPlaylists.get(2).getName());
				request.setAttribute("PlaylistUri2", listaPlaylists.get(2).getId());
				request.setAttribute("OwnerId2", listaPlaylists.get(2).getOwner().getId());
				
				
				
				rd=request.getRequestDispatcher("/PlaylistView.jsp");
			}else{
				log.log(Level.SEVERE,"You need at least 3 playlist created");
				rd=request.getRequestDispatcher("/error.jsp"); 
			}
			
			
			
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
