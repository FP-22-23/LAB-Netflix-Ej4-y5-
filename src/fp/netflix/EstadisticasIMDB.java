package fp.netflix;

import fp.utiles.Checkers;

public record EstadisticasIMDB(Double score, Long popularidad) {

	public EstadisticasIMDB {
		Checkers.checkNoNull(score, popularidad);
		Checkers.check("El score no está entre 0 y 10", score >= 0 && score <= 10);
		Checkers.check("La popularidad no es mayor o igual que cero", popularidad >= 0);
	}
}
