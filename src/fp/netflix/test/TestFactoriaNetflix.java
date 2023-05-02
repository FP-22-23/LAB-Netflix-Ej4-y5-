package fp.netflix.test;


import fp.netflix.CatalogoNetflix;
import fp.netflix.FactoriaNetflix;


public class TestFactoriaNetflix {

	public static void main(String[] args) {
		CatalogoNetflix c = FactoriaNetflix.leeNetflix("data/titulos_netflix.csv");
		System.out.println(c);
	}

	

}
