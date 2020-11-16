package persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistence.entity.TbUsuario;

public class TbUsuarioJPA {

	public int validar(EntityManager em, TbUsuario usuario) {
		String query = "select count(u) from TbUsuario u where u.nomUsu=:username and u.conUsu=:password ";
		Query emquery = em.createQuery(query);
		emquery.setParameter("username", usuario.getNomUsu());
		emquery.setParameter("password", usuario.getConUsu());
		Long c = (Long)emquery.getSingleResult();
		return c.intValue();
	}

}
