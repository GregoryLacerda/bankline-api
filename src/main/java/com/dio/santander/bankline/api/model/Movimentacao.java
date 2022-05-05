package com.dio.santander.bankline.api.model;

import java.time.LocalDateTime;


public class Movimentacao {
	
	private Integer id;
	private LocalDateTime dataHota;
	private String descricao;
	private Double valor;
	
	private MovimentacaoTipo tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataHota() {
		return dataHota;
	}

	public void setDataHota(LocalDateTime dataHota) {
		this.dataHota = dataHota;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public MovimentacaoTipo getTipo() {
		return tipo;
	}

	public void setTipo(MovimentacaoTipo tipo) {
		this.tipo = tipo;
	}
	
	
}
