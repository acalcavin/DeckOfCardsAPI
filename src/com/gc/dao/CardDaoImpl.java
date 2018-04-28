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
	public ArrayList<Card> getHand() {
		// TODO Auto-generated method stub
		return null;
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
//		Card card = new Card();
//		card.setCode(code);
//		
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Card card = (Card)session.get(Card.class, ) 
//			
//		}
//		session.delete(card);
//		tx.commit();
//		session.close();

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
		
	}

}
