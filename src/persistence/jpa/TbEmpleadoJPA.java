package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistence.entity.TbEmpleado;

public class TbEmpleadoJPA {
	
	public List<TbEmpleado> listarEmpleados(EntityManager em) {
		String query = "select e from TbEmpleado e order by e.codEmp";
		Query emquery = em.createQuery(query);
		List<TbEmpleado> lista = emquery.getResultList();
		return lista;
	}
	
	public List<TbEmpleado> buscarEmpleado(EntityManager em, String nombre) {
		String query = "select e from TbEmpleado e where e.nomEmp like ?1 order by e.codEmp";
		Query emquery = em.createQuery(query);
		emquery.setParameter(1, "%" + nombre + "%");
		List<TbEmpleado> lista = emquery.getResultList();
		return lista;
	}

	public void registrarEmpleado(EntityManager em, TbEmpleado empleado) {
		em.getTransaction().begin();
		em.persist(empleado);
		em.flush();
		em.getTransaction().commit();
	}

	public TbEmpleado obtenerEmpleado(EntityManager em, TbEmpleado empleado) {
		TbEmpleado entidad = (TbEmpleado)em.find(TbEmpleado.class, empleado.getCodEmp());
		em.detach(entidad);
		return entidad;
	}

	public void modificarEmpleado(EntityManager em, TbEmpleado empleado) {
		em.getTransaction().begin();
		em.merge(empleado);
		em.flush();
		em.getTransaction().commit();
	}

	public void eliminarEmpleado(EntityManager em, TbEmpleado empleado) {
		em.getTransaction().begin();
		TbEmpleado entidad = (TbEmpleado)em.find(TbEmpleado.class, empleado.getCodEmp());
		em.remove(entidad);
		em.flush();
		em.getTransaction().commit();
	}

}