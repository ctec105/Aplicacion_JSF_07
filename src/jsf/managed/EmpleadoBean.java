package jsf.managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import persistence.entity.TbCargo;
import persistence.entity.TbEmpleado;

import business.delegate.ApplicationBusinessDelegate;
import business.service.CargoService;
import business.service.EmpleadoService;

@ManagedBean(name="empleado")
@SessionScoped
public class EmpleadoBean {
	
	// Business Layer
	public static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	public static EmpleadoService empleadoService;
	public static CargoService cargoService;
	
	public List<TbEmpleado>empleadoList;
	public List<TbCargo> cargoList;
	
	public TbEmpleado empleado = new TbEmpleado();
	public TbCargo cargo = new TbCargo();
	public String nombre;
	

	public List<TbEmpleado> getEmpleadoList() {
		return empleadoList;
	}
	public void setEmpleadoList(List<TbEmpleado> empleadoList) {
		this.empleadoList = empleadoList;
	}
	public List<TbCargo> getCargoList() {
		return cargoList;
	}
	public void setCargoList(List<TbCargo> cargoList) {
		this.cargoList = cargoList;
	}
	
	public TbEmpleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(TbEmpleado empleado) {
		this.empleado = empleado;
	}
	public TbCargo getCargo() {
		return cargo;
	}
	public void setCargo(TbCargo cargo) {
		this.cargo = cargo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String listarEmpleados() throws Exception{
		System.out.println("Estoy en el método listarEmpleados() - INI");
		empleadoService = abd.getEmpleadoService();
		empleadoList = empleadoService.listarEmpleados();
		System.out.println("Estoy en el método listarEmpleados() - FIN");
		return "empleadoListado";
	}
	
	public String buscarEmpleado() throws Exception{
		System.out.println("Estoy en el método buscarEmpleado() - INI");
		empleadoService = abd.getEmpleadoService();
		empleadoList = empleadoService.buscarEmpleado(nombre);
		System.out.println("Estoy en el método buscarEmpleado() - FIN");
		return "empleadoListado";
	}
	
	public String inicializar() throws Exception{
		System.out.println("Estoy en el método inicializar() - INI");
    	String codigo=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo");

//    	HttpServletRequest mirequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//    	String codigo2=(String) mirequest.getParameter("codigo") ;
    	
//    	FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().put("cargarrequest", "Pronado");
//    	mirequest.setAttribute("mi_clave_de_request", "cargar atributo");
    	

    	
    	
    	if(codigo!=null && codigo.length()>0){
    		empleadoService = abd.getEmpleadoService();
    		empleado.setCodEmp(Integer.parseInt(codigo));
    		empleado=empleadoService.obtenerEmpleado(empleado);
    	}else{
    		empleado=new TbEmpleado();
    	}
    	System.out.println("Estoy en el método inicializar() - FIN");
		return "empleadoEdicion";
	}

	public String insertarOActualizar()throws Exception{
		System.out.println("Estoy dentro del método insertarOActualizar() - INI");
		empleadoService = abd.getEmpleadoService();
		if (empleado!=null){
			empleadoService.modificarEmpleado(empleado);
		}else{
			empleadoService.registrarEmpleado(empleado);
		}
		System.out.println("Estoy dentro del método insertarOActualizar() - FIN");
		return listarEmpleados();
	}
	
	public String eliminarEmpleado() throws Exception{
		System.out.println("Estoy dentro del método eliminarEmpleado() - INI");
		String codigo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo");
		empleadoService = abd.getEmpleadoService();
		empleado.setCodEmp(Integer.parseInt(codigo));
		empleadoService.eliminarEmpleado(empleado);
		System.out.println("Estoy dentro del método eliminarEmpleado() - FIN");
		return listarEmpleados();
	}

	public String verDetalle()throws Exception{
		System.out.println("Estoy dentro del método verDetalle() - INI");
		String codigo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo");
		empleadoService = abd.getEmpleadoService();
		empleado.setCodEmp(Integer.parseInt(codigo));
		empleado = empleadoService.obtenerEmpleado(empleado);
		System.out.println("Estoy dentro del método verDetalle() - FIN");
		return "empleadoDetalle";
	}
	
}