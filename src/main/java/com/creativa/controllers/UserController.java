package com.creativa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.creativa.dao.RolesDAO;
import com.creativa.entidades.Roles;
import com.creativa.entidades.Usuario;
import com.creativa.service.RolesService;
import com.creativa.service.UsuarioService;

@Controller
public class UserController {
	@Autowired
	 RolesService servicio;
	//private RolesService rolesService;
	@Autowired
	UsuarioService servicioU;

	@RequestMapping(value = "/crearRol", method = RequestMethod.GET)
	public String mostrar(Model model) {
		model.addAttribute("roles", new Roles());
		return "formulario";
	}

	@RequestMapping(value = "/crearRol", method = RequestMethod.POST)
	public String crearRol(@ModelAttribute("roles") Roles roles, Model model) {	
		servicio.Add(roles);
		model.addAttribute("role", servicio.listar());
		model.addAttribute("usuario", new Usuario());
		return "usuario";
	}
	
	@RequestMapping(value = "/crearUsuario", method = RequestMethod.GET)
	public String nuevoUser(Model model) {
		model.addAttribute("role", servicio.listar());
		model.addAttribute("usuario", new Usuario());
		return "usuario";
	}
	
	@RequestMapping(value = "/crearUsuario", method = RequestMethod.POST)
	public String crearUsuario(@ModelAttribute("usuario") Usuario user,Model model) {
		servicioU.AddU(user);
		model.addAttribute("mensaje", "se agrego exitosamente");
		return "home";
	}
}
