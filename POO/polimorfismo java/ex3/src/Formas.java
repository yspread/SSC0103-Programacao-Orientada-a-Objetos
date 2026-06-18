public abstract class Formas {
    protected String filled;
    protected String cor;

    public Formas(String filled, String cor){
        this.filled = filled;
        this.cor = cor;
    }

    public abstract double getArea();
    public abstract double getPerimetro();

    public void estaPintado(){
        if (this.filled.compareTo("nao") == 0){
            System.out.println("A forma não está pintada.\n");
        }
        else{
            System.out.println("A forma tem a cor " + this.cor);
        }
    }
}
