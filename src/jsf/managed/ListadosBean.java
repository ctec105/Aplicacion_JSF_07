package jsf.managed;

import java.util.*;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import business.delegate.ApplicationBusinessDelegate;
import business.service.CargoService;

import persistence.entity.TbCargo;

@ManagedBean(name="listados", eager=true)
@ApplicationScoped
public class ListadosBean {
	
	// Business Layer
    private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static CargoService carService=abd.getCargoService();

	private List<SelectItem> cargos;
	
	public List<SelectItem> getCargos() {
		return cargos;
	}
	public void setCargos(List<SelectItem> cargos) {
		this.cargos = cargos;
	}
	
	public ListadosBean(){ 
		System.out.println("Estoy dentro del método ListadosBean() - INI");
		cargos=new ArrayList<SelectItem>();
		try{
			Iterator<TbCargo> iterator=  carService.listarCargos().iterator();
			while(iterator.hasNext()){
				TbCargo cargo=iterator.next();
				cargos.add(new SelectItem(cargo.getCodCar(), cargo.getDesCar()));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Estoy dentro del método ListadosBean() - FIN");
	}
	
}