public class Retangulo extends Formas{
    private double lado1;
    private double lado2;

    public Retangulo(String filled, String cor, double lado1, double lado2){
        super(filled, cor);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double getArea(){
        double area = lado1 * lado2;
        return area;
    }

    @Override
    public double getPerimetro(){
        double perimetro = 2 * (lado1 + lado2);
        return perimetro;
    }
}
