package pkg;

import java.util.HashMap;
import java.util.Map;


/**
 * Classe conhece todos os pontos e as ligações
 * @author Usuario
 *
 */
public class Mapa {
	
	private Map<String, Ponto> pontos;
	
	public Mapa() {
		pontos = new HashMap<>();
	}

	public void adicionaPonto(Ponto ponto){
		pontos.put(ponto.getNome(), ponto);
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
		pontos.get(buscaLigacao.getA()).removeLigacao(buscaLigacao.getB());
		pontos.get(buscaLigacao.getB()).removeLigacao(buscaLigacao.getA());
	}
	
}
