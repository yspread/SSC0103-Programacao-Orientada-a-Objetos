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

    public String getCnpj(){
        return this.cnpj;
    }

    public String getInscricaosocial(){
        return this.inscricaosocial;
    }

    public String getRazaosocial(){
        return this.razaosocial;
    }

    @Override
    public String getDocumento(){
        return this.cnpj;
    }

    @Override
    public String toString(){
        return
                "  Nome: " + nome + "\n" +
                "  Endereco: " + endereco + "\n" +
                "  Email: " + email + "\n" +
                "  CNPJ: " + cnpj + "\n" +
                "  Inscricao Estadual: " + inscricaosocial + "\n" +
                "  Razao Social: " + razaosocial;
    }
}