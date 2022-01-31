package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class PostDAOImpl extends GenericDAOImpl<Post> implements PostDAO {
	private Session session;

	public PostDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Post> searchTitlePostByUser(String user) {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		List<Post> postList = new ArrayList<>();

		if (user != null) {
			postList = session.createQuery("FROM Comments WHERE word LIKE %word%").setParameter("word", user).list();
		}

		return postList;
	}

}
