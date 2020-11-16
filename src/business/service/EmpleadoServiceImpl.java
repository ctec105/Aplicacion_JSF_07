package business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

import persistence.entity.TbEmpleado;
import persistence.jpa.TbEmpleadoJPA;

public class EmpleadoServiceImpl implements EmpleadoService {

	static Logger logger = Logger.getLogger(EmpleadoServiceImpl.class.getName());
	
	TbEmpleadoJPA empleadoJPA = new TbEmpleadoJPA();
	private EntityManager em;
	
	public EmpleadoServiceImpl(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	@Override
	public List<TbEmpleado> listarEmpleados() throws Exception {
		List<TbEmpleado> lista = empleadoJPA.listarEmpleados(em);
		return lista;
	}
	
	@Override
	public List<TbEmpleado> buscarEmpleado(String nombre) throws Exception {
		List<TbEmpleado> lista = empleadoJPA.buscarEmpleado(em, nombre);
		return lista;
	}

	@Override
	public void registrarEmpleado(TbEmpleado empleado) throws Exception {
		logger.debug("Registrando un nuevo empleado");
		empleadoJPA.registrarEmpleado(em,empleado);
		mostrar(empleadoJPA.listarEmpleados(em));
	}

	@Override
	public TbEmpleado obtenerEmpleado(TbEmpleado empleado) throws Exception {
		TbEmpleado entidad = empleadoJPA.obtenerEmpleado(em,empleado);
		return entidad;
	}

	@Override
	public void modificarEmpleado(TbEmpleado empleado) throws Exception {
		logger.debug("Actualizamos un empleado");
		empleadoJPA.modificarEmpleado(em,empleado);
		mostrar(empleadoJPA.listarEmpleados(em));
	}

	@Override
	public void eliminarEmpleado(TbEmpleado empleado) throws Exception {
		logger.debug("Eliminamos un empleado");
		empleadoJPA.eliminarEmpleado(em,empleado);
		mostrar(empleadoJPA.listarEmpleados(em));
	}
	
	
	private static void mostrar(List<TbEmpleado> listaEntidad){
		for (int i = 0; i < listaEntidad.size(); i++) {
			TbEmpleado entidad = (TbEmpleado) listaEntidad.get(i);
			logger.info(entidad.toString());
		}
	}
}