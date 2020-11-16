package business.delegate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import business.service.CargoService;
import business.service.CargoServiceImpl;
import business.service.EmpleadoService;
import business.service.EmpleadoServiceImpl;
import business.service.LoginService;
import business.service.LoginServiceImpl;

public class ApplicationBusinessDelegate {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Aplicacion_JSF_07");
	
	public LoginService getLoginService(){
		return new LoginServiceImpl(emf);
	}
	
	public EmpleadoService getEmpleadoService(){
		return new EmpleadoServiceImpl(emf);
	}
	
	public CargoService getCargoService(){
		return new CargoServiceImpl(emf);
	}

}