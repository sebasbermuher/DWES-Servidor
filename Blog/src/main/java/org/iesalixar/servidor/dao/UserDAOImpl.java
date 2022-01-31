package org.iesalixar.servidor.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {
	private Session session;

	public UserDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<User> searchUsers(String user, String email) {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		Criteria cr = session.createCriteria(User.class);

		Criterion userCR = Restrictions.eq("user", user);
		Criterion emailCR = Restrictions.eq("email", email);
		LogicalExpression andExp = Restrictions.and(userCR, emailCR);
		cr.add(andExp);

		List<User> userList = cr.list();

		return userList;
	}
}
