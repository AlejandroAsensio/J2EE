package pruebas;

import java.util.Map;
import static java.util.Map.entry; 

public class p1 {

	public static void main(String[] args) {
		Map<String, String> cosas = Map.ofEntries(
				entry("juan", "lenguado"),
				entry("pepe", "fabada")
				);
		for(String c : cosas.keySet()) {
			System.out.println(c+" -- "+cosas.get(c));
		}
				

	}

}
