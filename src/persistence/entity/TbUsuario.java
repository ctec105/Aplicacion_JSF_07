package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tb_usuario database table.
 * 
 */
@Entity
@Table(name = "tb_usuario")
public class TbUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_USU")
	private int codUsu;

	@Column(name = "CON_USU")
	private String conUsu;

	@Column(name = "NOM_USU")
	private String nomUsu;

	public TbUsuario() {
	}

	public int getCodUsu() {
		return this.codUsu;
	}

	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}

	public String getConUsu() {
		return this.conUsu;
	}

	public void setConUsu(String conUsu) {
		this.conUsu = conUsu;
	}

	public String getNomUsu() {
		return this.nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

}