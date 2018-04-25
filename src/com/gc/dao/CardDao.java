package com.gc.dao;

import java.util.ArrayList;

import com.gc.model.Card;

public interface CardDao {
	
	public ArrayList<Card> getHand();
	public Card getCard();
	public void addCard(Card card);
	public void delCard();

}
