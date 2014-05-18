package com.sistema.revistas.domain;

import java.math.BigDecimal;
import com.sistema.revistas.util.FormatadorDeValores;

public class Revista {
	
	private Long id;
	private String nome;
	private Boolean temDigital;
	private String tipo;
	private String descricao;
	private BigDecimal precoDe;
	private BigDecimal precoPor;
	private Boolean estaDeletado;
	
	public Revista() {}
	
	public Revista(Long id, String nome, Boolean temDigital, BigDecimal precoDe, BigDecimal precoPor, 
			       Boolean estaDeletado, String descricao, String tipo) {
		this.id = id;
		this.nome = nome;
		this.temDigital = temDigital;
		this.precoDe = precoDe;
		this.precoPor = precoPor;
		this.estaDeletado = estaDeletado;
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	public Revista(String nome, Boolean temDigital, BigDecimal precoDe, BigDecimal precoPor, String descricao, String tipo) {
		this.nome = nome;
		this.temDigital = temDigital;
		this.precoDe = precoDe;
		this.precoPor = precoPor;
		this.tipo = tipo;
		this.descricao = descricao;
		estaDeletado = false;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public Boolean getTemDigital() {
		return temDigital;
	}

	public BigDecimal getPrecoDe() {
		return precoDe;
	}

	public BigDecimal getPrecoPor() {
		return precoPor;
	}

	public Boolean getEstaDeletado() {
		return estaDeletado;
	}
	
	public String getPrecoDeFormatado() {
		return FormatadorDeValores.formataNumero(precoDe);
	}

	public String getPrecoPorFormatado() {
		return FormatadorDeValores.formataNumero(precoPor);
	}
	
}