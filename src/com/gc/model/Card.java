package com.gc.model;

public class Card {
	
	private String image;
	private String suit;
	private String value;
	
	public Card() {
		super();
	}

	public Card(String image, String suit, String value) {
		super();
		this.image = image;
		this.suit = suit;
		this.value = value;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
