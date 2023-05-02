package fp.netflix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fp.utiles.Checkers;


public class FactoriaNetflix {
	private static final String DELIMITADOR_PRINCIPAL = ",";
	private static final String DELIMITADOR_SECUNDARIO = ";";

	public static CatalogoNetflix leeNetflix(String ruta) {
		CatalogoNetflix res = null;
		try {
			Stream<ProduccionNetflix> sv = Files.lines(Paths.get(ruta))
												.skip(1)
												.map(FactoriaNetflix::parse);
			res = new CatalogoNetflix(sv);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + ruta);
			e.printStackTrace();
		}
		return res;
	}

	public static ProduccionNetflix parse(String s) {
		Checkers.checkNoNull(s);
		String[] splits = s.replaceAll("\"", "").split(DELIMITADOR_PRINCIPAL);
		String msg = String.format("Formato no valido <%s>", s);
		Checkers.check(msg, splits.length == 8);
		
		String title = splits[0].trim();
		Tipo type = Tipo.valueOf(splits[1].trim());
		Integer releaseYear = Integer.valueOf(splits[2].trim());
		Duration duration = Duration.ofMinutes(Integer.valueOf(splits[3].trim()));
		Set<String> genres = parseaGeneros(splits[4].trim());
		Integer seasons = Integer.valueOf(splits[5].trim());
		Double imdbScore = Double.valueOf(splits[6].trim());
		Long imdbPopularity = Long.valueOf(splits[7].trim());

		return new ProduccionNetflix(title, type, releaseYear, duration, genres, seasons, imdbScore, imdbPopularity);
	}

	private static Set<String> parseaGeneros(String cad) {
		 String cleaned = cad.replace("[", "").replace("'", "").replace("]", "")
							.replaceAll(" ", "");
		 String [] splits = cleaned.split(DELIMITADOR_SECUNDARIO);
		 return Arrays.stream(splits)
		 			  .collect(Collectors.toSet());
	}
	
	
}
