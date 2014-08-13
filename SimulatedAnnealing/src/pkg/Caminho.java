package pkg;

import java.util.ArrayList;
import java.util.List;


public class Caminho {
	
	private List<Ligacao> ligacoes;
	private double custoTotal = 0;
	
	public Caminho(Ligacao ligacao) {
		ligacoes = new ArrayList<>();
		ligacoes.add(ligacao);
		custoTotal = ligacao.getDistancia();
	}

	/**
	 * @return the custoTotal
	 */
	public double getCustoTotal() {
		return custoTotal;
	}
	
	public void addLigacao(Ligacao ligacao){
		ligacoes.add(ligacao);
		custoTotal += ligacao.getDistancia();
	}
	
	public boolean removeLigacao(Ligacao ligacao){
		int i = 0;
		boolean found = false;
		while(i < ligacoes.size() && !found){
			found = ligacoes.get(i).equals(ligacao);
			i++;
		}
		if(found){
			ligacoes.remove(i - 1);
			custoTotal -= ligacao.getDistancia();
		}
		return found;
	}
	
}
