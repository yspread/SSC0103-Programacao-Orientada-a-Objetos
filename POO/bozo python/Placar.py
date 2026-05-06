# classe para representar o placar do jogo
class Placar:
    def __init__(self):
        self.posicoes = 10
        self.placar = [0] * self.posicoes
        self.taken = [False] * self.posicoes
    
    # método adiciona um conjunto de dados a uma posição
    # dados contem os valores da face atual de todos os dados lançados
    # sobre as posicoes: 1 a 6 sao as laterais,  7 - full hand, 8 - sequencia, 9 - quadra, 10 - quina
    def add(self, posicao, dados):
        if self.taken[posicao-1]:
            raise ValueError("Posição ocupada")
        k = 0
        if 1 <= posicao <= 6:
            k = posicao * self.conta(posicao, dados)
        elif posicao == 7:
            if self.checkFull(dados):
                k = 15
        elif posicao == 8:
            if self.checkSeqMaior(dados):
                k = 20
        elif posicao == 9:
            if self.checkQuadra(dados):
                k = 30
        elif posicao == 10:
            if self.checkQuinta(dados):
                k = 40
        else:
            raise ValueError("Valor da posição ilegal")
        self.placar[posicao-1] = k
        self.taken[posicao-1] = True
    
    # calcula a soma dos valores no placar
    def getScore(self):
        t = 0
        for i in range(self.posicoes):
            if self.taken[i]:
                t += self.placar[i]
        return t
    
    def conta(self, n, dados):
        return dados.count(n)
    
    def checkFull(self, dados):
        v = sorted(dados)
        return ((v[0] == v[1] and v[1] == v[2] and v[3] == v[4]) or (v[0] == v[1] and v[2] == v[3] and v[3] == v[4]))
    
    def checkQuadra(self, dados):
        v = sorted(dados)
        return ((v[0] == v[1] and v[1] == v[2] and v[2] == v[3]) or (v[1] == v[2] and v[2] == v[3] and v[3] == v[4]))
    
    def checkQuinta(self, dados):
        return (len(set(dados)) == 1)
    
    def checkSeqMaior(self, dados):
        v = sorted(dados)
        return (v[0] == v[1]-1 and v[1] == v[2]-1 and v[2] == v[3]-1 and v[3] == v[4]-1)
    
    # metodo pra transformar o placar em uma string
    def toString(self):
        s = ""
        for i in range(3):
            num1 = f"{self.placar[i]:<4}" if self.taken[i] else f"({i + 1}) "
            if self.taken[i]:
                s += f" {num1}  |   "
            else:
                s += f"{num1}   |   "
                
            if self.taken[i + 6]:
                s += " "
            
            num2 = f"{self.placar[i + 6]:<4}" if self.taken[i + 6] else f"({i + 7}) "
            if self.taken[i + 6]:
                s += f"{num2}  |  "
            else:
                s += f"{num2}   |  "
            
            num3 = f"{self.placar[i + 3]:<4}" if self.taken[i + 3] else f"({i + 4}) "
            if self.taken[i + 3]:
                s += f" {num3}\n-------|----------|-------\n"
            else:
                s += f"{num3}\n-------|----------|-------\n"

        num10 = f"{self.placar[9]:<4}" if self.taken[9] else "(10)"
        if self.taken[9]:
            s += f"       |    {num10}  |"
        else:
            s += f"       |   {num10}   |"
        s += "\n       +----------+\n"
        return s