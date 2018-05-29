/**
 * 
 */
package dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.AccountDAO;
import entity.Account;

/**
 * @author ramsey
 *
 */
@Transactional
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.AccountDAO#findAccount(java.lang.String)
	 */
	public Account findAccount(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Account.class);
		crit.add(Restrictions.eq("userName", userName));
		return (Account) crit.uniqueResult();
	}

}
