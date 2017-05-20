package aiss.model.resources;


import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;




public class YouTubeTest {

	@Test
	public void getIdTest() throws UnsupportedEncodingException{
		String artista = "Coldplay";
		String cancion = "yellow";
		
		YouTubeResource youtube = new YouTubeResource();
		String youtubeResults = youtube.getId(artista, cancion);
		
		
		
		assertNotNull("The search ID returned null", youtubeResults);
		
		

	}
	
	
}

