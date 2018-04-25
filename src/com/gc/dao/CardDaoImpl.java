package com.gc.dao;

import java.util.ArrayList;

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
	public void addCard(Card card) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(card);
		tx.commit();
		session.close();
	}

	@Override
	public void delCard() {
		// TODO Auto-generated method stub

	}

}
