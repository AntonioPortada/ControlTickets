package com.prueba.springboot.app.service;

import java.util.List;

import com.prueba.springboot.app.entity.Ticket;

public interface ITicketService {

	public List<Ticket> findAll();
	
	public Ticket findOne(Long id);
	
	public void save(Ticket ticket);
	
	public void borrar(Ticket ticket);
	
	public List<Ticket> findByEstado(String estado, int estatus);
	
	public List<Ticket> findBorrados(int estatus);
}
