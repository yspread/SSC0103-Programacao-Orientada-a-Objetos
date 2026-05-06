import random

# Classe para representar um dado
class Dado:
    # construtor do dado
    def __init__(self, lados=6, seed=None):
        self.lados = lados
        
        # aplica o gerador de números aleatórios (semente opcional)
        if seed is not None:
            self.r = random.Random(seed)
        else:
            self.r = random.Random()
        
        # rolagem inicial do dado
        self.rolar()
    
    # método para rolagem baseada no número gerado aleatóriamente
    def rolar(self):
        self.atual = self.r.randint(1, self.lados) 
        return self.atual
    
    # método para acessar o valor atual do dado
    def getLado(self):
        return self.atual

    # método pra transformar o lado do dado na string correspondente
    def toString(self):
        if self.lados != 6:
            return "Não há representação para esse dados"
        s = "+-----+\n"
        s010 = "|  *  |\n"
        s100 = "|*    |\n"
        s001 = "|    *|\n"
        s000 = "|     |\n"
        s101 = "|*   *|\n"
        s111 = "|* * *|\n"
        ladoatual = self.getLado()
        
        if ladoatual == 1:
            s += (s000 + s010 + s000)
        elif ladoatual == 2:
            s += (s100 + s000 + s001)
        elif ladoatual == 3:
            s += (s100 + s010 + s001)
        elif ladoatual == 4:
            s += (s101 + s000 + s101)
        elif ladoatual == 5:
            s += (s101 + s010 + s101)
        elif ladoatual == 6:
            s += (s111 + s000 + s111)
        
        s += "+-----+\n"
        return s
    
# Classe auxiliar que permite operar um conjunto de dados ao mesmo tempo
class RolaDados:
    def __init__ (self, n, seed=0):
        self.dados = []
        if seed != 0:
            rd = random.Random()
            rd.seed(seed)
        for i in range(n):
            if seed == 0:
                d = Dado()
            else:
                d = Dado(6, rd.randint(1,10000))
            self.dados.append(d)
            
    #método para rolar um conjunto de dados
    def rolar(self, quais=None):
        if (quais == None):
            quais = [True] * len(self.dados)
        r = [] # vai armazenar o valor de cada dado apos as rolagens
        for i in range(len(quais)):
            if quais[i] == True:
                self.dados[i].rolar()
            r.append(self.dados[i].atual)
        return r
    
    # método auxiliar para converter uma string em uma lista de bools
    # esse array será utilizado como parametro no método rolar()
    def stringToArray(self, string):
        resultados = [False] * len(self.dados)
        partes = string.split()
        for parte in partes:
            try:
                pos = int(parte) # tenta converter cada pedaço da string
                if 1 <= pos <= len(self.dados):
                    resultados[pos-1] = True
            except ValueError:
                pass
                
        return resultados
            
        
    # representa o conjunto de dados com uma string
    def toString(self):
        s = ""
        for i in range(5):
            base = i * 8
            for d in self.dados:
                p = d.toString()
                s += p[base : base + 7]
                s += "    "
            s += "\n"
        return s