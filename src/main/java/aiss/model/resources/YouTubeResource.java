package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;



import aiss.model.YouTube.Youtube;

public class YouTubeResource {

	private static final String YOUTUBE_API_KEY = "";//need API key
	private static final Logger log = Logger.getLogger(YouTubeResource.class.getName());

	public String getId(String artista, String cancion) throws UnsupportedEncodingException {

		//crear la uri que vamos a usar
		String uri = "https://www.googleapis.com/youtube/v3/search?part=snippet&q="+artista+" "+cancion+"&key="+YOUTUBE_API_KEY;
		
		log.log(Level.FINE,"Youtube URI: "+ uri);

		//crear libreria RESTlet object
		ClientResource cr = new ClientResource(uri);

		//Send request
		Youtube result = cr.get(Youtube.class);
		
		
		return result.getItems().get(0).getId().getVideoId();

	}
}
