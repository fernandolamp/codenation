package challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {
	private List<Jogador> lista = new ArrayList<>();

	public Main() throws IOException{
		String cvsFile = System.getProperty("user.dir")+"\\src\\main\\resources\\data.csv";

		FileReader filereader = new FileReader(cvsFile);
		BufferedReader buffreader = new BufferedReader(filereader);		
		//primeira linha é o cabeçalho
		buffreader.readLine();
		String linhaValor = buffreader.readLine();
		while(linhaValor != null){			
			Jogador jogador = new Jogador();			
			String[] atributos = linhaValor.split(",");			
			jogador.setId(Integer.parseInt(atributos[0]));
			try {
				jogador.setClube(atributos[3]);	
			} catch (Exception e) {
				System.out.println("");
			}
			
			jogador.setIdade(Integer.parseInt(atributos[6]));
			jogador.setNome(atributos[2]);
			String sVrRecisao = atributos[18];
			if (sVrRecisao.isEmpty()){
				sVrRecisao = "0";
			}
     		jogador.setVrRecisao(Double.parseDouble(sVrRecisao));							
			jogador.setNacionalidade(atributos[14]);
			lista.add(jogador);
			linhaValor = buffreader.readLine();
		}
		buffreader.close();		
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}
	
	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		List<Jogador> listaTemp;		
		listaTemp = lista.stream().filter(distinctByKey(Jogador::getNacionalidade)).collect(Collectors.toList());
		
		return listaTemp.size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {		
		List<Jogador> clubes = new ArrayList<>();		
		//tem que remover os jogadores que não tem clube
		clubes = lista.stream().filter(distinctByKey(Jogador::getClube)).filter(e-> !e.getClube().isEmpty()).collect(Collectors.toList());				
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
		List<Jogador> listaTemp = lista;
		List<String> listaNome = new ArrayList<>();
		listaTemp = lista.stream().sorted(Comparator.comparingDouble(Jogador::getVrRecisao).reversed()).collect(Collectors.toList());

		for (int i = 0; i < 10; i++) {
			listaNome.add(listaTemp.get(i).getNome());
		}
		return listaNome;
	}

	// Quem são os 10 jogadores mais velhos?
	// (utilize as colunas `full_name` e `birth_date`)
	//Nesse teste o codenation não tá especificando a ordem, estou enviando os 10 primeiros da lista de traz pra frente ordenados pela idade
	//mas ele não faz a verificação dos testes corretamente...
	public List<String> q5() {
		List<Jogador> listaTemp;
		List<String> listaNome = new ArrayList<>();		
		listaTemp = lista.stream().sorted(Comparator.comparingInt(Jogador::getIdade).reversed()).collect(Collectors.toList());
				
		for (int i = 0; i < 10; i++) {
			listaNome.add(listaTemp.get(i).getNome()+','+listaTemp.get(i).getIdade());			
		}						
		return listaNome;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		List<Jogador> listaTemp;		
		listaTemp = lista.stream().sorted(Comparator.comparingInt(Jogador::getIdade)).collect(Collectors.toList());

		Map<Integer,Integer> map = new HashMap<>();
		int idade = listaTemp.get(0).getIdade();
		int count = 0;
		for (Jogador jogador : listaTemp) {
		  	if(idade != jogador.getIdade()){
				  map.put(idade,count);
				  idade = jogador.getIdade();
				  count = 0;
			  }			  
		  	count++;
		}	
		//adiciona o último ;)
		map.put(idade, count);
		return map;	
	}

}
