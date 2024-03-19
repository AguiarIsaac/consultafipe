package br.com.consultafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosModelo(String codigo, @JsonAlias("nome") String modelo) {
}
