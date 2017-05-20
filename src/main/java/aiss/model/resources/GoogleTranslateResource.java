package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.GoogleTranslate.SearchTranslate;

public class GoogleTranslateResource {

	private static final String GOOGLETRANSLATE_API_KEY = ""; //need API key
	private static final Logger log = Logger.getLogger(GoogleTranslateResource.class.getName());

	public String getTranslation(String cancion) throws UnsupportedEncodingException {

		//crear la uri que vamos a usar
		String uri = "https://translation.googleapis.com/language/translate/v2?q="+cancion+"&target=es"+"&key="+GOOGLETRANSLATE_API_KEY;
		
		log.log(Level.FINE,"Google Translate URI: "+ uri);

		//crear libreria RESTlet object
		ClientResource cr = new ClientResource(uri);

		//Send request
		SearchTranslate result = cr.get(SearchTranslate.class);
		
		
		return result.getData().getTranslations().get(0).getTranslatedText();

	}
}
