//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Formas forma1 = new Circulo("sim", "branco", 5);
        Formas forma2 = new Quadrado("sim", "rosa-choque", 5);
        Formas forma3 = new Retangulo("nao", "preto", 5, 394);

        Formas[] listaDeFormas = {forma1, forma2, forma3};

        for (Formas formaAtual : listaDeFormas) {
            System.out.println("--- " + formaAtual.getClass().getSimpleName() + " ---");

            System.out.printf("Área: %.2f\n", formaAtual.getArea());
            System.out.printf("Perímetro: %.2f\n", formaAtual.getPerimetro());
            formaAtual.estaPintado();

            System.out.println();
        }
    }
}