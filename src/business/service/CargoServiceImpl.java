package business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import persistence.entity.TbCargo;
import persistence.jpa.TbCargoJPA;

public class CargoServiceImpl implements CargoService {

	TbCargoJPA cargo = new TbCargoJPA();
	private EntityManager em;
	
	public CargoServiceImpl(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	@Override
	public List<TbCargo> listarCargos() throws Exception {
		List<TbCargo> lista = cargo.listarCargos(em);
		return lista;
	}

}
