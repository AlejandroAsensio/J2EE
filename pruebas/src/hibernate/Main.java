package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.entities.Aficion;
import hibernate.entities.Pais;
import hibernate.entities.Persona;

public class Main {

	private static Session obtenerSesion() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		return sf.openSession();
	}

	private static Transaction guardarPersona(Persona p) {

		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();

		s.save(p);
		t.commit();

		return t;
	}
	
	private static Transaction guardarPais(Pais p) {

		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();

		s.save(p);
		t.commit();

		return t;
	}
	private static Transaction guardarAficion(Aficion a) {

		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();

		s.save(a);
		t.commit();

		return t;
	}


	private static Transaction actualizarPersona(Persona p) {

		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();

		s.merge(p);
		t.commit();

		return t;
	}

	private static Transaction borrarPersona(Persona p) {

		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();

		s.delete(p);
		t.commit();

		return t;
	}

	private static void crearGuardarPersona(String nombre, String nif, Pais pais) {
		Persona p = new Persona(nombre, nif, pais);

		guardarPersona(p);

		System.out.println(p + "Ha sido guardado en la BD");
	}

	private static Persona recuperarPersonaPorId(Long id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		return session.get(Persona.class, id);
	}
	
	private static Pais recuperarPaisPorId(Long id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		return session.get(Pais.class, id);
	}
	
	private static Aficion recuperarAficionPorId(Long id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		return session.get(Aficion.class, id);
	}

	private static List<Persona> recuperarTodsaLasPersonas() {
		Session sesion = obtenerSesion();

		return sesion.createQuery("from Persona").list();

	}

	private static List<Persona> recuperarPersonasPorNombre(String nombre) {
		Session sesion = obtenerSesion();

		return sesion.createQuery("from Persona where nombre = :x").setParameter("x", nombre).list();

	}

	public static void main(String[] args) {
		// Persona p = new Persona("Pepe");
		//// System.out.println(p);
		//
		// //persistencia
		//
		// SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// Session session = sf.openSession();
		//
		// Transaction t = session.beginTransaction();
		// session.save(p);
		// t.commit();
		//
		// System.out.println(p+"Ha sido guardado en la BD");

//		crearGuardarPersona("Juan");
//		crearGuardarPersona("Ana","1213456A");
//		crearGuardarPersona("Repetido","1213456A");
//		String listaPersonas = "";
//		for(Long id = 1L;id<5;id++) {
//			listaPersonas += recuperarPersonaPorId(id)+"\n";	
//			
//		}
//		System.out.println(listaPersonas);
//		List<Persona> personas = recuperarPersonasPorNombre("Ana");
//		for( Persona p : personas ) {
//			System.out.println(p);
//		}
//		Persona p = recuperarPersonaPorId(1L);
//		System.out.println(p);
//		System.out.println("=========== ACTUALIZADO A... =============");
//		p.setNombre("José");
//
//		actualizarPersona(p);
//		System.out.println(p);
//		Persona p = recuperarPersonaPorId(4L);
//		borrarPersona(p);
//		Pais p = new Pais("Alemania");
//		guardarPais(p);
//		System.out.println(p+" guardado en la BBDD");
		
//		Pais pais = recuperarPaisPorId(1L);
////		crearGuardarPersona("uno", "1A", pais);
//		for( Persona p : pais.getPersonasNacidas()) {
//			System.out.println(p+"--"+p.cantar());
//		}
//		Aficion aficion = new Aficion("bailar");
//		guardarAficion(aficion);
//		Aficion aficion2 = new Aficion("tv");
//		guardarAficion(aficion2);
		Aficion a1 = recuperarAficionPorId(2L);
		Aficion a2 = recuperarAficionPorId(3L);
		Persona p = recuperarPersonaPorId(2L);
		
		p.setAficionesGusta(List.of(a1,a2));
		actualizarPersona(p);
	}

}
