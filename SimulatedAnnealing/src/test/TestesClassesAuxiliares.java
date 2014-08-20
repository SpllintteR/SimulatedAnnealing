package test;

import java.util.Random;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import pkg.Caminho;
import pkg.Ligacao;
import pkg.Mapa;
import pkg.Ponto;

public class TestesClassesAuxiliares {
	
	private final Mapa	mapa	= new Mapa();
	
	@Before
	public void tearDown() {
		mapa.limpar();
	}
	
	@Test
	public void testAddLigacao() {
		Ponto a = new Ponto(0, 0, "A");
		Ponto b = new Ponto(1, 1, "B");
		mapa.adicionaPonto(a);
		mapa.adicionaPonto(b);
		Ligacao ligacao = mapa.addLigacao(a, b);
		Assert.assertTrue(ligacao.getA().equals(a));
		Assert.assertTrue(ligacao.getB().equals(b));
		Ponto pontoA = mapa.getPonto("A");
		Ponto pontoB = pontoA.getLigacao(0).outroPonto(pontoA);
		Assert.assertTrue(ligacao.liga(pontoA, pontoB));
	}
	
	@Test
	public void testRemoveLigacao() {
		Ponto a = new Ponto(0, 0, "A");
		Ponto b = new Ponto(1, 1, "B");
		mapa.adicionaPonto(a);
		mapa.adicionaPonto(b);
		mapa.addLigacao(a, b);
		mapa.removeLigacao(mapa.buscaLigacao(a, b));
	}
	
	@Test
	public void testAddPonto() {
		Ponto a = new Ponto(0, 0, "A");
		mapa.adicionaPonto(a);
		Assert.assertNotNull(mapa.getPonto("A"));
	}
	
	@Test
	public void testAddPontoPelaCoordenada() {
		mapa.adicionaPonto(0, 0, "A");
		Assert.assertNotNull(mapa.getPonto("A"));
	}
	
	@Test
	public void testCalculaDistanciaLigacao() {
		Ponto a = new Ponto(0, 0, "A");
		Ponto b = new Ponto(3, 4, "B");
		mapa.adicionaPonto(a);
		mapa.adicionaPonto(b);
		Ligacao ligacao = mapa.addLigacao(a, b);
		Assert.assertEquals(5.0, ligacao.getDistancia());
	}
	
	@Test
	public void testOutroPonto() {
		Ponto a = new Ponto(0, 0, "A");
		Ponto b = new Ponto(1, 1, "B");
		Ligacao ligacao = mapa.addLigacao(a, b);
		Assert.assertEquals(b, ligacao.outroPonto(a));
	}
	
	@Test
	public void testBuscaLigacaoAleatoria() {
		Ponto a = new Ponto(0, 0, "A");
		Ponto b = new Ponto(0, 1, "B");
		Ponto c = new Ponto(1, 0, "C");
		Ponto d = new Ponto(1, 1, "D");
		
		mapa.adicionaPonto(a);
		mapa.adicionaPonto(b);
		mapa.adicionaPonto(c);
		mapa.adicionaPonto(d);
		
		mapa.addLigacao(a, b);
		mapa.addLigacao(a, c);
		mapa.addLigacao(a, d);
		
		Ponto pontoAleatorio1 = a.buscaLigacaoAleatoria().outroPonto(a);
		Assert.assertTrue(b.equals(pontoAleatorio1) || c.equals(pontoAleatorio1) || d.equals(pontoAleatorio1));
		
		a.limparLigacoesAleatorias();
		Ponto pontoAleatorio2 = a.buscaLigacaoAleatoria().outroPonto(a);
		Assert.assertTrue(b.equals(pontoAleatorio2) || c.equals(pontoAleatorio2) || d.equals(pontoAleatorio2));
		
		a.limparLigacoesAleatorias();
		Ponto pontoAleatorio3 = a.buscaLigacaoAleatoria().outroPonto(a);
		Assert.assertTrue(b.equals(pontoAleatorio3) || c.equals(pontoAleatorio3) || d.equals(pontoAleatorio3));
		
		Assert.assertTrue(pontoAleatorio1.equals(pontoAleatorio2) || pontoAleatorio1.equals(pontoAleatorio3)
				|| pontoAleatorio2.equals(pontoAleatorio3));
	}
	
	@Test
	public void testArrefecimentoSimulado() {
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Ponto ponto = new Ponto(i, j, "" + (char) (97 + i) + j);
				mapa.adicionaPonto(ponto);
				if (i > 0 && j > 0){
					for(int l = 0; l < 10; l++){
						int x = random.nextInt(i);
						int y = random.nextInt(j);
						Ponto ponto2 = mapa.getPonto("" + ((char) (97 + x)) + (y));
						mapa.addLigacao(ponto, ponto2);
					}
				}
			}
		}
		System.out.println(mapa.toString());
		Caminho caminho = mapa.buscaCaminhoMaisProximo(mapa.getPonto("a0"), mapa.getPonto("b0"), 30);
		System.out.println(caminho.toString());
		caminho = mapa.buscaCaminhoMaisProximo(mapa.getPonto("a0"), mapa.getPonto("b0"), 30);
		System.out.println(caminho.toString());
	}
}