package org.iesalixar.servidor;

import java.util.Calendar;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.CommentsDAOImpl;
import org.iesalixar.servidor.dao.UserDAOImpl;
import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.services.CommentsService;
import org.iesalixar.servidor.services.CommentsServiceImpl;
import org.iesalixar.servidor.services.PostService;
import org.iesalixar.servidor.services.PostServiceImpl;
import org.iesalixar.servidor.services.UserService;
import org.iesalixar.servidor.services.UserServiceImpl;
import org.iesalixar.servidor.utils.HibernateUtils;

public class MainBlog {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		
			// Creo la sesión
		Session session = HibernateUtils.getSessionFactory().openSession();

		// Creo los servicios definidos
		CommentsService commentsService = new CommentsServiceImpl(session);
		PostService postService = new PostServiceImpl(session);
		UserService userService = new UserServiceImpl(session);
		
		
		User sebas = new User();
		sebas.setUserName("sebasalixar");
		sebas.setPassword("latarara");
		sebas.setFirstName("Sebastian");
		sebas.setLastName("Bermudez");
		sebas.setEmail("sebas@sebas.com");
		
		User fekir = new User();
		fekir.setUserName("fekirNa");
		fekir.setPassword("micontraesesta");
		fekir.setFirstName("Nabil");
		fekir.setLastName("Fekir");
		fekir.setEmail("fekir@feki.com");
		
		userService.insertNewUser(sebas);
		userService.insertNewUser(fekir);
		
		
		Post post1 = new Post();
		post1.setTitle("Primer POST");
		post1.setContent("Este es el contenido del primer POST");
		calendar.set(Calendar.YEAR, 1995);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, 07);
		post1.setDate(calendar.getTime());
		
		Post post2 = new Post();
		post2.setTitle("Segundo POST");
		post2.setContent("Este es el contenido del segundo POST");
		calendar.set(Calendar.YEAR, 2000);
		calendar.set(Calendar.MONTH, 12);
		calendar.set(Calendar.DAY_OF_MONTH, 18);
		post2.setDate(calendar.getTime());

		Post post3 = new Post();
		post3.setTitle("Tercer POST");
		post3.setContent("Este es el contenido del tercer POST");
		calendar.set(Calendar.YEAR, 2001);
		calendar.set(Calendar.MONTH, 8);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		post3.setDate(calendar.getTime());
		
		Post post4 = new Post();
		post4.setTitle("Cuarto POST");
		post4.setContent("Este es el contenido del cuarto POST");
		calendar.set(Calendar.YEAR, 2005);
		calendar.set(Calendar.MONTH, 10);
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		post4.setDate(calendar.getTime());
		
		Post post5 = new Post();
		post5.setTitle("Quinto POST");
		post5.setContent("Este es el contenido del quinto POST");
		calendar.set(Calendar.YEAR, 2010);
		calendar.set(Calendar.MONTH, 3);
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		post5.setDate(calendar.getTime());

		
		postService.insertNewPost(post1);
		postService.insertNewPost(post2);
		postService.insertNewPost(post3);
		postService.insertNewPost(post4);
		postService.insertNewPost(post5);

		
		sebas.añadirValoracion(post1, 10);
		sebas.añadirValoracion(post1, 8);
		sebas.añadirValoracion(post1, 2);
		sebas.añadirValoracion(post1, 7);
		sebas.añadirValoracion(post1, 9);

		fekir.añadirValoracion(post1, 5);
		fekir.añadirValoracion(post1, 10);
		fekir.añadirValoracion(post1, 6);
		fekir.añadirValoracion(post1, 8);
		fekir.añadirValoracion(post1, 7);
		
		userService.updateUser(fekir);
		userService.updateUser(sebas);		
		
		Comments c1 = new Comments();
		c1.setTitle("Primer comentario");
		c1.setContent("Este es el primer comentario");
		
		Comments c2 = new Comments();
		c2.setTitle("Segundo comentario");
		c2.setContent("Este es el segundo comentario");
		
		Comments c3 = new Comments();
		c3.setTitle("Tercer comentario");
		c3.setContent("Este es el tercer comentario");
		
		
		sebas.añadirComentario(c1);
		sebas.añadirComentario(c2);
		fekir.añadirComentario(c3);
		
		
		userService.updateUser(fekir);
		userService.updateUser(sebas);	
		
		sebas.addPost(post1);
		sebas.addPost(post2);
		sebas.addPost(post3);
		fekir.addPost(post4);
		fekir.addPost(post5);
		userService.updateUser(fekir);
		userService.updateUser(sebas);	
		
		
		post1.addComentario(c1);
		post2.addComentario(c2);
		post3.addComentario(c3);
		post4.addComentario(c3);
		post5.addComentario(c2);
		
		postService.updatePost(post1);
		postService.updatePost(post2);
		postService.updatePost(post3);
		postService.updatePost(post4);
		postService.updatePost(post5);
		
		CommentsDAOImpl commentDAO = new CommentsDAOImpl(session);
		commentDAO.searchByWord("tercer");
		
		UserDAOImpl usuarioDAO = new UserDAOImpl(session);
		usuarioDAO.searchUsers("fekir", "fekir@feki.com");
		
		
		session.close();
		
	}

}

