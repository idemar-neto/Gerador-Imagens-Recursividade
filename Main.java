//Idemar Burssed dos Santos Neto - 11857282

import java.util.*;
import java.io.*;

// Esqueleto do programa principal

public class Main {

	public static void generateImage(String inputFileName, String outputFileName) throws IOException {

		Scanner scanner = new Scanner(new File(inputFileName));

		ImageEx image = new ImageEx(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

		while(scanner.hasNext()){

			String command = scanner.next();

			if(command.equals("SET_COLOR")){

				image.setColor(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			}

			if(command.equals("SET_PIXEL")){

				image.setPixel(scanner.nextInt(), scanner.nextInt());
			}

			if(command.equals("DRAW_LINE")){

				image.drawLine(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			}

			if(command.equals("KOCH_CURVE")){//comando para a execuçao da curva de koch 

				image.kochCurve(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), image); //aceita o x1,y1,x2,y2, limiar e a imagem como parametros
			}

			if(command.equals("REGION_FILL")){
				
				int w = image.getWidth();//variável definida pela largura da imagem
				int h = image.getHeight(); //variável definida pela altura da imagem
				int x = scanner.nextInt(); //x do pixel a ser iniciado o preenchimento
				int y = scanner.nextInt(); //y do pixel a ser iniciado o preenchimento
				int org = image.getPixel(x,y); //a cor original do pixel a ser iniciado o preenchimento
				
				image.regionFill(x, y, org, image, w, h);//chamada da função com as variáveis acima
			}

		}

		image.save(outputFileName);
	}

	public static void main(String [] args){


		if(args.length != 2){
	
			System.out.println("Uso: java " + Main.class.getName() + " entrada.txt saida.png");
			System.exit(1);
		}

		try{
			generateImage(args[0], args[1]);
		}
		catch(IOException e){
			
			System.out.println("Problem generating image... :(");
			e.printStackTrace();
		}
	}
}
