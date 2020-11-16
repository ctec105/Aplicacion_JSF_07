package jsf.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.Logger;

public class JSFListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(JSFListener.class.getName());

	@Override
	public void beforePhase(PhaseEvent arg0) {
		logger.info("Antes de fase: " + arg0.getPhaseId());

	}

	@Override
	public void afterPhase(PhaseEvent arg0) {

		logger.info("Despues de fase: " + arg0.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}