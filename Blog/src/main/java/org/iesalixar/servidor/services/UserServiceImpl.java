package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.UserDAO;
import org.iesalixar.servidor.dao.UserDAOImpl;
import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public UserServiceImpl(final Session session) {
		this.userDAO = new UserDAOImpl(session);
	}

	@Override
	public void insertNewUser(User user) {
		if (user != null && user.getId() == null) {
			userDAO.insert(user);
		}
		
	}

	@Override
	public void updateUser(User user) {
		if (user != null && user.getId() != null) {
			userDAO.update(user);
		}
		
	}

	@Override
	public void deleteUser(User user) {
		if (user != null && user.getId() != null) {
			userDAO.delete(user);
		}
		
	}

	@Override
	public User searchById(Long userId) {
		User user = null;

		if (userId != null) {

			user = userDAO.searchById(userId);
		}
		return user;
	}

	@Override
	public List<User> searchAll() {
		List<User> userList = new ArrayList<User>();

		userList = userDAO.searchAll();

		return userList;
	}

	@Override
	public List<User> searchUsers(String name, String email) {
		List<User> userList = new ArrayList<User>();
        if (name!=null || email!=null) {
            userList = userDAO.searchUsers(name,email);
        }
        return userList;
    }

}
