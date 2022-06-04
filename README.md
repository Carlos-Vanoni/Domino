# Ordenador de Dominós

Repositorio: https://github.com/Carlos-Vanoni/Domino
by: Carlos Vanoni e Eduardo Bernardi

## Aplicação


*A aplicação foi construida para atender um caso da seguinte forma:*

- A Aplicação lê um arquivo desejado, em que irá conter uma ou mais pilhas de `Peças de Dominó`;
- Essa aplicação irá ler cada uma das pilhas e reorganizar as peças para que a `soma` do lado esquerdo de todas as peças seja igual a `soma` do lado direito;
- Por fim, retorna no console o resultado da soma de cada `pilha de dominós` do arquivo;
- Caso a pilha não tiver uma soma igual para os dois lados ele irá `tirar` uma peça para que aconteça essa igualdade;
- A aplicação irá tentar tirar a peça que deixe o resultado da pilha com a maior soma, porém se ele ver que essa procura será muito longa, ele tirar melhor peça que achou no momento;
- A peça retirada será mostrada ao lado da soma da pilha no console de forma que o dominó `X Y`, apareça sempre no formato `X ≤ Y`;
- Caso a aplicação não consiga achar uma soma para os dois lados mesmo tirando uma peça, será demonstrado uma mensagem de que `não foi possivel achar o resultado`.


## Formato do Arquivo

*A aplicação irá ler arquivos com esse seguinte formato:*

[Número de peças que terá na próxima pilha]
[valor esquerdo  peça1] [valor direito  peça1]
[valor esquerdo  peça2] [valor direito  peça2]
[Número de peças que terá na próxima pilha]
[valor esquerdo  peça3] [valor direito  peça3]
[valor esquerdo  peça4] [valor direito  peça4]
[valor esquerdo  peça5] [valor direito  peça5]
0

*Sempre usar `0` na ultima linha para finalizar o arquivo*

Exemplo de dados no arquivo:

2
8 1
9 4
3
6 3
1 2
3 1
0


## Como Executar a Aplicação

- *Instruções:*
    1. Coloque os arquivos com pilhas de dominós no seu diretório `HOME`, exemplo:  `C:\Users\nomeDoMeuUser`;
    2. Com o `java` instalado na máquina abra o diretório da aplicação com uma IDE (preferência por Intellij e Eclipse);
    3. Rode a aplicação;
    4. Irá aparecer no console para você digitar o nome do seu `úsuario` na máquina, para a aplicação poder localizar o diretório dos arquivos;
    5. Irá pedir também para passar o `nome do arquivo` (Caso o arquivo tiver uma extensão como '.txt', não esqueça de passar ele junto ao nome);
    6. Após isso a aplicação irá rodar;
    7. Aperte qualquer tecla caso queira ler outro arquivo, senão aperte `0` que a aplicação encerrará;
    

