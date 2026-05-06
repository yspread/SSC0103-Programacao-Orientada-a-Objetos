from Placar import Placar
from Dados import RolaDados

NRORODADAS = 10

def main():
    seed = int(input("Digite a semente (zero para aleatório): "))
    rd = RolaDados(5, seed)
    pl = Placar()
    print(Placar.toString(pl))
    for rodada in range(NRORODADAS):
        print(f"****** Rodada {(rodada+1)}")
        input("Pressione ENTER para lançar os dados\n")
        # primeira tentativa
        rd.rolar();
        print("1          2          3          4          5")
        print(RolaDados.toString(rd))
        # segunta tentativa
        muda = input("Digite os números dos dados que quiser TROCAR. Separados por espaços.\n")
        listabools = rd.stringToArray(muda)
        values = rd.rolar(listabools)
        print("1          2          3          4          5")
        print(RolaDados.toString(rd))
        # terceira tentativa
        muda = input("Digite os números dos dados que quiser TROCAR. Separados por espaços.\n")
        listabools = rd.stringToArray(muda)
        values = rd.rolar(listabools)
        print("1          2          3          4          5")
        print(RolaDados.toString(rd))
        
        print("\n\n")
        print(Placar.toString(pl))
        pos = 0
        while pos <= 0:
            try:
                pos = int(input("Escolha a posição que quer ocupar com essa jogada ===> "))
                if pos > NRORODADAS or pos <= 0:
                    pos = 0
                    raise ValueError()
                pl.add(pos, values)
            except ValueError:
                pos = 0
                print("Valor inválido. Posição ocupada ou inexistente.")
        
        print("\n\n")
        print(Placar.toString(pl))
    print("***********************************")
    print("***")
    print(f"*** Seu escore final foi: {pl.getScore()}")
    print("***")
    print("***********************************")


if __name__ == "__main__":
    main()