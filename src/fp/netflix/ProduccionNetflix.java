package fp.netflix;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public class ProduccionNetflix implements Comparable<ProduccionNetflix>{
	private String titulo;
	private Tipo tipo;
	private Integer anyoProduccion;
	private Duration duracion;
	private Set<String> generos;
	private Integer numeroTemporadas;
	private EstadisticasIMDB imdb; 

	private static final Integer ANYO_LIMITE = 1900;
	

	public ProduccionNetflix(String titulo, Tipo tipo, Integer anyoProduccion, Duration duracion, Set<String> generos,
			Integer numeroTemporadas, Double score, Long popularidad) {
		Checkers.checkNoNull(titulo, tipo, anyoProduccion, duracion, generos, numeroTemporadas);
		Checkers.check("El año de producción no es superior a " + ANYO_LIMITE, anyoProduccion > ANYO_LIMITE);
		Checkers.check("El número de temporadas no concuerda con el tipo de show", 
				 tipo.equals(Tipo.SHOW) && numeroTemporadas > 0
				 || tipo.equals(Tipo.MOVIE) && numeroTemporadas.equals(0));
		this.titulo = titulo;
		this.tipo = tipo;
		this.anyoProduccion = anyoProduccion;
		this.duracion = duracion;
		this.generos = generos;
		this.numeroTemporadas = numeroTemporadas;
		this.imdb = new EstadisticasIMDB(score, popularidad);
	}

	public String getTitulo() {
		return titulo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Integer getAnyoProduccion() {
		return anyoProduccion;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public Set<String> getGeneros() {
		return generos;
	}

	public Integer getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public Double getScore() {
		return imdb.score();
	}
	
	public Long getPopularidad() {
		return imdb.popularidad();
	}

	
	@Override
	public String toString() {
		return "ProduccionNetflix [titulo=" + titulo + ", tipo=" + tipo + ", anyoProduccion=" + anyoProduccion
				+ ", duracion=" + duracion + ", generos=" + generos + ", numeroTemporadas=" + numeroTemporadas
				+ ", imdb=" + imdb + "]";
	}

	public int hashCode() {
		return Objects.hash(anyoProduccion, titulo);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProduccionNetflix other = (ProduccionNetflix) obj;
		return Objects.equals(anyoProduccion, other.anyoProduccion) && Objects.equals(titulo, other.titulo);
	}

	public int compareTo(ProduccionNetflix o) {
		int cmp = getTitulo().compareTo(o.getTitulo());
		if (cmp == 0) {
			cmp = getAnyoProduccion().compareTo(o.getAnyoProduccion());
		}
		return cmp;
	}



	

}
