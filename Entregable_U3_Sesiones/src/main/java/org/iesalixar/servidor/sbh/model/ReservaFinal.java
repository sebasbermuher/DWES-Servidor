package org.iesalixar.servidor.sbh.model;

public class ReservaFinal {
	
	private String fecha_incio;
	private String fecha_final;
	private String num_personas;
	private String[] servicios;
	
	
	public ReservaFinal() {
		
	}
	
	public String getFecha_incio() {
		return fecha_incio;
	}
	public void setFecha_incio(String fecha_incio) {
		this.fecha_incio = fecha_incio;
	}
	public String getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(String fecha_final) {
		this.fecha_final = fecha_final;
	}
	public String getNum_personas() {
		return num_personas;
	}
	public void setNum_personas(String num_personas) {
		this.num_personas = num_personas;
	}
	
	public String[] getServicios() {
		return servicios;
	}

	public void setServicios(String[] servicios) {
		this.servicios = servicios;
	}
	
	

}
