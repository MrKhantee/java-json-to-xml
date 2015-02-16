package net.appuntivari.json.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;



public class TestJSONtoXML {
	
	public static Log log = LogFactory.getLog("TestJSONtoXML");

	
	public static void main(String[] args) throws JSONException {
		
		String json_data ="{\"appunto_autore\": \"Pasturenzi Francesco\",\"appunto_titolo\": \"Come creare un XML da un JSON\",\"appunto_descr\": \"Qui la descrizione del titolo in questione\" }";
		if(json_data != null){

			log.info("json_data = "+json_data);	
			
			
			log.info("\nLeggo il JSON:");
			JSONObject jsonObject = new JSONObject(json_data);
			
			String autore = jsonObject.getString("appunto_autore");
			log.info("appunto_autore = "+autore);
			
			String titolo = jsonObject.getString("appunto_titolo");
			log.info("appunto_titolo = "+titolo);
			
			String descrizione = jsonObject.getString("appunto_descr");
			log.info("appunto_descr = "+descrizione);
			
			
			
			/*Genero la mappa*/
			Map<String, String> mappaParametri = new LinkedHashMap<String, String>();
			mappaParametri.put(new String("autore"), autore);
			mappaParametri.put(new String("titolo"), titolo);
			mappaParametri.put(new String("descrizione"), descrizione);
			

			log.info("\n Genero XML.");
			generaXML(mappaParametri);
	
		}

	}
	
	
	private static void generaXML(Map<String, String> mappa){
		
		String entry = "";
		for (Entry<String, String> entryMap : mappa.entrySet()) {
			entry += "    <"+entryMap.getKey()+">"+entryMap.getValue().toString()+"</"+entryMap.getKey()+">\n"; 
		}

		String XMLstring = 
			"\n<appunti>\n" +
					" <appunto>\n" +
					entry +
					" </appunto>\n"+
			"</appunti>";

		log.info(XMLstring);
	}

}
