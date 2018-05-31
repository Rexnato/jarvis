package mx.cam.dev.rexnato;

import java.util.HashMap;

public class CiudadMapa {
	
	private String Ciudad;
	
	private HashMap<String, Integer> conexionesCarretera;
	
	

	public CiudadMapa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CiudadMapa(String ciudad, HashMap<String, Integer> conexionesCarretera) {
		super();
		Ciudad = ciudad;
		this.conexionesCarretera = conexionesCarretera;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public HashMap<String, Integer> getConexionesCarretera() {
		if(this.conexionesCarretera == null){
			conexionesCarretera = new HashMap<>();
		}
		return conexionesCarretera;
	}

	public void setConexionesCarretera(HashMap<String, Integer> conexionesCarretera) {
		this.conexionesCarretera = conexionesCarretera;
	} 
	
	

}
