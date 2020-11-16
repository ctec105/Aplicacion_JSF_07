package persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistence.entity.TbCargo;

public class TbCargoJPA {

	public List<TbCargo> listarCargos(EntityManager em) {
		String query = "select c from TbCargo c order by c.codCar";
		Query emquery = em.createQuery(query);
		List<TbCargo> lista = emquery.getResultList();
		return lista;
	}

}