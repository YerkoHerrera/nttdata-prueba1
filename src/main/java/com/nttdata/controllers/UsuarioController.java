package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired //Inyección de dependencia entre services y luego repositories
	UsuarioService usuarioService;

	//desplegar inicialmente el jsp
	@RequestMapping("")
	public String usuario(@ModelAttribute("usuario") Usuario usuario,
			Model model) {
		//model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		model.addAttribute("error", "si");
		model.addAttribute("mensaje", "Error en el nombre");
		return "usuario.jsp";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarUsuario(@RequestParam("id") Long id) {
		
		Usuario usuario = usuarioService.buscarUsuario(id);
		if(usuario != null) {
			usuarioService.eliminarUsuarioObjeto(usuario);
			
		}
		return "Usuario Eliminado";
	}
	
	@RequestMapping("/editar")
	public String editarUsuario(@PathVariable("id") Long id, Model model) {
		
		Usuario usuario = usuarioService.buscarUsuario(id);
		if(usuario != null) {
			model.addAttribute("usuario", usuario);
			return "/usuario/editar.jsp";
			
		}
		return "redirect:/usuario";
	}
	
    
    @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "/usuario/editarUsuario.jsp";
        } else {
        	usuarioService.updateUsuario(usuario);
            return "redirect:/usuario";
        }
    }
    
	public String login(@Valid @ModelAttribute("usuario") Usuario usuario) {
		
		usuarioService.insertarUsuario(usuario);
		
		return "redirect:/usuario";
	}

}
