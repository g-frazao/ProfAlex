class Pessoa {
    protected String nome;
    protected String telefone;
    protected String email;
    protected String endereco;
    protected double valorDesconto;

    public Pessoa(String nome, String telefone, String email, String endereco, double valorDesconto) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.valorDesconto = valorDesconto;
    }

    public void calcularDesconto(double percentualDesconto) {
        valorDesconto = percentualDesconto;
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
        System.out.println("Endereço: " + endereco);
        System.out.println("Valor de Desconto: " + valorDesconto);
    }
}

class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String nome, String telefone, String email, String endereco, double valorDesconto, String cpf) {
        super(nome, telefone, email, endereco, valorDesconto);
        this.cpf = cpf;
    }

    @Override
    public void calcularDesconto(double percentualDesconto) {
        valorDesconto = percentualDesconto + 10;
    }

    @Override
    public void imprimirDados() {
        super.imprimirDados();
        System.out.println("CPF: " + cpf);
    }
}

class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String nome, String telefone, String email, String endereco, double valorDesconto, String cnpj) {
        super(nome, telefone, email, endereco, valorDesconto);
        this.cnpj = cnpj;
    }

    @Override
    public void calcularDesconto(double percentualDesconto) {
        valorDesconto = percentualDesconto + 20;
    }

    @Override
    public void imprimirDados() {
        super.imprimirDados();
        System.out.println("CNPJ: " + cnpj);
    }
}

public class Main {
    public static void main(String[] args) {
        PessoaFisica pessoaFisica = new PessoaFisica("João", "123456789", "joao@example.com", "Rua A, 123", 0, "123.456.789-00");
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa XYZ", "987654321", "contato@empresa.com", "Av. B, 456", 0, "12.345.678/0001-00");

        pessoaFisica.calcularDesconto(100);
        pessoaJuridica.calcularDesconto(200);

        pessoaFisica.imprimirDados();
        System.out.println();
        pessoaJuridica.imprimirDados();
    }
}
