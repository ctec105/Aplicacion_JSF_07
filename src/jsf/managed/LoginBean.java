package jsf.managed;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import persistence.entity.TbUsuario;
import business.delegate.ApplicationBusinessDelegate;
import business.service.LoginService;

@ManagedBean(name="login")
@SessionScoped
public class LoginBean {
	
	// Business Layer
	public static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	public static LoginService loginService;
	
	private TbUsuario usuario = new TbUsuario();
	
	public TbUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(TbUsuario usuario) {
		this.usuario = usuario;
	}

	public String validar() throws Exception{
		loginService = abd.getLoginService();
		if (loginService.validar(usuario)){
			return "paginas/principal";
		}else{
			ResourceBundle resourceBundle = ResourceBundle.getBundle("recursos.textos", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			FacesMessage facesMessage = new FacesMessage(resourceBundle.getString("error_login_ok"));
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return "inicio";
		}
	}
	
}