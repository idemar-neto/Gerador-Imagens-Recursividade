//Idemar Burssed dos Santos Neto - 11857282

// Classe na qual foram implementadas as novas funcionalidades de desenho

public class ImageGenerator extends Image {

	public ImageGenerator(int w, int h, int r, int g, int b){

		super(w, h, r, g, b);
	}

	public ImageGenerator(int w, int h){

		super(w, h);
	}

	public static void kochCurve(double x1, double y1, double x2, double y2, double l, Image img){
		
		double xv = x2-x1; //delta x dos pontos passados como parametro
		double yv = y2-y1; //delta y dos pontos passados como parametro

		double c = Math.sqrt((xv*xv)+(yv*yv)); //a distancia real dos pontos definida pela equção delta_x ao quadrado + delta_y ao quadrado

		if(c < l){ // condicional que define quando se deve traçar as linhas pela distância dos pontos ser menor que o limiar
			//Math.round(x1);
			int x1a = (int) Math.round(x1); // arredondamento dos numeros calculados para virarem int e e podeem traçar a linha
			//Math.round(x2);
			int x2a = (int) Math.round(x2);
			//Math.round(y1);
			int y1a = (int) Math.round(y1);
			//Math.round(y2);
			int y2a = (int) Math.round(y2);

			img.drawLine(x1a, y1a, x2a, y2a); // traçando as linhas com os pontos que definem a curva de koch
		}else{

			//calcuo dos pontos da curva de koch
			double xa = xv/3 + x1; // um terço da distancia de x passada como parâmetro
			double xc = 2*xv/3 +x1; // dois terços da distancia de x passada como parâmetro
			double xm = (xv/2) + x1; // metade da distancia de x passada como parâmetro, para o calculo do ponto B
			double xu = yv * Math.sqrt(3)/6; // auxiliar do x da altura, com o calculo perpendicular a suposta linha que seria traçada
			double xb = xm + xu; // x da altura definido pelas outras duas variáveis

			double ya = yv/3 + y1; // um terço da distancia de y passada como parâmetro
			double yc = 2*yv/3 + y1;  // dois terços da distancia de y passada como parâmetro
			double ym = yv/2 + y1; // metade da distancia de y passada como parâmetro, para o calculo do ponto B
			double yu = -xv * Math.sqrt(3)/6; // auxiliar do y da altura, com o calculo perpendicular a suposta linha que seria traçada
			double yb = ym + yu; // y da altura definido pelas outras duas variáveis

			//chamadas recursivas para serem feitos mais calculos da crva se necessário
			kochCurve(x1, y1, xa, ya, l, img);

			kochCurve(xa, ya, xb, yb, l, img);

			kochCurve(xb, yb, xc, yc, l, img);

			kochCurve(xc, yc, x2, y2, l, img);

		}
	}

	public static void regionFill(int x, int y, int org, Image img, int w, int h){

		int meio = img.getPixel(x,y); //pega a cor do pixel de refencia, para ter o parâmetro do que deve ser pintado 

		if(meio == org){ //caso a cor do pixel seja igual a do pixel original entra no condicional

		img.setPixel(x,y); //pinta o pixel que já foi verificado 

		//faz chamadas para os pixels da esquerda, da direita, de cima e de baixo
		if(x > 0) regionFill(x-1, y, org, img, w, h);
		if(x < w-1) regionFill(x+1, y, org, img, w, h);
		if(y > 0) regionFill(x, y-1, org, img, w, h);
		if(y < h-1) regionFill(x, y+1, org, img, w, h);
		}
	}
}
