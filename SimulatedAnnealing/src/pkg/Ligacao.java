package pkg;


public class Ligacao {

	private Ponto a;
	private Ponto b;
	private double distancia = 0;
	private String	nome;
	
	public Ligacao(Ponto a, Ponto b) {
		this.a = a;
		this.b = b;
		a.adicionaLigacao(this);
		b.adicionaLigacao(this);
		nome = a.getNome() + b.getNome();
	}

	private double calculaDistancia() {
		return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
	}

	public boolean liga(Ponto entrada, Ponto saida) {
		return (a.equals(entrada) && b.equals(saida)) || (a.equals(saida) && b.equals(entrada));
	}

	public Ponto outroPonto(Ponto entrada) {
		return a.equals(entrada) ? b : b.equals(entrada) ? a : null;
	}

	/**
	 * @return the distancia
	 */
	public double getDistancia() {
		if (distancia == 0){
			distancia = calculaDistancia();
		}
		return distancia;
	}

	
	/**
	 * @return the a
	 */
	public Ponto getA() {
		return a;
	}

	
	/**
	 * @return the b
	 */
	public Ponto getB() {
		return b;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
