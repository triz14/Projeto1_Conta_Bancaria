package conta.model;

public class ContaCorrente extends Conta { // extends = herança/herda

	// Atributos
	private float limite;

	// Medoto especial - metodo construtor
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	// polimorfismo de sobrecarga
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = 5000.0f;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	// polimorfismo de sobrescrita => adiciona mais lógica
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de crédito: " + this.limite);
	}

	public boolean sacar(float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo insuficiente!");
			return false;
		}

		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

}