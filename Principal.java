import java.util.Scanner;

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

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de Cartão de Crédito!");
        System.out.print("Digite o número do cartão: ");
        String numero = scanner.nextLine();
        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("Digite o CPF do titular: ");
        String cpfTitular = scanner.nextLine();
        System.out.print("Digite o limite do cartão: ");
        double limite = scanner.nextDouble();
        System.out.print("Digite o saldo do cartão: ");
        double saldo = scanner.nextDouble();

        CartaoDeCredito cartao = new CartaoDeCredito(numero, nomeTitular, cpfTitular, limite, saldo);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Realizar Transação");
            System.out.println("2. Consultar Limite");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da transação: ");
                    double valor = scanner.nextDouble();
                    String resultado = cartao.realizarTransacao(valor);
                    System.out.println(resultado);
                    break;
                case 2:
                    double limiteDisponivel = cartao.consultarLimite();
                    System.out.printf("Limite disponível: %.2f%n", limiteDisponivel);
                    break;
                case 3:
                    double saldoAtual = cartao.consultarSaldo();
                    System.out.printf("Saldo atual: %.2f%n", saldoAtual);
                    break;
                case 4:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
