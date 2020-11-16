package persistence.entity.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.apache.log4j.Logger;

import persistence.entity.TbEmpleado;

public class TbEmpleadoListener {

	static  Logger logger = Logger.getLogger(TbEmpleado.class.getName());

	@PrePersist
	public void listener_before_insert(TbEmpleado empleado){
		logger.debug("@PrePersist: "+empleado.toString());
	}
	
	@PreUpdate
	public void listener_before_update(TbEmpleado empleado){
		logger.debug("@PreUpdate: "+empleado.toString());
	}
	
	@PreRemove
	public void listener_before_delete(TbEmpleado empleado){
		logger.debug("@PreRemove: "+empleado.toString());
	}
	
	@PostLoad
	public void listener_after_query(TbEmpleado empleado){
		logger.debug("@PostLoad: "+empleado.toString());
	}
	
	@PostPersist
	public void listener_after_insert(TbEmpleado empleado){
		logger.debug("@PostPersist: "+empleado.toString());
	}
	
	@PostUpdate
	public void listener_after_update(TbEmpleado empleado){
		logger.debug("@PostUpdate: "+empleado.toString());
	}
	
	@PostRemove
	public void listener_after_delete(TbEmpleado empleado){
		logger.debug("@PostRemove: "+empleado.toString());
	}
	
}