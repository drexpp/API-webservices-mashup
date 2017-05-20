package aiss.model.resources;


import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.model.Spotify.Item;




public class SpotifyTest {
	
	//Para estos tests, sera necesario tener un token, que podremos obtener de por ejemplo: https://developer.spotify.com/web-api/console/get-current-user/
	
	@Test
	public void tokenTest() throws Exception {
		String access_token = "BQBpWi1hMNievAIQDmBMg12B5lQynAzujdGPO5PazpmJIrWaOqbS-CIpg84YSOdrTiRYBljJXCn4vNzgjy4LLU5lgw4TSzO13IO3RYBVv2nZvWSEFaLUZFUmhHf9Spa2T9AqGYKB6CaFBhvtnGz_-vadsJBxFvmLeRPRByIQR0D-cDchYfEd7flTQxeX6t8PhNl1OCCCwZc-Q8uM59MHKEDxNbJufIhbnz7zxzGGhxKTgSUtcQLM9STya7pbw27NXU_BiJwS_cvHOyywjVGxzrB3krZsRaKnSOlknSUaYz3otLzNWLzuLLkId9cq45kFzQ";
		
		SpotifyResource res = new SpotifyResource(access_token);
		
		String id = res.userId();
		
		
		assertNotNull("The search of ID", id);
		
		
	}
	
	
	@Test
	public void getTrackTest() throws UnsupportedEncodingException{
		String artista = "Coldplay";
		String cancion = "yellow";
		
		SpotifyResource spotify = new SpotifyResource();
		Item spotifyResults = spotify.getTrack(artista, cancion);
		
		
		
		assertNotNull("The search ID returned null", spotifyResults.getAlbum().getId());
		
		

	}
	
	@Test
	public void PlaylistTest() throws Exception {
		String access_token = "BQBpWi1hMNievAIQDmBMg12B5lQynAzujdGPO5PazpmJIrWaOqbS-CIpg84YSOdrTiRYBljJXCn4vNzgjy4LLU5lgw4TSzO13IO3RYBVv2nZvWSEFaLUZFUmhHf9Spa2T9AqGYKB6CaFBhvtnGz_-vadsJBxFvmLeRPRByIQR0D-cDchYfEd7flTQxeX6t8PhNl1OCCCwZc-Q8uM59MHKEDxNbJufIhbnz7zxzGGhxKTgSUtcQLM9STya7pbw27NXU_BiJwS_cvHOyywjVGxzrB3krZsRaKnSOlknSUaYz3otLzNWLzuLLkId9cq45kFzQ";
		
		SpotifyResource res = new SpotifyResource(access_token);
		
		List<aiss.model.SpotifyPlaylists.Item> playlists = res.getPlaylists();
		
		
		assertNotNull("The search of playlists", playlists);
		assertNotNull("The name of playlist is not null", playlists.get(0).getName());
		
		
	}

	
	
}

