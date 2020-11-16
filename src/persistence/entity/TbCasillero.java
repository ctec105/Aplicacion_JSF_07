package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the tb_casillero database table.
 * 
 */
@Entity
@Table(name = "tb_casillero")
public class TbCasillero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_CAS")
	private int codCas;

	@Column(name = "DES_CAS")
	private String desCas;

	@Column(name = "EST_CAS")
	private String estCas;

	// bi-directional many-to-one association to TbEmpleado
	@OneToMany(mappedBy = "tbCasillero")
	private Set<TbEmpleado> tbEmpleados;

	public TbCasillero() {
	}

	public int getCodCas() {
		return this.codCas;
	}

	public void setCodCas(int codCas) {
		this.codCas = codCas;
	}

	public String getDesCas() {
		return this.desCas;
	}

	public void setDesCas(String desCas) {
		this.desCas = desCas;
	}

	public String getEstCas() {
		return this.estCas;
	}

	public void setEstCas(String estCas) {
		this.estCas = estCas;
	}

	public Set<TbEmpleado> getTbEmpleados() {
		return this.tbEmpleados;
	}

	public void setTbEmpleados(Set<TbEmpleado> tbEmpleados) {
		this.tbEmpleados = tbEmpleados;
	}

}