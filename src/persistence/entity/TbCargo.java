package persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the tb_cargo database table.
 * 
 */
@Entity
@Table(name = "tb_cargo")
public class TbCargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_CAR")
	private int codCar;

	@Column(name = "DES_CAR")
	private String desCar;

	// bi-directional many-to-one association to TbEmpleado
	@OneToMany(mappedBy = "tbCargo")
	private Set<TbEmpleado> tbEmpleados;

	public TbCargo() {
	}

	public int getCodCar() {
		return this.codCar;
	}

	public void setCodCar(int codCar) {
		this.codCar = codCar;
	}

	public String getDesCar() {
		return this.desCar;
	}

	public void setDesCar(String desCar) {
		this.desCar = desCar;
	}

	public Set<TbEmpleado> getTbEmpleados() {
		return this.tbEmpleados;
	}

	public void setTbEmpleados(Set<TbEmpleado> tbEmpleados) {
		this.tbEmpleados = tbEmpleados;
	}

}