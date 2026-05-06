import math

class Tabuleiro:
    def __init__(self, length, valores):
        # Construtor do tabuleiro
        self.length = length
        self.table = [[0 for _ in range(length)] for _ in range(length)]
        
        c = 0
        for i in range(length):
            for j in range(length):
                self.table[i][j] = valores[c]
                c += 1

    def up(self, zerolinha, zerocoluna):
        if zerolinha + 1 < self.length:
            temp = self.table[zerolinha + 1][zerocoluna]
            self.table[zerolinha + 1][zerocoluna] = 0  # o zero desce 1 posição, se possível
            self.table[zerolinha][zerocoluna] = temp
            return True
        return False

    def down(self, zerolinha, zerocoluna):
        if zerolinha - 1 >= 0:
            temp = self.table[zerolinha - 1][zerocoluna]
            self.table[zerolinha - 1][zerocoluna] = 0  # o zero sobe 1 posição, se possível
            self.table[zerolinha][zerocoluna] = temp
            return True
        return False

    def right(self, zerolinha, zerocoluna):
        if zerocoluna - 1 >= 0:
            temp = self.table[zerolinha][zerocoluna - 1]
            self.table[zerolinha][zerocoluna - 1] = 0   # o zero vai pra esquerda 1 posição, se possível
            self.table[zerolinha][zerocoluna] = temp
            return True
        return False

    def left(self, zerolinha, zerocoluna):
        if zerocoluna + 1 < self.length:
            temp = self.table[zerolinha][zerocoluna + 1]
            self.table[zerolinha][zerocoluna + 1] = 0   # o zero vai pra direita 1 posição, se possível
            self.table[zerolinha][zerocoluna] = temp
            return True
        return False

    def is_solved(self):
        #verificação de se o tabuleiro está resolvido
        c = 0
        for i in range(self.length):
            for j in range(self.length):
                if c != self.table[i][j]:
                    return False
                c += 1
        return True

    def print_table(self): # impressão do tabuleiro
        c = '|'
        for i in range(self.length):
            for j in range(self.length):
                print("+------", end="")
            print("+")
            
            print(f"{c}", end="")
            for j in range(self.length):
                valor = self.table[i][j]
                if valor == 0: # verificação caso valor seja 0, devemos imprimir vazio
                    print(f"{'':>4}{c:>3}", end="")
                else:
                    print(f"{valor:4d}{c:>3}", end="")
            print()
            
        for j in range(self.length):
            print("+------", end="")
        print("+")
        print()


def main():
    # lemos a linha de valores
    try:
        line1 = input()
    except EOFError:
        return
        
    # convertemos os valores da string para inteiros
    numeros_str = line1.split()
    numerosint = [int(num) for num in numeros_str]
    
    # lenght do tabuleiro é a raiz quadrada da quantidade de números (pelo fato do tabuleiro ser uma matriz quadrada)
    length = int(math.sqrt(len(numerosint)))
    
    linhazero = 0
    colunazero = 0
    
    # calculamos a posição do 0 na matriz
    for i in range(len(numerosint)):
        if numerosint[i] == 0:
            linhazero = i // length 
            colunazero = i % length
            
    # construção do tabuleiro
    table = Tabuleiro(length, numerosint)
    
    # leitura da string de comandos
    try:
        line2 = input()
    except EOFError:
        line2 = ""
        
    table.print_table()
    
    # verificação de qual comando será usado
    for comando in line2:
        if comando == 'u':
            if table.up(linhazero, colunazero):
                linhazero += 1
        elif comando == 'd':
            if table.down(linhazero, colunazero):
                linhazero -= 1
        elif comando == 'l':
            if table.left(linhazero, colunazero):
                colunazero += 1
        elif comando == 'r':
            if table.right(linhazero, colunazero):
                colunazero -= 1
                
        table.print_table() # printamos cada estado
        
    # verificação do estado final
    if table.is_solved():
        print("Posicao final: True")
    else:
        print("Posicao final: False")
        
if __name__ == "__main__":
    main()