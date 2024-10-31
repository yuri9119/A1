class CartãoDeCrédito {
    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private double limite;
    private double saldo;

    public CartãoDeCrédito(String numero, String nomeTitular, String cpfTitular, double limite, double saldo) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double consultarSaldo() {
        return getSaldo();
    }

    public double consultarLimite() {
        return getLimite();
    }

    public String realizarTransacao(double valor) {
        if (valor <= 0) {
            return "Valor inválido para a transação.";
        }
        if (valor > getLimite()) {
            return "Transação negada: valor acima do limite.";
        }
        if (valor > getSaldo()) {
            return "Transação negada: saldo insuficiente.";
        }

        setSaldo(getSaldo() - valor);
        return String.format("Transação realizada. Novo saldo: %.2f", getSaldo());
    }

    public String alterarLimite(double novoLimite) {
        setLimite(novoLimite);
        return String.format("Limite alterado. Novo limite: %.2f", getLimite());
    }
}
