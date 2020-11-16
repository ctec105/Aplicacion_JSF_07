package business.service;

import java.util.List;

import persistence.entity.TbEmpleado;

public interface EmpleadoService {
	
	public List<TbEmpleado> listarEmpleados()throws Exception;
	public List<TbEmpleado> buscarEmpleado(String nombre)throws Exception;
	public void registrarEmpleado(TbEmpleado empleado) throws Exception;
	public TbEmpleado obtenerEmpleado(TbEmpleado empleado) throws Exception;
	public void modificarEmpleado(TbEmpleado empleado) throws Exception;
	public void eliminarEmpleado(TbEmpleado empleado) throws Exception;
	
}