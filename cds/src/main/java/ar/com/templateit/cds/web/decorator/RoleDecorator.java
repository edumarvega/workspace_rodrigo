package ar.com.templateit.cds.web.decorator;

import java.util.ArrayList;
import java.util.List;

import org.displaytag.decorator.TableDecorator;

import ar.com.templateit.cds.web.entity.Usuario;
import ar.com.templateit.cds.web.entity.UsuarioRole;

public class RoleDecorator extends TableDecorator{
	
	 public String getRole(){
		 Usuario usuario = (Usuario)getCurrentRowObject();
		 List<UsuarioRole> listaTmp = new ArrayList<UsuarioRole>(usuario.getUsuarioRole());
		 String role = listaTmp.get(0).getRole();
		 
		 return role;
	}

}
