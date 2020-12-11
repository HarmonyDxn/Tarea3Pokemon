public class Pokemon{
	private int id;
	private String nombre;
	private int nivel;
	private int experiencia;
	private boolean capturado;
	private boolean visto;
	private final int ps_max;
	private int ps;
	private int ataque;
	private Ataque [] ataques = new Ataque[SetupPokemon.cantidadAtaques];

	Pokemon(int id, String nombre, int nivel, int experiencia, String [] listaAtaques){
		int valor=6;
		this.id = id;
		this.nombre = nombre;
		this.nivel = nivel;
		this.experiencia = experiencia;
		this.ps_max = SetupPokemon.ps_max;
		this.ps = this.ps_max;
		this.ataque = SetupPokemon.ataque;
		this.capturado = false;
		this.visto = false;
		for(int i=0;i<SetupPokemon.cantidadAtaques;i++){
			this.ataques[i] = new Ataque(listaAtaques[i],i+1,valor-(i+1),valor/2-i);
		}
	}
	public void setCapturado(){
		this.capturado = true;
	}
	public void setVisto(){
		this.visto = true;
	}
	public String getNombre(){
		return this.nombre;
	}
	public int getNivel(){
		return this.nivel;
	}
	//metodo sube de nivel
	public void subeNivel(){
		if (this.experiencia>=3){
			this.nivel = this.nivel+1;
			System.out.println("				╔═════════════════════════╗");
			System.out.println("				║ Ha Subido De Nivel!!    ║");
			System.out.println("				╚═════════════════════════╝");
			this.experiencia = 0;
		}
	}
	public int getExperiencia(){
		return this.experiencia;
	}
	public void subeExperiencia(){
		this.experiencia = this.experiencia+1;
	}
	public boolean getCapturado(){
		return this.capturado;
	}
	public int getId(){
		return this.id;
	}
	public void recibirAtaque(Ataque ataque){
		this.ps -= ataque.getDano();
	}
	public Ataque [] getAtaques(){
		return ataques;
	}
	public int getPs(){
		return ps;
	}
	public void restaurar(){
		this.ps = this.ps_max;
	}
}