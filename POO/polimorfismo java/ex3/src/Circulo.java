public class Circulo extends Formas{
    private double raio;

    public Circulo(String filled, String cor,double raio){
        super(filled, cor);
        this.raio = raio;
    }

    @Override
    public double getArea(){
        double area = 3.14  * raio * raio;
        return area;
    }

    @Override
    public double getPerimetro(){
        double perimetro = 2 * 3.14 * raio;
        return perimetro;
    }
}
