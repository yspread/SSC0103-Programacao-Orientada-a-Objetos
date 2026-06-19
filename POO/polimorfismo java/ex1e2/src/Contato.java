public abstract class Contato {
    protected String nome;
    protected String endereco;
    protected String email;

    public Contato(String nome, String endereco, String email){
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public String getEmail(){
        return this.email;
    }

    // Cada subclasse define qual é o seu documento (CPF ou CNPJ)
    public abstract String getDocumento();

    @Override
    public abstract String toString();
}