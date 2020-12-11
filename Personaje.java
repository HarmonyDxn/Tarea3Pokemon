import java.io.*;

public class Personaje{
	private int id;
	private String nombre;
	private String usuario;
	private Pokedex pokedexPersonal;

	Personaje(int id, String nombre, String usuario, Pokedex pokedexGral){
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.pokedexPersonal = new Pokedex();
		escogerPokemon(pokedexGral);
	}

	private void escogerPokemon(Pokedex pokedexGral){
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\n\n********************************************************\n\n");
		System.out.println("Elije tu pokemon inicial....");
		System.out.println("\n\n********************************************************\n\n");
		int n=SetupPokemon.cantidadPokemones;
		
		for(int i=0;i<n;i++)
			System.out.println((i+1)+".- "+pokedexGral.getPokemon(i).getNombre());
		
		int op=-1;
		boolean flag=false;
		do{
			if(flag) System.out.println("Ingrese una opción válida...");
			System.out.println("Elije tu pokemon inicial....");
			try{
				op = Integer.parseInt(buffer.readLine());
				flag=true;
			}catch(IOException e){
				System.out.println("Error de lectura desde el teclado...");
			}
		}while((op<0)||(op>n));
		pokedexPersonal.capturarPokemon(op-1);
		System.out.println("\n\n********************************************************\n\n");
		System.out.println("Su pokemon inicial es "+ pokedexPersonal.getPokemon(op-1).getNombre()+", felicitaciones!!!");
		System.out.println("\n\n********************************************************\n\n");
	}
	public void listarPokedexPersonal(){
		this.pokedexPersonal.listarPokedex();
	}
	public Pokedex getPokedex(){
		return pokedexPersonal;
	}
}