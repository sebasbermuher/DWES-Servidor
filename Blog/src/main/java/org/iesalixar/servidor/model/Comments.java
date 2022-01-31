package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Comments implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "content", nullable = false)
	private String content;

	@ManyToOne
	private User userComments;

	@ManyToOne
	private Post postComments;

	public Comments() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUserComments() {
		return userComments;
	}

	public void setUserComments(User userComments) {
		this.userComments = userComments;
	}

	public Post getPostComments() {
		return postComments;
	}

	public void setPostComments(Post postComments) {
		this.postComments = postComments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comments other = (Comments) obj;
		return Objects.equals(title, other.title);
	}

}
