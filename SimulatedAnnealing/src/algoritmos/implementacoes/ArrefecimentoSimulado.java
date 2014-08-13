package algoritmos.implementacoes;

import pkg.Caminho;
import pkg.Ligacao;
import pkg.Ponto;
import algoritmos.declaracoes.AlgoritmoDeBusca;


public class ArrefecimentoSimulado implements AlgoritmoDeBusca{

	@Override
	public Caminho buscaCaminhoMaisProximo(Ponto entrada, Ponto saida) {
		boolean found = false;
		Caminho result = null;
		double menorCusto = Double.MAX_VALUE;
		Caminho caminhoTemp;
		Ponto pontoTemp;
		while(!found){
			Ligacao ligacao = entrada.buscaLigacaoAleatoria();
			if (ligacao.liga(entrada, saida)){
				return new Caminho(ligacao);
			}
			pontoTemp = ligacao.outroPonto(entrada);
			caminhoTemp = buscaCaminhoMaisProximo(pontoTemp, saida);
			if (menorCusto > caminhoTemp.getCustoTotal()){
				menorCusto = caminhoTemp.getCustoTotal();
				result = caminhoTemp;
			}
		}
		return result;
		
	}
	
}
