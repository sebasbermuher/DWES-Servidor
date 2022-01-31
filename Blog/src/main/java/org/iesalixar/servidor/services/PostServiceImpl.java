package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.PostDAO;
import org.iesalixar.servidor.dao.PostDAOImpl;
import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.model.Post;

public class PostServiceImpl implements PostService {

	private PostDAO postDAO;

	public PostServiceImpl(final Session session) {
		this.postDAO = new PostDAOImpl(session);
	}

	@Override
	public void insertNewPost(Post post) {
		if (post != null && post.getId() == null) {
			postDAO.insert(post);
		}

	}

	@Override
	public void updatePost(Post post) {
		if (post != null && post.getId() != null) {
			postDAO.update(post);
		}
	}

	@Override
	public void deletePost(Post post) {
		if (post != null && post.getId() != null) {
			postDAO.delete(post);
		}

	}

	@Override
	public Post searchById(Long postId) {
		Post post = null;

		if (postId != null) {

			post = postDAO.searchById(postId);
		}
		return post;
	}


	@Override
	public List<Post> searchAll() {
		List<Post> postList = new ArrayList<Post>();

		postList = postDAO.searchAll();

		return postList;
	}

	@Override
	public List<Post> searchTitlePostByUser(String name) {
		List<Post> postList = new ArrayList<Post>();
        if (name!=null) {
            postList = postDAO.searchTitlePostByUser(name);
        }
        return postList;
    }


}
