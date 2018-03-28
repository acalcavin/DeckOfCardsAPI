package com.gc.controller;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * @author: Andrew Calabro-Cavin
 * Work with an API that generates JSON data to display information on a web page
 *
 * Work with the Deck of Cards API
 */

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView index(Model model) {

		String deckId = ""; // declare here so can return in the view
		
		try {
		HttpClient http = HttpClientBuilder.create().build(); // import the apache version

		// HttpPost holds the variables needed for the connections
		// the default port for http connections is 80
		// default port for https is 443
		HttpHost host = new HttpHost("deckofcardsapi.com", 443, "https");

		HttpGet getPage = new HttpGet("/api/deck/new/shuffle/?deck_count=1");
		
		HttpResponse resp = http.execute(host, getPage);
		
		String jsonString = EntityUtils.toString(resp.getEntity());
		
		JSONObject json = new JSONObject(jsonString);
		deckId = json.get("deck_id").toString();
		
		// Test print to console to confirm communication with API; Response code should be 200 if successful
		System.out.println("Response Code: " + resp.getStatusLine().getStatusCode()); 
				
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		model.addAttribute("profile", "profile");
				
		return new ModelAndView("index", "deckId", deckId);
	}
	
	@RequestMapping("/welcome")
	public ModelAndView display(@RequestParam("id") String deckId, Model model) {
		
		String hand = "";
		
		try {
		HttpClient http = HttpClientBuilder.create().build(); // import the apache version

		// HttpPost holds the variables needed for the connections
		// the default port for http connections is 80
		// default port for https is 443
		HttpHost host = new HttpHost("deckofcardsapi.com", 443, "https");

		HttpGet getPage = new HttpGet("/api/deck/" + deckId + "/draw/?count=5");
		
		HttpResponse resp = http.execute(host, getPage);
		
		String jsonString = EntityUtils.toString(resp.getEntity());
		
		JSONObject json = new JSONObject(jsonString);
		JSONArray arr = json.getJSONArray("cards");
		
		for (int i = 0; i < arr.length(); i++) {
			hand += "<img src=\"" + arr.getJSONObject(i).get("image") + "\">" + "<br>" + "<h2>" + arr.getJSONObject(i).get("value") + " of " + arr.getJSONObject(i).get("suit") + "</h2>";
		}
		
		// Test print to console to confirm communication with API; Response code should be 200 if successful
		System.out.println("Response Code: " + resp.getStatusLine().getStatusCode()); 
				
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("deckId", deckId);
		
		model.addAttribute("handHere", hand); // testing
		
		return new ModelAndView("welcome", "cards", hand);

	}
	
	@RequestMapping("test")
	public String display() {
		
		return "test.html";
	}
}
