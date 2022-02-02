package org.alejandro.pap.model;

import java.util.List;

import org.alejandro.pap.entitites.Pais;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PaisModel {
	
	private Session sesion;
	
	public PaisModel () {
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
//
//		this.sesion = sf.openSession();
	}
	
	public void savePais(String nombre) {
		
//		Transaction t = this.sesion.beginTransaction();
//
//		this.sesion.save(new Pais(nombre));
//		t.commit();

		
	}

	public List<Pais> getPaises() {
		
		return List.of(new Pais("Alemania"), new Pais("España"), new Pais("Francia"));
	}
}
