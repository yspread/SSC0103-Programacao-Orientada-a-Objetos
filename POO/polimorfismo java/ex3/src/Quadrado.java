public class Quadrado extends Formas{
    private double lado;

    public Quadrado(String filled, String cor, double lado){
        super(filled, cor);
        this.lado = lado;
    }

    @Override
    public double getArea(){
        double area = lado * lado;
        return area;
    }

    @Override
    public double getPerimetro(){
        double perimetro = lado * 4;
        return perimetro;
    }
}
