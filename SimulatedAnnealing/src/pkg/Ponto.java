package pkg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Ponto {
	
	private int x;
	private int y;
	private String nome;
	private Map<String, Ligacao> ligacoes;
	private Map<Integer, Integer> ligacoesAleatoriasRetornadas;
	
	public Ponto(int x, int y, String nome) {
		ligacoes = new HashMap<>();
		this.x = x;
		this.y = y;
		this.nome = nome;
		ligacoesAleatoriasRetornadas = new HashMap<>();
	}

	public Ponto() {
		ligacoes = new HashMap<>();
		ligacoesAleatoriasRetornadas = new HashMap<>();
	}

	public void adicionaLigacao(Ligacao b) {
		ligacoes.put(b.getNome(), b);
	}
	
	public Ligacao buscaLigacaoAleatoria(){
		if (ligacoes.size() == 0 || ligacoesAleatoriasRetornadas.size() == ligacoes.size()){
			return null;
		}
		int index;
		do{
			index = new Random().nextInt(ligacoes.size());
		}while(ligacoesAleatoriasRetornadas.containsKey(index));
		
		ligacoesAleatoriasRetornadas.put(index, index);
		return getLigacao(index);
	}
	
	public Ligacao getLigacao(int index){
		return (Ligacao) ligacoes.values().toArray()[index];
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

	public Map<String, Ligacao> getLigacoes() {
		return ligacoes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getNome();
	}

	public void limparLigacoesAleatorias() {
		ligacoesAleatoriasRetornadas.clear();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getNome().hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		Ponto p = (Ponto) obj ;
		boolean result = getX() == p.getX();
		result &= getY() == p.getY();
		result &= getNome().equals(p.getNome());
		result &= getLigacoes().size() == p.getLigacoes().size();
//		for(Ligacao ligacao: ligacoes.values()){
//			result &= ligacao.equals(p.getLigacoes().get(ligacao.getNome()));
//			if(!result){
//				break;
//			}
//		}
		return result;
	}
	
}