import java.math.*;
import java.util.Random;
import java.io.*;


public class Combate{
	private Pokemon player1;
	private Pokemon player2;
	private int indexRival;
	BufferedReader buffer;

	Combate(Pokemon player1, Pokedex pokedexGral){
		buffer = new BufferedReader(new InputStreamReader(System.in));
		this.player1 = player1;
		indexRival = (int)Math.round(Math.random()*10);
		this.player2 = pokedexGral.getPokemon(indexRival);
		System.out.println("Los Pokemones combatientes son : ");
		System.out.println(" __^__                                      __^__");
		System.out.println("( ___ )------------------------------------( ___ )");
		System.out.println(" |   |                                      |   |");
		System.out.println(" |   |         "+player1.getNombre()+" V/S "+player2.getNombre()+"          |   |");
		System.out.println(" |___|                                      |___|");
		System.out.println("(_____)------------------------------------(_____)");


		System.out.println("				╔═════════════════════════╗");
		System.out.println("				║ QUE COMIENZE LA BATALLA ║");
		System.out.println("				╚═════════════════════════╝");
		
		
		
	
		
	}

	//ataque random de maquina
	public void ataqueRandom(Pokemon player2,Pokemon player1){
		int numeroAleatorio = (int) (Math.random()*3+1);
		if (numeroAleatorio==1){
			numeroAleatorio=numeroAleatorio-1;
		}
		if (numeroAleatorio==2){
			numeroAleatorio=numeroAleatorio-1;
		}
		if (numeroAleatorio==3){
			numeroAleatorio=numeroAleatorio-1;
		}
		player1.recibirAtaque(player2.getAtaques()[numeroAleatorio]);
		System.out.println("				╔═════════════════════════╗");
		System.out.println("TURNO DE	-	        ║ "+player2.getNombre()+"                 ║");
		System.out.println("				╚═════════════════════════╝");
		
		System.out.println(player2.getNombre()+" - Ha utilizado: "+player2.getAtaques()[numeroAleatorio].getNombre());
		System.out.println("\n\n********************************************************\n");
		System.out.println(player1.getNombre()+" tu nivel de Puntos de Salud es: "+player1.getPs());
		System.out.println("\n********************************************************\n\n");

		}

	public void ataque(Pokemon player1,Pokemon player2){
		int op;
		try{
			System.out.println("				╔═════════════════════════╗");
			System.out.println("TURNO DE	-	        ║ "+player1.getNombre()+"                 ║");
			System.out.println("				╚═════════════════════════╝");
			System.out.println(player1.getNombre()+", El ataque será: ");
			System.out.println("1.-"+player1.getAtaques()[0].getNombre());
			System.out.println("2.-"+player1.getAtaques()[1].getNombre());
			System.out.println("3.-"+player1.getAtaques()[2].getNombre());
			op = Integer.parseInt(buffer.readLine());
			
			System.out.println(player1.getNombre()+" - Ha utilizado: "+player1.getAtaques()[op-1].getNombre());
			player2.recibirAtaque(player1.getAtaques()[op-1]);
			System.out.println("\n\n********************************************************\n");
			System.out.println(player2.getNombre()+" tu nivel de Puntos de Salud es "+player2.getPs());
			System.out.println("\n********************************************************\n\n");

		}catch(IOException e){
			System.out.println("Error de lectura desde el teclado...");
		}
	}

	public int combatir(){
		int out=0;
		boolean sigue=true;
		while(sigue){
			ataque(player1,player2);
			if(revisarTriunfo(player2)){
				System.out.println("\n\n********************************************************\n\n");
				System.out.println("Felicitaciones...Haz ganado la partida!!");
				System.out.println("\n\n********************************************************\n\n");
				out = indexRival;
				player1.restaurar();
				player2.restaurar();
				break;
			} 
			ataqueRandom(player2,player1);
			if(revisarTriunfo(player1)){
				System.out.println("\n\n********************************************************\n\n");
				System.out.println("Haz perdido la partida!!");
				System.out.println("\n\n********************************************************\n\n");
				out = -1;
				player1.restaurar();
				player2.restaurar();
				break;
			}
		}
		return out;
	}

	public boolean revisarTriunfo(Pokemon player){
		if(player.getPs()<=0) return true;
		else return false;
	}

}