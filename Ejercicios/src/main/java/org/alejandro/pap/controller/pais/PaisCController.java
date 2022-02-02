package org.alejandro.pap.controller.pais;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alejandro.pap.model.PaisModel;


@WebServlet("/pais/c")
public class PaisCController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/pais/c.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombrePais = request.getParameter("nombre");
		PaisModel pm = new PaisModel();
		pm.savePais(nombrePais);
		request.getRequestDispatcher("/views/pais/cOk.jsp").forward(request, response);
//		request.getRequestDispatcher("/views/pais/cOk.jsp").forward(request, response);
	}

}
