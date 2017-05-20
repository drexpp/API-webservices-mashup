package aiss.model.resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.junit.Test;


public class MusixMatchTest {


	@Test
	public void getLyricsTest() throws UnsupportedEncodingException{
		String artista = "Coldplay";
		String cancion = "yellow";
		
		MusixMatchResource mm = new MusixMatchResource();
		String MusixMatchResults;
		try {
			MusixMatchResults = mm.getSongLyrics(artista, cancion);
			assertNotNull("The lyrics returned null", MusixMatchResults);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	
	}
}
