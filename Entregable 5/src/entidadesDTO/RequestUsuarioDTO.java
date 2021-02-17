package entidadesDTO;

import ttps.spring.model.Usuario;

public class RequestUsuarioDTO  extends Usuario{
    private String tipoUsuario;
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
    

    
}
