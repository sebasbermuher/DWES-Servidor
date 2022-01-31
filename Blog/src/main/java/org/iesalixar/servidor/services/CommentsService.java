package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Comments;

public interface CommentsService {
	public void insertNewComment(final Comments comments);

	public void updateComment(final Comments comments);

	public void deleteComment(final Comments comments);

	public Comments searchById(final Long commentsId);

	public List<Comments> searchAll();

	public List<Comments> searchByName(String name);
}
