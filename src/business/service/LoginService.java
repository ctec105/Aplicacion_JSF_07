package business.service;

import persistence.entity.TbUsuario;

public interface LoginService {

	public boolean validar(TbUsuario usuario)throws Exception;
	
}