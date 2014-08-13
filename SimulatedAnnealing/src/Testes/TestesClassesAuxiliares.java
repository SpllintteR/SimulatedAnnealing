package Testes;

import junit.framework.Assert;

import org.junit.Test;

import pkg.Ligacao;
import pkg.Mapa;
import pkg.Ponto;


public class TestesClassesAuxiliares {
	
	@Test
	public void testAddLigacao(){
		Mapa mapa = new Mapa();
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
	public void testRemoveLigacao(){
		Mapa mapa = new Mapa();
		Ponto a = new Ponto(0, 0, "A");
		Ponto b = new Ponto(1, 1, "B");
		mapa.adicionaPonto(a);
		mapa.adicionaPonto(b);
		mapa.addLigacao(a, b);
		mapa.removeLigacao(mapa.buscaLigacao(a, b));
	}
	
	@Test
	public void testAddPonto(){
		
	}
	
	@Test
	public void testAddPontoPelaCoordenada(){
		
	}
	
	@Test
	public void testCalculaDistanciaLigacao(){
		
	}
	
	@Test
	public void testOutroPonto(){
		
	}
	
	@Test
	public void testGetDistancia(){
		
	}
	
	@Test
	public void testBuscaLigacaoAleatoria(){
		
	}
	
	@Test
	public void testAdicionaLigacao(){
		
	}
	
	@Test
	public void testArrefecimentoSimulado(){
		
	}
	
}
