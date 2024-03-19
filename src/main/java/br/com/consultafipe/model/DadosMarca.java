package br.com.consultafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosMarca(String codigo, @JsonAlias("nome") String marca) {

    @Override
    public String toString() {
        return "{ Código: " + codigo + ", Marca: " + marca + ". }";
    }
}
