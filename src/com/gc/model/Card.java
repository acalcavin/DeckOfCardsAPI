package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cards")
public class Card {
	
	private int cardID;
	private String image;
	private String suit;
	private String value;
	private int player;
	
	public Card() {
		super();
	}
	
	public Card(int cardID, String image, String value, String suit, int player) {
		super();
		this.cardID = cardID;
		this.image = image;
		this.value = value;
		this.suit = suit;
		this.player = player;
	}
	
	@Id
	@Column(name="cardID")
	public int getCardID() {
		return cardID;
	}
	
	public void setCardID(int cardID) {
		this.cardID = cardID;
	}
	
	@Column(name="image")
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Column(name="card_value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name="suit")
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}

	@Column(name="player")
	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}
	
}
