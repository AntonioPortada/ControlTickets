package com.prueba.springboot.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String titulo;
	
	/*@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaRegistro;*/
	
	private String responsable;
	
	@Column(name = "equipo_responsable")
	private String equipoResponsable;
	
	@Column(name = "tipo_incidencias")
	private String tipoIncidencia;
	
	private String gravedad;
	private float version;
	private String descripcion;
	private String archivos;
	private String estado;
	
	@Column(name = "estatus")
	private int estatus;

	/*@PrePersist
	private void getFechaRegistro() {
		this.fechaRegistro = new Date();
		System.out.println("fecha: "+fechaRegistro);
	}*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/*public Date getRegistro() {
		return fechaRegistro;
	}

	public void setRegistro(Date registro) {
		this.fechaRegistro = registro;
	}*/

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getEquipoResponsable() {
		return equipoResponsable;
	}

	public void setEquipoResponsable(String equipoResponsable) {
		this.equipoResponsable = equipoResponsable;
	}

	public String getTipoIncidencia() {
		return tipoIncidencia;
	}

	public void setTipoIncidencia(String tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}

	public String getGravedad() {
		return gravedad;
	}

	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}

	public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getArchivos() {
		return archivos;
	}

	public void setArchivos(String archivos) {
		this.archivos = archivos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
}
