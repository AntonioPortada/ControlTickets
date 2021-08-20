package com.prueba.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prueba.springboot.app.entity.Ticket;
import com.prueba.springboot.app.service.TicketServiceImp;

@Controller
public class TicketController {

	@Autowired
	private TicketServiceImp daoImp;
	
	@RequestMapping({"", "/", "index"})
	public String Listar(Model model) {
		
		model.addAttribute("titulo", "Lista de Tickets");
		model.addAttribute("ticket", daoImp.findBorrados(0));
		/*model.addAttribute("ticket_nuevos", daoImp.findByEstado("En Proceso", 0));
		model.addAttribute("ticket_nuevos", daoImp.findByEstado("Atendido", 0));*/
		
		return "tickets/listar";
	}
	
	//solicita la pantalla para crear
	@RequestMapping("tickets/form")
	public String agregar(Model model) {
		
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		
		return "tickets/form";
	}
	
	//metodo post para guardar los datos
	@PostMapping("tickets/form")
	public String save(Ticket ticket, Model model) {
		
		daoImp.save(ticket);
		
		return "redirect:/";
	}
	
	@RequestMapping("tickets/detalles/{id}")
	public String detalle(@PathVariable(value="id") Long id, Model model) {
		
		model.addAttribute("titulo", "Detalles");
		model.addAttribute("ticket", daoImp.findOne(id));
		
		return "tickets/detalles";
	}
	
	@RequestMapping("tickets/borrar/{id}")
	public String borrar(@PathVariable("id") Long id) {
		
		Ticket t = daoImp.findOne(id);
		t.setEstatus(1);
		daoImp.borrar(t);
		System.out.println("dato: " + t.getEstatus());
		
		return "redirect:/";
	}
	
	@RequestMapping("tickets/borrados")
	public String borrados(Model model) {
		
		model.addAttribute("titulo", "Tickets borrados");
		model.addAttribute("borrados", daoImp.findBorrados(1));
		
		return "tickets/borrados";
	}
	
	@RequestMapping("tickets/form/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		
		Ticket t = daoImp.findOne(id);
		
		model.addAttribute("titulo", "Editar ticket");
		model.addAttribute("ticket", t);
		
		return "tickets/form";
	}
}
