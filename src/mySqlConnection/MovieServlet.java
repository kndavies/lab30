package mySqlConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab19.Movie;
import lab19.MovieIO;

import java.sql.Statement;
import java.util.ArrayList;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * try { Connection c = MySqlConnection.getConnection(); Statement s =
		 * c.createStatement(); for(int i = 1; i <= 100; i++) { Movie m =
		 * MovieIO.getMovie(i); String string =
		 * "INSERT INTO movie (MovieTitle, Genre) VALUES ('" + m.getTitle() +
		 * "', '" + m.getCategory() + "')"; int rowCount =
		 * s.executeUpdate(string); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */

		try {
			ArrayList<String> genres = new ArrayList<String>();
			Connection c = MySqlConnection.getConnection();
			String sql = "SELECT DISTINCT Genre FROM movie";
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(sql);
			while (r.next()) {
				genres.add(r.getString(1));
			}
			System.out.println(genres);
			request.setAttribute("genres", genres);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<String> movies = new ArrayList<String>();
			Connection c = MySqlConnection.getConnection();
			String genre = request.getParameter("selectGenre");
			String sql = "SELECT MovieTitle FROM movie WHERE Genre='" + genre + "'";
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(sql);
			while (r.next()) {
				//System.out.println(r.getString(1));
				movies.add(r.getString(1));
			}
			request.setAttribute("movies", movies);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
	}

}
