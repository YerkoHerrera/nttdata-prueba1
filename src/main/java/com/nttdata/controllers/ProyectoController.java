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

import com.nttdata.models.Proyecto;
import com.nttdata.services.ProyectoService;



@Controller
@RequestMapping("/proyecto")
public class ProyectoController {
	
	@Autowired //Inyección de dependencia entre services y luego repositories (Aca se utiliza para usar el proyectoService)
	ProyectoService proyectoService;

	//desplegar inicialmente el jsp
	@RequestMapping("")
	public String proyecto(@ModelAttribute("proyecto") Proyecto proyecto,
			Model model) {
		model.addAttribute("listaProyectos", proyectoService.obtenerListaProyectos());
		return "proyecto.jsp";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarProyecto(@RequestParam("id") Long id) {
		
		Proyecto proyecto = proyectoService.buscarProyecto(id);
		if(proyecto != null) {
			proyectoService.eliminarProyectoObjeto(proyecto);
			
		}
		return "redirect:/proyecto";
	}
	
	
	@RequestMapping("/{id}/editar")
	public String editarProyecto(@PathVariable("id") Long id, Model model) {
		
		Proyecto proyecto = proyectoService.buscarProyecto(id);
    	if(proyecto !=null) {
		       model.addAttribute("proyecto", proyecto);
		       return "/editarProyecto.jsp";
		}
		
		return "redirect:/proyecto";
    }
	
    
    @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("proyecto") Proyecto proyecto, BindingResult result) {
    	System.out.println("Entro al update");
    	if (result.hasErrors()) {
        	
            return "/editarProyecto.jsp";
        } else {
        	proyectoService.updateProyecto(proyecto);
            return "redirect:/proyecto";
        }
    }
    
    @RequestMapping("/login")
	public String login(@Valid @ModelAttribute("proyecto") Proyecto proyecto) {
		
    	proyectoService.insertarProyecto(proyecto);
		return "redirect:/proyecto";
	}

}
