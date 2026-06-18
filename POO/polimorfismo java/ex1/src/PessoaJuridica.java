public class PessoaJuridica extends Contato{
    private String cnpj;
    private String inscricaosocial;
    private String razaosocial;

    public PessoaJuridica(String nome, String endereco, String email, String cnpj, String inscricaosocial, String razaosocial){
        super(nome, endereco, email);
        this.cnpj = cnpj;
        this.inscricaosocial = inscricaosocial;
        this.razaosocial = razaosocial;
    }

    @Override
    public String toString(){

    }
}
