package com.sistema.revistas.domain;

import java.math.BigDecimal;

public class Revista {
	
	private Long id;
	private String nome;
	private Boolean temDigital;
	private BigDecimal precoDe;
	private BigDecimal precoPor;
	private Boolean estaDeletado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getTemDigital() {
		return temDigital;
	}

	public void setTemDigital(Boolean temDigital) {
		this.temDigital = temDigital;
	}

	public BigDecimal getPrecoDe() {
		return precoDe;
	}

	public void setPrecoDe(BigDecimal precoDe) {
		this.precoDe = precoDe;
	}

	public BigDecimal getPrecoPor() {
		return precoPor;
	}

	public void setPrecoPor(BigDecimal precoPor) {
		this.precoPor = precoPor;
	}

	public Boolean getEstaDeletado() {
		return estaDeletado;
	}

	public void setEstaDeletado(Boolean estaDeletado) {
		this.estaDeletado = estaDeletado;
	}
	
}