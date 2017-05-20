package aiss.model.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.ClientResource;

public class MusixMatchResource {

	private static final String LYRICS_API_KEY = ""; //need API key
	
	private static final Logger log = Logger.getLogger(MusixMatchResource.class.getName());

	public String getSongLyrics(String artist, String track)
			throws JSONException {

		// Perform search in MusixMatch
		String uri = "http://api.musixmatch.com/ws/1.1/track.search?apikey=" + LYRICS_API_KEY + "&q_artist=" + artist
				+ "&q_track=" + track;
		log.log(Level.INFO, "MusixMatch looking for artist ID URI: " + uri);

		// Creo RESTlet object
		ClientResource cr = new ClientResource(uri);

		
		
		//No se ha podido hacer uso del MVC con MusixMatch ya que su mensaje devuelto era en plain/text y no habia forma de pasarlo a JSON.
		//Send request
		String result = cr.get(String.class);
		JSONObject j = new JSONObject(result);
		String track_id = j.getJSONObject("message").getJSONObject("body").getJSONArray("track_list").getJSONObject(0).getJSONObject("track").get("track_id").toString();
		
		
		
		//Busqueda de la letra, una vez obtenido el track_id
		String uri2 = "http://api.musixmatch.com/ws/1.1/track.lyrics.get?apikey=" + LYRICS_API_KEY + "&track_id="
				+ track_id;
		log.log(Level.INFO, "MusixMatch looking for lyrics URI: " + uri2);

		ClientResource cr2 = new ClientResource(uri2);
		
		String result2 = cr2.get(String.class);
		JSONObject j2 = new JSONObject(result2);
		
		String letra = j2.getJSONObject("message").getJSONObject("body").getJSONObject("lyrics").get("lyrics_body").toString();
		
		

		return letra;
	}
}
