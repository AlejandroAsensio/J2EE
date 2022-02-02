package org.alejandro;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ej6
 */
@WebServlet("/ej6")
public class ej6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<form method=\"POST\">");
		pw.println("	Nombre");
		pw.println("	<input type=\"text\" name=\"nombre\"/>");
		pw.println("	<br/> ");
		
		pw.println("	<input type=\"checkbox\" id=\"bailar\" name=\"aficiones[]\" value=\"bailar\"/>");
		pw.println("	<label for=\"bailar\">Bailar</label>");
		pw.println("	<input type=\"checkbox\" id=\"cantar\" name=\"aficiones[]\" value=\"cantar\"/>");
		pw.println("	<label for=\"cantar\">Cantar</label>");
		pw.println("	<br/> ");
		pw.println("	<input type=\"submit\"/>");
		pw.println("<form>");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String[] aficiones = request.getParameterValues("aficiones[]");
		String nombre = request.getParameter("nombre");
		if(nombre.equals("") || nombre == null) {
			pw.println("Debes introducir un nombre");
		}
		else if(aficiones == null || aficiones.length == 0) {
			pw.println("A "+nombre+" no le gusta nada");
		}
		else {	
			pw.println("A "+nombre+" le gusta ");
			for(String aficion : aficiones) {
				pw.print(aficion+" ");
			}
		}
	}

}
