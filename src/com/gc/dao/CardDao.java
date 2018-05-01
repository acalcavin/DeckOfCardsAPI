package com.gc.dao;

import java.util.ArrayList;

import com.gc.model.Card;

public interface CardDao {
	
	public ArrayList<Card> getPlayerHand();
	public Card getCard();
	public int addCard(Card card);
	public void delCard();
	public void delCard(String code);
	public void updateCard();
	public void updateCard(int cardID, String image, String suit, String value, String code);

}
