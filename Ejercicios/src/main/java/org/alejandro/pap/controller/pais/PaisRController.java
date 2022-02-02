package org.alejandro.pap.controller.pais;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alejandro.pap.entitites.Pais;
import org.alejandro.pap.model.PaisModel;


@WebServlet("/pais/r")
public class PaisRController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaisModel pm = new PaisModel();
		List<Pais> paises = pm.getPaises();
		request.setAttribute("paises", paises);//TODO
		request.getRequestDispatcher("/views/pais/r.jsp").forward(request, response);
	}


}
