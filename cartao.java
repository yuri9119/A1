
class CartaoDeCredito {
    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private double limite;
    private double saldo;

    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, double limite, double saldo) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = saldo;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public double consultarLimite() {
        return limite;
    }

    public String realizarTransacao(double valor) {
        if (valor <= 0) {
            return "Valor inválido para a transação.";
        }
        if (valor > limite) {
            return "Transação negada: valor acima do limite.";
        }
        if (valor > saldo) {
            return "Transação negada: saldo insuficiente.";
        }

        saldo -= valor;
        return String.format("Transação realizada com sucesso! Novo saldo: %.2f", saldo);
    }
}