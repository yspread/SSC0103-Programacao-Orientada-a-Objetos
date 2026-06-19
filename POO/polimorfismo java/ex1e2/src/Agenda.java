import java.util.Vector;

public class Agenda{
    private Vector<Contato> agenda;
    private int tamanho;

    public Agenda(){
        this.agenda = new Vector<Contato>();
        this.tamanho = 0;
    }

    public void adicionarContato(Contato contato){
        this.agenda.add(contato);
        this.tamanho++;
    }

    public void removerContato(Contato contato){
        boolean removido = this.agenda.remove(contato);
        if (removido){
            this.tamanho--;
        }
    }

    public boolean removerContato(String valor){
        Contato encontrado = buscarContato(valor);
        if (encontrado == null){
            return false;
        }
        this.agenda.remove(encontrado);
        this.tamanho--;
        return true;
    }

    public Contato buscarContato(String valor){
        for (int i = 0; i < this.tamanho; i++){
            Contato c = this.agenda.get(i);
            if (c.getNome().equalsIgnoreCase(valor) ||
                    (c.getDocumento() != null && c.getDocumento().equalsIgnoreCase(valor))){
                return c;
            }
        }
        return null;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public void listarContatos(){
        if (this.tamanho == 0){
            System.out.println("Lista vazia");
            return;
        }
        for (int i = 0; i < this.tamanho; i++){
            System.out.println(agenda.get(i).toString());
            System.out.println("\n");
        }
    }

    public void ordena(){
        for (int i = 0; i < this.tamanho - 1; i++){
            for (int j = 0; j < this.tamanho - 1 - i; j++){
                Contato atual = this.agenda.get(j);
                Contato proximo = this.agenda.get(j + 1);

                if (compara(atual, proximo) > 0){
                    this.agenda.set(j, proximo);
                    this.agenda.set(j + 1, atual);
                }
            }
        }
    }

    private int compara(Contato a, Contato b){
        boolean aEhFisica = (a instanceof PessoaFisica);
        boolean bEhFisica = (b instanceof PessoaFisica);

        if (aEhFisica && !bEhFisica){
            return -1;
        }
        if (!aEhFisica && bEhFisica){
            return 1;
        }

        // mesmo tipo: compara pelo documento (CPF/CNPJ)
        String docA = (a.getDocumento() == null) ? "" : a.getDocumento();
        String docB = (b.getDocumento() == null) ? "" : b.getDocumento();
        return docA.compareTo(docB);
    }
}