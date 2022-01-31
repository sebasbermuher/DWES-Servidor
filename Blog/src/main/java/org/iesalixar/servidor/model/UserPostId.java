package org.iesalixar.servidor.model;

import java.util.Objects;

public class UserPostId {
	private Long user;
    private Long post;
    
	public UserPostId() {
		super();
	}

	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public Long getPost() {
		return post;
	}
	public void setPost(Long post) {
		this.post = post;
	}
	@Override
	public int hashCode() {
		return Objects.hash(post, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPostId other = (UserPostId) obj;
		return Objects.equals(post, other.post) && Objects.equals(user, other.user);
	}
    
    
}
