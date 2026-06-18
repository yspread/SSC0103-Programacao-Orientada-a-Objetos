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
        this.agenda.remove(contato);
    }

    public void buscarContato(String valor){

    }

    public void listarContatos(){
        String contato;
        if (this.tamanho == 0){
            System.out.println("Lista vazia");
            return;
        }
        for(int i = 0; i < this.tamanho; i++){
            contato = toString();
            System.out.printf(toString(agenda.get(i));
        }
    }
}
