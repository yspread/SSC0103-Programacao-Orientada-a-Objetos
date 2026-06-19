public class Main{

    public static void main(String[] args){
        Agenda agenda = new Agenda();

        // ----- valores pre-definidos -----
        PessoaFisica pf1 = new PessoaFisica("Rafael Diesner", "Avenida São Carlos, 100", "rafael@email.com",
                "333.444.555-66", "08/11/2005", "Casado");
        PessoaFisica pf2 = new PessoaFisica("Julia Costa", "Rua Nabuco de Araújo, 1000", "julia@email.com",
                "111.222.333-44", "02/06/1992", "Solteira");
        PessoaJuridica pj1 = new PessoaJuridica("Padaria Luar", "Avenida Ana Costa, 10000", "luar@gmail.com",
                "98.765.432/0001-10", "IE-2233", "Padaria Luar Ltda");
        PessoaJuridica pj2 = new PessoaJuridica("Mercado Central", "Rua General Teles, 1", "central@gmail.com",
                "12.345.678/0001-99", "IE-1122", "Mercado Central Ltda");

        //adicionar
        System.out.println("===== ADICIONANDO CONTATOS =====");
        agenda.adicionarContato(pj1);
        agenda.adicionarContato(pf1);
        agenda.adicionarContato(pj2);
        agenda.adicionarContato(pf2);
        System.out.println("Total de contatos adicionados: " + agenda.getTamanho());

        //listar
        System.out.println("\n===== LISTANDO =====");
        agenda.listarContatos();

        //ordenar
        System.out.println("\n===== ORDENANDO =====");
        agenda.ordena();
        agenda.listarContatos();

        //busca
        System.out.println("\n===== BUSCANDO POR NOME 'Julia Costa' =====");
        Contato encontrado1 = agenda.buscarContato("Julia Costa");
        System.out.println(encontrado1 != null ? encontrado1.toString() : "Nao encontrado");

        System.out.println("\n===== BUSCANDO POR CNPJ '12.345.678/0001-99' =====");
        Contato encontrado2 = agenda.buscarContato("12.345.678/0001-99");
        System.out.println(encontrado2 != null ? encontrado2.toString() : "Nao encontrado");

        //remoção
        System.out.println("\n===== REMOVENDO 'Rafael Diesner' =====");
        boolean removido = agenda.removerContato("Rafael Diesner");
        System.out.println(removido ? "Contato removido." : "Contato nao encontrado.");

        //listar
        System.out.println("\n===== LISTANDO =====");
        agenda.listarContatos();
    }
}