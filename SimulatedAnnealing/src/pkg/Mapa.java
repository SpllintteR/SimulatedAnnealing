package pkg;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import algoritmos.declaracoes.AlgoritmoDeBusca;
import algoritmos.implementacoes.ArrefecimentoSimulado;


/**
 * Classe conhece todos os pontos e as ligações
 * @author Usuario
 *
 */
public class Mapa {
	
	private Map<String, Ponto> pontos;
	private AlgoritmoDeBusca algoritmo;
	
	public Mapa() {
		pontos = new HashMap<>();
	}

	public void adicionaPonto(Ponto ponto){
		Ponto put = pontos.put(ponto.getNome(), ponto);
		if(put != null){
			throw new RuntimeException("erro");
		}
	}
	
	public void adicionaPonto(int x, int y, String nome){
		adicionaPonto(new Ponto(x, y, nome));
	}
	
	public Ligacao addLigacao(Ponto a, Ponto b){
		return new Ligacao(a, b);
	}

	public Ponto getPonto(String nomeDoPonto) {
		return pontos.get(nomeDoPonto);
	}

	public Ligacao buscaLigacao(Ponto a, Ponto b) {
		return pontos.get(a.getNome()).buscaLigacaoCom(b);
	}

	public void removeLigacao(Ligacao buscaLigacao) {
		pontos.get(buscaLigacao.getA().getNome()).removeLigacao(buscaLigacao.getB());
		pontos.get(buscaLigacao.getB().getNome()).removeLigacao(buscaLigacao.getA());
	}

	public void limpar() {
		pontos.clear();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Map<String, Ligacao> ligacoes = new HashMap<>();
		sb.append("Pontos: ");
		for(Ponto ponto: pontos.values()){
			Map<String, Ligacao> innerLigacoes = ponto.getLigacoes();
			for(Ligacao lig: innerLigacoes.values()){
				ligacoes.put(lig.getNome(), lig);
			}
			sb.append(ponto.getNome() + ",");
		}
		sb.append("\nLigações: ");
		for(Ligacao ligacao: ligacoes.values()){
			sb.append(ligacao.getNome() + ",");
		}
		return sb.toString();
	}
	
	public void setAlgoritmoDeBusca(AlgoritmoDeBusca algoritmo){
		this.algoritmo = algoritmo;
	}
	
	public AlgoritmoDeBusca getAlgoritmoDeBusca(){
		if(algoritmo == null){
			algoritmo = new ArrefecimentoSimulado();
		}
		return algoritmo;
	}
	
	public Caminho buscaCaminhoMaisProximo(Ponto entrada, Ponto saida, int limite){
		return getAlgoritmoDeBusca().buscaCaminhoMaisProximo(entrada, saida, limite);
	}
	
}
