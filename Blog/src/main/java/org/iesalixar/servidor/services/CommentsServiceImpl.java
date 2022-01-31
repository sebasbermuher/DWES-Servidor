package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.CommentsDAO;
import org.iesalixar.servidor.dao.CommentsDAOImpl;
import org.iesalixar.servidor.model.Comments;

public class CommentsServiceImpl implements CommentsService {

	private CommentsDAO commentsDAO;

	public CommentsServiceImpl(final Session session) {
		this.commentsDAO = new CommentsDAOImpl(session);
	}

	@Override
	public void insertNewComment(Comments comments) {
		if (comments != null && comments.getId() == null) {
			commentsDAO.insert(comments);
		}

	}

	@Override
	public void updateComment(Comments comments) {
		if (comments != null && comments.getId() != null) {
			commentsDAO.update(comments);
		}

	}

	@Override
	public void deleteComment(Comments comments) {
		if (comments != null && comments.getId() != null) {
			commentsDAO.delete(comments);
		}

	}

	@Override
	public Comments searchById(Long commentsId) {
		Comments comments = null;

		if (commentsId != null) {

			comments = commentsDAO.searchById(commentsId);
		}
		return comments;
	}

	@Override
	public List<Comments> searchAll() {
		List<Comments> commentsList = new ArrayList<Comments>();

		commentsList = commentsDAO.searchAll();

		return commentsList;
	}

	@Override
    public List<Comments> searchByName(String name) {
        List<Comments> commentsList = new ArrayList<Comments>();
        if (name!=null) {
            commentsList = commentsDAO.searchByWord(name);
        }
        return commentsList;
    }

}
