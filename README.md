### Recursividade aplicada à computação gráfica



Esse programa tem a funcionalidade de criar uma imagem a partir de instruções dadas por um arquivo “.txt”. As instruções são dadas pelas funções:


+ DRAW_LINE: desenha uma linha a partir de 2 pontos cartesianos.

+ SET_PIXEL: função que seleciona um pixel a ser colorido.

+ SET_COLOR: aplica uma cor partir do RGB (R de red, G de green, B de blue: vermelho, verde e azul em inglês respectivamente).

+ KOCH_CURVE: aplica a curva de Koch para uma linha passada como parâmetro.

+ REGION_FILL: colore uma região a partir das coordenadas de um ponto passado como parâmetro.

*OBS:* o plano cartesiano da imagem tem seu x iniciado no 0 e crecente para direita até LARGURA-1 e o y inicial no 0 e crescente para baixo até ALTURA-1.



A execução desse programa é dada pelos comandos:

```javac Main.java                         					(Para a complilar)```

```java Main [Nome do Arquivo].txt [Nome da imagem].png     (Para executar)```

OBS: vale ressaltar que por ser um programa que utiliza recursividade,há a possibilidade de _StackOverflow_, para contornar pode-se executar a seguinte linha:

```java -Xss(Valor da Memória em megas)M Main (Nome do Arquivo).txt (nome da imagem).png```



O arquivo “.txt” deve ser formatado de modo a especificar as dimensões da imagem e a cor inicial do fundo em RGB, seguido pelas próximas linhas onde se especifica a função passada por seus parâmetros. Por exemplo:

```1280 720 0 0 0 (Neste caso criará uma imagem 1280x720 pixels com o fundo preto)```



As funções passadas devem conter seus respectivos parâmetros:

+ DRAW_LINE recebe 4 inteiros como parâmetros para criar a linha, sendo eles um x e um y de um ponto inicial e outro x e um y ponto final.

+ SET_PIXEL recebe 2 inteiros como parâmetro sendo eles um x e um y, referentes ao plano cartesiano da imagem.

+ SET_COLOR recebe 3 inteiros como parâmetro referente a RGB com valor máximo de 255 (acima disso é considerado 255).

+ KOCH_CURVE recebe 5 inteiros como parâmetro sendo eles um (x,y) inicial e (x,y) final e ainda um limiar que define a distancia minima que as linhas formadas pela curva terão.

+ REGION_FILL recebe 2 paramentros sendo esse referentes ao ponto de partida para colorir de um x e um y de um ponto no plano cartesiano da imagem.


Sendo assim, as funcionalidade devem ter essa formatação no arquivo ".txt" para serem execultadas corretamente:

```
LARGURA ALTURA FUNDO_R FUNDO_G FUNDO_B

DRAW_LINE x_PONTO_INICAL y_PONTO_INICAL x_PONTO_FINAL y_PONTO_FINAL

SET_PIXEL x y

SET_COLOR R G B

KOCH_CURVE x_PONTO_INICAL y_PONTO_INICAL x_PONTO_FINAL y_PONTO_FINAL LIMIAR

REGION_FILL x_PIXEL_PREENHIMENTO y_PIXEL_PREENHIMENTO
```

(veja o arquivo exemplo.txt e exemplo.png, caso haja ainda haja dúvidas sobre a formatação)