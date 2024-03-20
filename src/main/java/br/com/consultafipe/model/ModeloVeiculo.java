package br.com.consultafipe.model;

public record ModeloVeiculo(Integer TipoVeiculo, String Valor, String Marca, String Modelo, Integer AnoModelo, String Combustivel, String CodigoFipe, String MesReferencia, String SiglaCombustivel) {
    @Override
    public String toString() {
        return "Modelo do Veículo selecionado: \n{ " +
                "Tipo: " + TipoVeiculo + "\n" +
                "Valor: " + Valor + "\n" +
                "Marca: " + Marca + "\n" +
                "Modelo: " + Modelo + "\n" +
                "Ano do Modelo: " + AnoModelo + "\n" +
                "Combustível: " + Combustivel + "\n" +
                "Código Fipe: " + CodigoFipe + "\n" +
                "Mês de Referência: " + MesReferencia + "\n" +
                "Sigla Combustivel: " + SiglaCombustivel + ". \n}";
    }
}
