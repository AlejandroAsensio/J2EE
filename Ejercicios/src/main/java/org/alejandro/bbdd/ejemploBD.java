package org.alejandro.bbdd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ejemploBD
 */
@WebServlet("/ejemploBD/ejemplo1")
public class ejemploBD extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Pruebas de BBDD</h1>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
//			PreparedStatement ps = con.prepareStatement("insert into persona (id,nombre) values (?,?)");
//			ps.setInt(1, 20);						|
//			ps.setString(2, "Ana"); 	-----------inserts
//			ps.execute();							|
//			pw.println("(10) Pepe insertado");
			
			PreparedStatement ps = con.prepareStatement("select * "
					+ "from persona "
					+ "where nombre = ?");
			ps.setString(1, "pepe	");
			ResultSet rs = ps.executeQuery();
			pw.println("<ul>");
			while (rs.next()) {
			int id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			pw.println("<li>("
					+ id
					+ ") "
					+ nombre
					+ "</li>");
			}
			pw.println("</ul>");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
