public class Ataque{
	private String nombre;
	private int dano;
	private int cura;
	private int bloqueo;

	Ataque(String nombre, int dano,int cura, int bloqueo){
		this.nombre = nombre;
		this.dano = dano;
		this.cura = cura;
		this.bloqueo = bloqueo;
	}

	public int getDano(){
		return this.dano;
	}
	public int getCura(){
		return this.cura;
	}
	public int getBloqueo(){
		return this.bloqueo;
	}
	public String getNombre(){
		return this.nombre;
	}
}