package jsf.managed;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="idioma")
@SessionScoped
public class LocaleBean {

	private Locale locale=FacesContext.getCurrentInstance().getViewRoot().getLocale();
	private String idioma;

	public Locale getLocale() {
		return locale;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		locale=new Locale(idioma);
		this.idioma=idioma;
		
	}
			
}