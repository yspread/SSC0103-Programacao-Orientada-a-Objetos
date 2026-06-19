public class PessoaFisica extends Contato{
    private String cpf;
    private String nascimento;
    private String estadocivil;

    public PessoaFisica(String nome, String endereco, String email, String cpf, String nascimento, String estadocivil){
        super(nome, endereco, email);
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.estadocivil = estadocivil;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getNascimento(){
        return this.nascimento;
    }

    public String getEstadocivil(){
        return this.estadocivil;
    }

    @Override
    public String getDocumento(){
        return this.cpf;
    }

    @Override
    public String toString(){
        return  "  Nome: " + nome + "\n" +
                "  Endereco: " + endereco + "\n" +
                "  Email: " + email + "\n" +
                "  CPF: " + cpf + "\n" +
                "  Nascimento: " + nascimento + "\n" +
                "  Estado Civil: " + estadocivil;
    }
}