package com.prueba.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.springboot.app.dao.ITicketDao;
import com.prueba.springboot.app.entity.Ticket;

@Service
public class TicketServiceImp implements ITicketService {

	@Autowired
	private ITicketDao dao;
	
	@Override
	public List<Ticket> findAll() {
		return (List<Ticket>) dao.findAll();
	}

	@Override
	public Ticket findOne(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void save(Ticket ticket) {
		dao.save(ticket);
	}

	@Override
	public void borrar(Ticket ticket) {
		dao.save(ticket);
	}

	@Override
	public List<Ticket> findByEstado(String estado, int estatus) {
		return dao.findByEstadoAndEstatus(estado, estatus);
	}
	
	@Override
	public List<Ticket> findBorrados(int estatus) {
		return dao.findByEstatus(estatus);
	}
}
