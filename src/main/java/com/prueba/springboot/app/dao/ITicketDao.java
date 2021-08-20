package com.prueba.springboot.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prueba.springboot.app.entity.Ticket;

public interface ITicketDao extends CrudRepository<Ticket, Long> {

	public List<Ticket> findByEstatus(int estatus);
	
	public List<Ticket> findByEstadoAndEstatus(String estado, int estatus);
}
