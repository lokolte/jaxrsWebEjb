package JaxrsEjb.jaxrsWebEjb.mybatis.bean;

public class Proveedor {
    private Integer id;

    private String nombre;

    private String email;

    private String phoneNumber;
    
    public Proveedor() {
		this.nombre = "";
		this.phoneNumber = "";
	}
    
    public Proveedor(String nombre, String email, String phoneNumber) {
		this.nombre = nombre;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
    
    public Integer getId() {
        return id;
    }

	public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
