package pkg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Ponto {
	
	private int x;
	private int y;
	private String nome;
	private Map<String, Ligacao> ligacoes;
	
	public Ponto(int x, int y, String nome) {
		super();
		this.x = x;
		this.y = y;
		this.nome = nome;
	}

	public Ponto() {
		ligacoes = new HashMap<>();
	}

	public void adicionaLigacao(Ligacao b) {
		ligacoes.put(b.getNome(), b);
	}
	
	public Ligacao buscaLigacaoAleatoria(){
		if (ligacoes.size() == 0){
			return null;
		}
		return ligacoes.get(new Random().nextInt(ligacoes.size()));
	}
	
	public Ligacao getLigacao(int index){
		return ligacoes.get(index);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	public Ligacao buscaLigacaoCom(Ponto b) {
		for(Ligacao ligacao: ligacoes.values()){
			if(ligacao.liga(this, b)){
				return ligacao;
			}
		}
		return null;
	}

	public void removeLigacao(Ponto b) {
		ligacoes.remove(getNome() + b.getNome());
		ligacoes.remove(b.getNome() + getNome());
	}
	
}