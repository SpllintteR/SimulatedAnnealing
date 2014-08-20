package algoritmos.implementacoes;

import java.util.HashMap;
import java.util.Map;

import pkg.Caminho;
import pkg.Ligacao;
import pkg.Ponto;
import algoritmos.declaracoes.AlgoritmoDeBusca;


public class ArrefecimentoSimulado implements AlgoritmoDeBusca{

	private Caminho buscaCaminhoMaisProximo(Map<String, Ponto> caminho, final Ponto entrada, final Ponto saida, final int limite) {
		Caminho caminhoTemp = null;
		Caminho result = null;
		Ligacao ligacaoTemp = null;
		double menorCusto = Double.MAX_VALUE;
		Ponto pontoTemp = null;
		entrada.limparLigacoesAleatorias();
		for(int i = 0; i < limite; i++){
			Ligacao ligacao = entrada.buscaLigacaoAleatoria();
			if(ligacao == null){
				break;
			}
			if (ligacao.liga(entrada, saida)){
				return new Caminho(ligacao); 
			}
			pontoTemp = ligacao.outroPonto(entrada);
			if(!caminho.containsKey(pontoTemp.getNome())){
				caminho.put(pontoTemp.getNome(), pontoTemp);
				caminhoTemp = buscaCaminhoMaisProximo(caminho, pontoTemp, saida, limite - 1);
				caminho.remove(pontoTemp.getNome());
				if(caminhoTemp != null){
					if (menorCusto > caminhoTemp.getCustoTotal()){
						ligacaoTemp = ligacao;
						menorCusto = caminhoTemp.getCustoTotal();
						result = caminhoTemp;
					}
				}
			}
		}
		if (result != null){
			result.addLigacao(ligacaoTemp);
		}
		return result;		
	}
	
	@Override
	public Caminho buscaCaminhoMaisProximo(Ponto entrada, Ponto saida, int limite) {
		HashMap<String, Ponto> caminho = new HashMap<String, Ponto>();
		caminho.put(entrada.getNome(), entrada);
		return buscaCaminhoMaisProximo(caminho, entrada, saida, limite);
	}
	
}
