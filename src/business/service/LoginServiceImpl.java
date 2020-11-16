package business.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import persistence.entity.TbUsuario;
import persistence.jpa.TbUsuarioJPA;

public class LoginServiceImpl implements LoginService {

	TbUsuarioJPA usuarioJPA = new TbUsuarioJPA();
	private EntityManager em;

	public LoginServiceImpl(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	@Override
	public boolean validar(TbUsuario usuario) throws Exception {
		int resultado = usuarioJPA.validar(em,usuario);
		if (resultado == 0){
			return false;
		}else{
			return true;
		}
		
	}

}