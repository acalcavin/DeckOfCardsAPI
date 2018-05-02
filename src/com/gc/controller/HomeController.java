package com.gc.controller;

import java.io.IOException;
import java.util.ArrayList;

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

import com.gc.dao.CardDaoImpl;
import com.gc.model.Card;

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

			// Test print to console to confirm communication with API; Response code should
			// be 200 if successful
			System.out.println("Response Code: " + resp.getStatusLine().getStatusCode() + ": API Connection successful");

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("profile", "profile");

		return new ModelAndView("index", "deckId", deckId);
	}

	@RequestMapping("/play")
	public ModelAndView display(@RequestParam("id") String deckId, Model model) {

		int[] playerCardIDs = {1,2,3,4,5,6,7,8,9,10};
		ArrayList<Card> playerHand = new ArrayList<Card>();
		//add dealer's hand
		String image = null;
		String value = null;
		String suit = null;
		String code = null;

		try {
			HttpClient http = HttpClientBuilder.create().build(); // import the apache version

			// HttpHost holds the variables needed for the connections
			// default port for http connections is 80
			// default port for https is 443
			HttpHost host = new HttpHost("deckofcardsapi.com", 443, "https");

			HttpGet getPage = new HttpGet("/api/deck/" + deckId + "/draw/?count=10");

			HttpResponse resp = http.execute(host, getPage);

			String jsonString = EntityUtils.toString(resp.getEntity());

			JSONObject json = new JSONObject(jsonString);
			JSONArray arr = json.getJSONArray("cards");

			for (int i = 0; i < arr.length(); i++) {
				
				int cardID = playerCardIDs[i];			
				
				image = arr.getJSONObject(i).get("image").toString();
				//check if face card; set to lc
				String allCapsSuit = arr.getJSONObject(i).get("suit").toString();
				suit = allCapsSuit.substring(0,1) + allCapsSuit.substring(1).toLowerCase();
				value = arr.getJSONObject(i).get("value").toString();
				code = arr.getJSONObject(i).get("code").toString();

				//update table for cardID
				CardDaoImpl dao = new CardDaoImpl();
				//use the cardID, find the row, update it
				dao.updateCard(cardID, image, suit, value, code);
				
				// add odd cards, add to playerHand
				if (i == 0 || i == 2 || i == 4 || i == 6 || i == 8) {
					Card card = new Card();
					card.setCardID(cardID);
					card.setImage(image);
					card.setSuit(suit);
					card.setValue(value);
					card.setCode(code);
					playerHand.add(card);
					
				}
				
			}
			System.out.println("playerHand:" + playerHand.toString());
			System.out.println(playerHand.get(0).getValue());
			System.out.println(playerHand.get(0).getSuit());
			System.out.println(playerHand.get(0).getImage());
			System.out.println(playerHand.get(0).getCode());
			// Test print to console to confirm communication with API; Response code should
			// be 200 if successful
			System.out.println("Response Code: " + resp.getStatusLine().getStatusCode());

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("deckId", deckId);

		return new ModelAndView("play", "cardList", playerHand);

	}

	@RequestMapping("discard")
	public ModelAndView discard(@RequestParam("id") String deckId, @RequestParam("cardID") int[] cardIDchecked) {
		
		System.out.println(cardIDchecked);
		String image = null;
		String value = null;
		String suit = null;
		String code = null;
		
		ArrayList<Card> playerHand = new ArrayList<Card>();
		CardDaoImpl dao = new CardDaoImpl();
			
			// TODO: use a for loop, to loop through int[] cardIDchecked; for each CardID, draw a new card, update the fields
			for (int i = 0; i < cardIDchecked.length; i++) {
				
				int cardID = cardIDchecked[i];
				System.out.println(cardID);
				
				// draw a new card or cards from API
				// set variables for fields to update
				// pass those variables into an update function, for the selected cardID 
				try {
					HttpClient http = HttpClientBuilder.create().build(); // import the apache version

					// HttpHost holds the variables needed for the connections
					// default port for http connections is 80
					// default port for https is 443
					HttpHost host = new HttpHost("deckofcardsapi.com", 443, "https");

					HttpGet getPage = new HttpGet("/api/deck/" + deckId + "/draw/?count=1");

					HttpResponse resp = http.execute(host, getPage);

					String jsonString = EntityUtils.toString(resp.getEntity());

					JSONObject json = new JSONObject(jsonString);
					JSONArray arr = json.getJSONArray("cards");
				
					image = arr.getJSONObject(0).get("image").toString();
					value = arr.getJSONObject(0).get("value").toString();
					//check if face card; set to lc
					String allCapsSuit = arr.getJSONObject(0).get("suit").toString();
					suit = allCapsSuit.substring(0,1) + allCapsSuit.substring(1).toLowerCase();
					code = arr.getJSONObject(0).get("code").toString();
					// Test print to console to confirm communication with API; Response code should
					// be 200 if successful
					System.out.println("Response Code: " + resp.getStatusLine().getStatusCode() + ": Draw 1 successful");
				
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//use the cardID, find the row, update it
				dao.updateCard(cardID, image, suit, value, code);
			}

			// read from table, cards for player one, put into playerHand
			playerHand = dao.getPlayerHand();
		
		return new ModelAndView("play", "cardList", playerHand);
	}
	
	@RequestMapping("show")
	public ModelAndView show(Model model) {
		ArrayList<Card> playerHand = new ArrayList<Card>();
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		CardDaoImpl dao = new CardDaoImpl();
		playerHand = dao.getPlayerHand();
		dealerHand = dao.getDealerHand();
		
		model.addAttribute("dealerHand", dealerHand);		
		
		return new ModelAndView("show", "cardList", playerHand);
	}
	
	@RequestMapping("test")
	public String display() {

		return "test.html";
	}
}
