package challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private List<Jogador> lista = new ArrayList<>();

	public Main() throws FileNotFoundException{
		String cvsFile = System.getProperty("user.dir")+"\\src\\main\\resources\\data.csv";
		String paht =new File(".").getAbsolutePath();
		Scanner scanner = new Scanner(new File(cvsFile));		
		String linhaChave;
		String linhaValor;
		scanner.nextLine();
		while(scanner.hasNext()){
			Jogador jogador = new Jogador();
			linhaValor = scanner.nextLine();
			String[] atributos = linhaValor.split(",");

			jogador.setId(Integer.parseInt(atributos[0]));
			jogador.setClube(atributos[3]);
			jogador.setIdade(Integer.parseInt(atributos[6]));
			jogador.setNome(atributos[2]);
			jogador.setVrRecisao(Double.parseDouble(atributos[18]));
			lista.add(jogador);
		}
	}

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		return lista.size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {		
		List<String> clubes = new ArrayList<>();
		for (Jogador jogador : lista) {
			if (!clubes.contains(jogador.getClube())){
				clubes.add(jogador.getClube());
			}
		}
		return clubes.size();
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		int i;
		List<String> listaNome = new ArrayList<>();
		for (i=0; i<20; i++){
			listaNome.add(lista.get(i).getNome());			
		}
		return listaNome;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		return null;
	}

	// Quem são os 10 jogadores mais velhos?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return null;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return null;
	}

}
