//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo("sim", "branco", 5);
        double areacirculo1 = circulo1.getArea();
        double perimetrocirculo1 = circulo1.getPerimetro();

        System.out.printf("área circulo: %.2f\n", areacirculo1);
        System.out.printf("perímetro circulo: %.2f\n", perimetrocirculo1);
        circulo1.estaPintado();

        System.out.println();

        Quadrado quadrado1 = new Quadrado("sim", "rosa-choque", 5);
        double areaquadrado1 = quadrado1.getArea();
        double perimetroquadrado1 = quadrado1.getPerimetro();

        System.out.printf("área quadrado: %.2f\n", areaquadrado1);
        System.out.printf("perimetro quadrado: %.2f\n", perimetroquadrado1);
        quadrado1.estaPintado();

        System.out.println();

        Retangulo retangulo1 = new Retangulo("nao", "preto", 5, 394);
        double arearetangulo1 = retangulo1.getArea();
        double perimetroretangulo1 = retangulo1.getPerimetro();

        System.out.printf("área retangulo: %.2f\n", arearetangulo1);
        System.out.printf("perimetro retangulo: %.2f\n", perimetroretangulo1);
        retangulo1.estaPintado();
    }
}