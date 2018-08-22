package challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public List<State> listThe10largestStatesInBrazil() {
		List<State> lista = new ArrayList<>();
		State state = new State("AM", "Amazonas");
		lista.add(state);	
		state = new State("PA", "Pará"); 
		lista.add(state);	
		state = new State("MT", "Mato Grosso"); 
		lista.add(state);	
		state = new State("MG", "Minas Gerais"); 
		lista.add(state);	
		state = new State("BA", "Bahia"); 
		lista.add(state);	
		state = new State("MS", "Mato Grosso do Sul"); 
		lista.add(state);	
		state = new State("GO", "Goiás"); 
		lista.add(state);	
		state = new State("MA", "Maranhão");
		lista.add(state);	
		state = new State("RS", "Rio Grande do Sul");
		lista.add(state);
		state = new State("TO", "Tocantins");
		lista.add(state);	

		
		return lista;
	}

}
