package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "title", unique = true, nullable = false)
	private String title;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "date", nullable = false)
	private Date date;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Valorar> valoraciones = new HashSet<>();
	
	@OneToMany(mappedBy = "postComments", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comments> comentarios = new HashSet<>();
	
	@ManyToOne
	private User userP;

	public Post() {
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

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Valorar> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(Set<Valorar> valoraciones) {
		this.valoraciones = valoraciones;
	}

	public User getUserP() {
		return userP;
	}

	public void setUserP(User userP) {
		this.userP = userP;
	}
	
	public void addComentario(Comments comment) {
        this.comentarios.add(comment);
        comment.setPostComments(this);
    }

    public void removeComentario(Comments comment) {
        this.comentarios.remove(comment);
        comment.setPostComments(null);
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
		Post other = (Post) obj;
		return Objects.equals(title, other.title);
	}

}
