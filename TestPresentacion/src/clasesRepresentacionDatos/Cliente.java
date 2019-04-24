package clasesRepresentacionDatos;

public class Cliente {
	public String nombre;
	public String direccion;
	public String ciudad;
	public String estado;
	public String codigoPostal;
	public String numeroTarjeta;
	public String mesCaducidadTarjeta;
	public String anyoCaducidadTarjeta;
	public String nombreUsuarioTarjeta;
	
	public Cliente(String nombre, String direccion, String ciudad, String estado, String codigoPostal,
			String numeroTarjeta, String mesCaducidadTarjeta, String anyoCaducidadTarjeta,
			String nombreUsuarioTarjeta) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
		this.numeroTarjeta = numeroTarjeta;
		this.mesCaducidadTarjeta = mesCaducidadTarjeta;
		this.anyoCaducidadTarjeta = anyoCaducidadTarjeta;
		this.nombreUsuarioTarjeta = nombreUsuarioTarjeta;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getMesCaducidadTarjeta() {
		return mesCaducidadTarjeta;
	}

	public void setMesCaducidadTarjeta(String mesCaducidadTarjeta) {
		this.mesCaducidadTarjeta = mesCaducidadTarjeta;
	}

	public String getAnyoCaducidadTarjeta() {
		return anyoCaducidadTarjeta;
	}

	public void setAnyoCaducidadTarjeta(String anyoCaducidadTarjeta) {
		this.anyoCaducidadTarjeta = anyoCaducidadTarjeta;
	}

	public String getNombreUsuarioTarjeta() {
		return nombreUsuarioTarjeta;
	}

	public void setNombreUsuarioTarjeta(String nombreUsuarioTarjeta) {
		this.nombreUsuarioTarjeta = nombreUsuarioTarjeta;
	}

	
}
