package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_secuencia database table.
 * 
 */
@Entity
@Table(name="tb_secuencia")
public class TbSecuencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String descripcion;

	private int valor;

    public TbSecuencia() {
    }

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}