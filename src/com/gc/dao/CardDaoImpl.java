package com.gc.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gc.model.Card;
import com.gc.util.HibernateUtil;

public class CardDaoImpl implements CardDao {

	@Override
	public ArrayList<Card> getPlayerHand() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		int[] cardID = {1,3,5,7,9};
		ArrayList<Card> playerHand = new ArrayList<Card>();
		
		try {
			tx = session.beginTransaction();
			
			for (int i = 0; i < cardID.length; i++) {
				Card card = (Card)session.get(Card.class, cardID[i]);
				playerHand.add(card);
			}
			
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		System.out.println("getPlayerHand successful" + playerHand.toString());
		return playerHand;
	}
	
	@Override
	public Card getCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCard(Card card) {
		//TODO: still need another try-catch?
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int cardID = (int) session.save(card);
		tx.commit();
		session.close();
		return cardID;
	}

	@Override
	public void delCard() {
		
	}
	
	@Override
	public void delCard(String code) {

	}

	@Override
	public void updateCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCard(int cardID, String image, String suit, String value, String code) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Card card = (Card)session.get(Card.class, cardID);
			card.setImage(image);
			card.setSuit(suit);
			card.setValue(value);
			card.setCode(code);
			session.update(card);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Card update successful");
	}


}
