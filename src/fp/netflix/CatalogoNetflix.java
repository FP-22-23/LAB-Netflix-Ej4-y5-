package fp.netflix;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CatalogoNetflix {

	private SortedSet<ProduccionNetflix> producciones;

	public SortedSet<ProduccionNetflix> getProducciones() {
		return new TreeSet<>(producciones);
	}

	public CatalogoNetflix(Stream<ProduccionNetflix> stream) {
		Comparator<ProduccionNetflix> cmp = Comparator.comparing(ProduccionNetflix::getAnyoProduccion)
				.thenComparing(Comparator.naturalOrder());
		this.producciones = stream.collect(Collectors.toCollection(() -> new TreeSet<>(cmp)));
	}
	
	public int hashCode() {
		return Objects.hash(producciones);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatalogoNetflix other = (CatalogoNetflix) obj;
		return Objects.equals(producciones, other.producciones);
	}

	public String toString() {
		String result = "";
		for(ProduccionNetflix t: getProducciones()) {
			result += t.toString() + "\n";
		}
		return result;
	}

	// APARTADO 1 ======================================================================================

	// APARTADO 2 ======================================================================================
	
	// APARTADO 3 ======================================================================================
	

	// APARTADO 4 ======================================================================================
	
		
	// APARTADO 5 ======================================================================================
	
		// EJERCICIO 5. APARTADO 1 ======================================================================================
	
		
	// EJERCICIO 5. APARTADO 2 ======================================================================================
	
	// EJERCICIO 5. APARTADO 3 ======================================================================================
	
	// EJERCICIO 5. APARTADO 4 ======================================================================================
	
	// EJERCICIO 5. APARTADO 5 ======================================================================================
		
	// EJERCICIO 5. APARTADO 6 ======================================================================================
	
}