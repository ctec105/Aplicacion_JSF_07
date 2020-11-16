package business.service;

import java.util.List;

import persistence.entity.TbCargo;

public interface CargoService {
	
	public List<TbCargo> listarCargos()throws Exception;

}