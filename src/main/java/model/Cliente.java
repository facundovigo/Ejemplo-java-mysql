package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Cli_Id;
	@Column
	private String Cli_RazonSocial;


	public Long getId() {
		return Cli_Id;
	}
	public void setId(Long id) {
		this.Cli_Id = id;
	}
	public String getNombre() {
		return Cli_RazonSocial;
	}
	public void setNombre(String nombre) {
		this.Cli_RazonSocial = nombre;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + Cli_Id + ", nombre=" + Cli_RazonSocial + "]";
	}
}
