package com.sistema.revistas.domain;

import java.math.BigDecimal;
import com.sistema.revistas.util.FormatadorDeValores;

public class Revista {
	
	private Long id;
	private String nome;
	private Boolean temDigital;
	private String tema;
	private String descricao;
	private BigDecimal precoDe;
	private BigDecimal precoPor;
	private Boolean estaDeletado;
	
	public static class RevistaBuilder {
		
		private Long id;
		private String nome;
		private Boolean temDigital;
		private String tema;
		private String descricao;
		private BigDecimal precoDe;
		private BigDecimal precoPor;
		private Boolean estaDeletado = false;
		
		public RevistaBuilder id(Long val) {
			id = val;
			return this;
		}
		
		public RevistaBuilder nome(String val) {
			nome = val;
			return this;
		}
		
		public RevistaBuilder temDigital(Boolean val) {
			temDigital = val;
			return this;
		}
		
		public RevistaBuilder tema(String val) {
			tema = val;
			return this;
		}
		
		public RevistaBuilder descricao(String val) {
			descricao = val;
			return this;
		}
		
		public RevistaBuilder precoDe(BigDecimal val) {
			precoDe = val;
			return this;
		}
		
		public RevistaBuilder precoPor(BigDecimal val) {
			precoPor = val;
			return this;
		}
		
		public RevistaBuilder estaDeletado(Boolean val) {
			estaDeletado = val;
			return this;
		}
		
		public Revista build() {
			return new Revista(this);
		}
		
	}

	public Revista(RevistaBuilder revistaBuilder) {
		this.nome = revistaBuilder.nome;
		this.id = revistaBuilder.id;
		this.temDigital = revistaBuilder.temDigital;
		this.tema = revistaBuilder.tema;
		this.descricao = revistaBuilder.descricao;
		this.precoDe = revistaBuilder.precoDe;
		this.precoPor = revistaBuilder.precoPor;
		this.estaDeletado = revistaBuilder.estaDeletado;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getTema() {
		return tema;
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