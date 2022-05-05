package com.dio.santander.bankline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import com.dio.santander.bankline.api.repositories.CorrentistaRespository;
import com.dio.santander.bankline.api.repositories.MovimentacaoRespository;

@Service
public class MovimentacaoService {
	
	@Autowired
	MovimentacaoRespository repository;
	
	@Autowired
	private CorrentistaRespository correntistaRespository;
	
	public void save(NovaMovimentacao novaMovimentacao) {
		
		Movimentacao movimentacao = new Movimentacao();
		
		//Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		Double valor = novaMovimentacao.getValor();
		if (novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA) {
			valor = valor * -1;
		}
		
		movimentacao.setDataHota(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRespository.findById(novaMovimentacao.getIdConta()).orElse(null);
		
		if (correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRespository.save(correntista);
		}
		repository.save(movimentacao);
	}
}
