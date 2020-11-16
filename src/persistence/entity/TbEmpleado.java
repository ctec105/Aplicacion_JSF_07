package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

import persistence.entity.listener.TbEmpleadoListener;

import java.util.Date;

/**
 * The persistent class for the tb_empleado database table.
 * 
 */
// Es para mandar las anotaciones del previa a una clase listener
@EntityListeners(TbEmpleadoListener.class)
@Entity
@Table(name = "tb_empleado")
public class TbEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_EMP")
	private Integer codEmp;

	@Column(name = "APE_EMP")
	private String apeEmp;

	@Column(name = "ARE_EMP")
	private String areEmp;

	@Column(name = "EDA_EMP")
	private int edaEmp;

	@Temporal(TemporalType.DATE)
	@Column(name = "FEC_ING_EMP")
	private Date fecIngEmp;

	@Column(name = "NOM_EMP")
	private String nomEmp;

	// bi-directional many-to-one association to TbCasillero
	@ManyToOne
	@JoinColumn(name = "COD_CAS")
	private TbCasillero tbCasillero;

	// bi-directional many-to-one association to TbCargo
	@ManyToOne
	@JoinColumn(name = "COD_CAR")
	private TbCargo tbCargo;

	public TbEmpleado() {
		tbCargo = new TbCargo();
		tbCasillero = new TbCasillero();
	}

	public Integer getCodEmp() {
		return this.codEmp;
	}

	public void setCodEmp(Integer codEmp) {
		this.codEmp = codEmp;
	}

	public String getApeEmp() {
		return this.apeEmp;
	}

	public void setApeEmp(String apeEmp) {
		this.apeEmp = apeEmp;
	}

	public String getAreEmp() {
		return this.areEmp;
	}

	public void setAreEmp(String areEmp) {
		this.areEmp = areEmp;
	}

	public int getEdaEmp() {
		return this.edaEmp;
	}

	public void setEdaEmp(int edaEmp) {
		this.edaEmp = edaEmp;
	}

	public Date getFecIngEmp() {
		return this.fecIngEmp;
	}

	public void setFecIngEmp(Date fecIngEmp) {
		this.fecIngEmp = fecIngEmp;
	}

	public String getNomEmp() {
		return this.nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public TbCasillero getTbCasillero() {
		return this.tbCasillero;
	}

	public void setTbCasillero(TbCasillero tbCasillero) {
		this.tbCasillero = tbCasillero;
	}

	public TbCargo getTbCargo() {
		return this.tbCargo;
	}

	public void setTbCargo(TbCargo tbCargo) {
		this.tbCargo = tbCargo;
	}

	@Transient
	private String nombreCompleto;

	public String getNombreCompleto() {
		nombreCompleto = getNomEmp().concat(" ").concat(getApeEmp());
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	// Sobreescribir el método toString para realizar pruebas unitarias
	@Override
	public String toString() {
		return "Empleado [id=" + codEmp + ", apellido=" + apeEmp + ", nombre="
				+ nomEmp + ", edad=" + edaEmp + ", area=" + areEmp
				+ ", Fecha de ingreso=" + fecIngEmp + ", Cargo="
				+ tbCargo.getDesCar() + ", casillero="
				+ tbCasillero.getDesCas() + ", nombreCompleto="
				+ getNombreCompleto() + "]";
	}
}