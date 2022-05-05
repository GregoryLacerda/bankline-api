package com.dio.santander.bankline.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.bankline.api.model.Movimentacao;

public interface MovimentacaoRespository extends JpaRepository<Movimentacao, Integer>{

}
