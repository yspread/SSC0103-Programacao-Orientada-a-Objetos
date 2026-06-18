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



}
