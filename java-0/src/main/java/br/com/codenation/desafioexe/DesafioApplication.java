package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

import br.com.codenation.TestadorFibonacci;
import br.com.codenation.annotation.Desafio;

public class DesafioApplication {

	public static void main(String[] args) {
		new TestadorFibonacci().testaDesafio(DesafioApplication.class);
	}

	@Desafio("Fibonacci")
	public static List<Integer> fibonacci() {					
		return montaFib(350);
	}
	private static List<Integer> montaFib(int max){
		List<Integer> lista = new ArrayList<>();		
		Integer i = 0;
		int fib = 0;		
		if(max <= 0 ){			
			return lista;
		}
		lista.add(0);
		lista.add(1);	
		if (max == 1){
			return lista;
		}
    	 while (fib < max){
			int index = lista.size()-1;
			fib = lista.get(index)+lista.get(index-1);			
			lista.add(fib);			
			i++;
		}
		return lista;		
	}

	@Desafio("isFibonacci")
	public static Boolean isFibonacci(Integer a) {			 
		 return fibonacci().contains(a);		
	}	
}
