package org.alejandro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ej4")
public class ej4 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		if(nombre == null) {
		
			pw.println("<form>");
			pw.println("	Nombre");
			pw.println("	<input type=\"text\" name=\"nombre\"/>");
			pw.println("	<br/> ");
			pw.println("	<input type=\"submit\"/>");
			pw.println("<form>");
		}
		else {
			pw.println("<h1>Hola "+nombre+"</h1>");
		}
	}

}
