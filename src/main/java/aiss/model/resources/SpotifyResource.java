package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Spotify.Item;
import aiss.model.Spotify.SearchSpotify;
import aiss.model.SpotifyPlaylists.SpotifyPlaylistsSearch;
import aiss.model.SpotifyUser.SpotifyUserSearch;



public class SpotifyResource {

	
	private static final Logger log = Logger.getLogger(YouTubeResource.class.getName());
	
	private String access_token = null;
	private String id = null;
	
	public SpotifyResource(String access_token){
		this.access_token = access_token;
		this.id = userId();
	}

	public SpotifyResource() {
		super();
	}

	public String userId() {
		String userId = null;
		
		ClientResource cr = null;
		
		try{
			cr = new ClientResource("https://api.spotify.com/v1/me");
			
			cr.setEntityBuffering(true);
			
			ChallengeResponse challengeResponse = new ChallengeResponse(new ChallengeScheme("Authorization", ""));
			challengeResponse.setRawValue("Bearer " + access_token);
			cr.setChallengeResponse(challengeResponse);
			
			SpotifyUserSearch res = cr.get(SpotifyUserSearch.class);
			
			userId = res.getId();
		
		}catch(ResourceException re){
			System.err.println("Error: "+ cr.getResponse().getStatus());
		}
		
		id = userId;
		return userId;
		
	}
	
	public List<aiss.model.SpotifyPlaylists.Item> getPlaylists(){		//string id
		List<aiss.model.SpotifyPlaylists.Item> lista = null;
		
		ClientResource cr = null;
		
		try{
			cr = new ClientResource("https://api.spotify.com/v1/users/"+id+"/playlists?limit=3");
			
			cr.setEntityBuffering(true);
			
			ChallengeResponse challengeResponse = new ChallengeResponse(new ChallengeScheme("Authorization", ""));
			challengeResponse.setRawValue("Bearer " + access_token);
			cr.setChallengeResponse(challengeResponse);
			
			SpotifyPlaylistsSearch res = cr.get(SpotifyPlaylistsSearch.class);
			
			lista = res.getItems();
		
		}catch(ResourceException re){
			System.err.println("Error: "+ cr.getResponse().getStatus());
		}
		
		return lista;
	}
	

	public Item getTrack(String artista, String cancion) throws UnsupportedEncodingException {

		//crear la uri que vamos a usar
		String uri = "https://api.spotify.com/v1/search?q="+artista+" "+cancion+"&type=track";
		log.log(Level.FINE,"Spotify URI: "+ uri);
		
		

		//crear libreria RESTlet object
		ClientResource cr = new ClientResource(uri);

		//Send request
		SearchSpotify result = cr.get(SearchSpotify.class);
		
		
		return result.getTracks().getItems().get(0);
	
	}
	
	public void createPlaylist(){
		ClientResource cr = null;
		
		try{
			cr = new ClientResource("https://api.spotify.com/v1/users/"+id+"/playlists");
			
			cr.setEntityBuffering(true);
			
			ChallengeResponse challengeResponse = new ChallengeResponse(new ChallengeScheme("Authorization", ""));
			challengeResponse.setRawValue("Bearer " + access_token);
			cr.setChallengeResponse(challengeResponse);
			
			cr.accept(MediaType.APPLICATION_JSON);
			
			String body ="{\"name\":\"MusicDirect\", \"public\":\"true\" }";
			
			String res = cr.post(body, String.class);
			
			log.info("Create playlist: "+ res);
			
		}catch(ResourceException re){
			System.err.println("Error: "+ cr.getResponse().getStatus());
		}
	}
	
	public void addSong(String uri, String playlistId){
		ClientResource cr = null;
		log.info("Uri of track:" + uri);
		log.info("playlistId:" + playlistId);
		log.info("Id:" + id);
		
		try{
			cr = new ClientResource("https://api.spotify.com/v1/users/"+id+"/playlists/"+playlistId+"/tracks?uris="+uri);
			
			cr.setEntityBuffering(true);
			
			ChallengeResponse challengeResponse = new ChallengeResponse(new ChallengeScheme("Authorization", ""));
			challengeResponse.setRawValue("Bearer " + access_token);
			cr.setChallengeResponse(challengeResponse);
			
			cr.post(" ");
			
			log.info("Create playlist:" + cr.toString());
			
		}catch(ResourceException re){
			System.err.println("Error: "+ cr.getResponse().getStatus());
		}
	}
	
	
	
	
}
