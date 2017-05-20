package aiss.model.resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;



public class TranslateTest {


	@Test
	public void getTranslationTest() throws UnsupportedEncodingException{
		String cancion = "yellow";
		
		GoogleTranslateResource gt = new GoogleTranslateResource();
		String GoogleTranslateResults = gt.getTranslation(cancion);
		
		
		
		assertNotNull("The search ID returned null", GoogleTranslateResults);
		
		

	}
	
}
