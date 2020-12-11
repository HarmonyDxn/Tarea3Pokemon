import java.io.*;
import java.util.Random;

public class Partida{
	private BufferedReader buffer;
	private Personaje jugador;
	private Combate [] combates;
	private int combateActual;
	private Pokedex pokedexGral;
	private Random rng = new Random();
	private mapa map= new mapa();
	private Mcombate mcomb= new Mcombate();


	Partida(Pokedex pokedexGral){
		buffer = new BufferedReader(new InputStreamReader(System.in));
		combates = new Combate[SetupPokemon.cantidadCombates];
		combateActual = 0;
		this.pokedexGral = pokedexGral;
		crearUsuario(pokedexGral);
		menu();
	}

	private void crearUsuario(Pokedex pokedexGral){
		String nombre;
		String usuario;
		try{
			System.out.println("\n\n********************************************************\n");
			System.out.println("    POKEMON FUNDAMENTOS DE LENGUAJES DE PROGRAMACIÓN");
			System.out.println("\n********************************************************\n\n");
			System.out.println("            Ingrese su nombre: \n            ");
			nombre = buffer.readLine();
			System.out.println("            Ingrese un nombre de usuario: \n            ");
			usuario = buffer.readLine();

			this.jugador = new Personaje(1,nombre,usuario,pokedexGral);	
		}catch(IOException e){
			System.out.println("Error de lectura desde el teclado...");
		}
	}
	public void menu(){
		int op=0;
		System.out.println("\n\n********************************************************\n\n");
		System.out.println("Comienza el juego...");
		System.out.println("\n\n********************************************************\n\n");
		try{
			do{
			
			System.out.println("\n\n********************************************************\n\n");
			System.out.println("Selecciona la acción que quieres realizar: ");
			System.out.println("1.- Combate. ");
			System.out.println("2.- Ver Pokedex. ");
			System.out.println("3.- Viajar a una ciudad. ");
			System.out.println("4.- Terminar Juego. ");

			op = Integer.parseInt(buffer.readLine());
			System.out.println("\n\n********************************************************\n\n");
			switch(op){
				case 1: System.out.println("\n\n********************************************************\n\n");
						crearCombate();
						System.out.println("\n\n********************************************************\n\n");
						break;
				case 2: System.out.println("\n\n********************************************************\n\n");
						mostrarPokedex();
						buffer.readLine();
						System.out.println("\n\n********************************************************\n\n");
						break;
				case 3:	System.out.println("\n********************************************************\n");
						System.out.println("Has ocupado FLY y tu pokemon se enloqueze y te lleva a:  "+mapaRandom());
						System.out.println("\n********************************************************\n");
						break;
				case 4: System.out.println("\n\n********************************************************\n\n");
						System.out.println("El juego ha terminado,  gracias por jugar PokemonFLP!!!");
						System.out.println("\n\n********************************************************\n\n\n\n\n\n\n\n\n\n");
						break;
			}

			}while(op!=4);
			

		}catch(IOException e){
			System.out.println("Error de lectura desde el teclado...");
		}

	}
	public void crearCombate(){
		int n=SetupPokemon.cantidadPokemones;
		Pokemon aux;
		System.out.println("\n\n********************************************************\n\n");
		System.out.println("mientras caminabas por "+mCombatRandom()+" aparecio un pokemon, preparese para la pelea");
		System.out.println("Pokedex Personal");
		System.out.println("======= ========\n");
		for(int i=0;i<n;i++){
			aux = jugador.getPokedex().getPokemon(i);
			if(aux.getCapturado())
				System.out.println((i+1)+".- "+aux.getNombre());
		}
		
		int op=-1;
		boolean flag=false;
		do{
			if(flag) System.out.println("Ingrese una opción válida...");
			System.out.println("Elije tu pokemon para la batalla....");
			try{
				op = Integer.parseInt(buffer.readLine());
				flag=true;
			}catch(IOException e){
				System.out.println("Error de lectura desde el teclado...");
			}
		}while((op<0)||(op>n));
		System.out.println("\n\n********************************************************\n\n");
		System.out.println("Su pokemon para el combate es "+ jugador.getPokedex().getPokemon(op-1).getNombre());
		System.out.println("\n\n********************************************************\n\n");
		combates[combateActual] = new Combate(jugador.getPokedex().getPokemon(op-1), pokedexGral);
		int rival = combates[combateActual].combatir();
		if (rival > -1){
			jugador.getPokedex().capturarPokemon(rival);
			System.out.println("Haz capturado un nuevo pokemon!!!");
		}
		if (rival >-1){
			jugador.getPokedex().getPokemon(op-1).subeExperiencia();
			System.out.println(jugador.getPokedex().getPokemon(op-1).getNombre()+" Aumenta 1 punto de experciencia ");
			jugador.getPokedex().getPokemon(op-1).subeNivel();
		}
		combateActual+=1;
	}

	public void mostrarPokedex(){
		this.jugador.listarPokedexPersonal();
	}
	
	public String mapaRandom(){
		String texto;

		texto=(this.map.getCiudad(this.rng.nextInt(10)));
		return texto;
	}

	public String mCombatRandom(){
		String scroll;
		
		scroll=(this.mcomb.getMapaDuelo(this.rng.nextInt(4)));
		return scroll;
	}
}