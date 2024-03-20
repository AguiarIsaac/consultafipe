package br.com.consultafipe.principal;

import br.com.consultafipe.model.DadosMarca;
import br.com.consultafipe.model.ModeloVeiculo;
import br.com.consultafipe.model.Modelos;
import br.com.consultafipe.service.ConsumoApi;
import br.com.consultafipe.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private final String URL = "https://parallelum.com.br/fipe/api/v1";
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi api = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

    public void iniciar() {
        boolean continuar = true;
        do {
            exibeMenu();
            System.out.println("\nDeseja fazer outra consulta? (s/n)");
            String resposta = leitura.nextLine();
            continuar = resposta.equalsIgnoreCase("s");
        } while (continuar);
        System.out.println("\nObrigado por usar a consulta FIPE!");
    }

    public void exibeMenu() {
        System.out.println("""
                ======================> CONSULTA FIPE <===============================
                ======================================================================
                 --- Digite o nº correspondente ao tipo de automovel que deseja buscar:
                 1 - Motos;
                 2 - Carros;
                 3 - Caminhões.""");

        var tipoVeiculo = Integer.valueOf(leitura.nextLine());

        String json;
        String endereco = null;
        List<DadosMarca> dadosMarcas = null;


        switch (tipoVeiculo) {

            case 1:
                endereco = URL + "/motos/marcas";
                json = api.obterDados(endereco);
                dadosMarcas = converteDados.obterLista(json, DadosMarca.class);
            break;
            case 2:
                endereco = URL + "/carros/marcas";
                json = api.obterDados(endereco);
                dadosMarcas = converteDados.obterLista(json, DadosMarca.class);
            break;
            case 3:
                endereco = URL + "/caminhoes/marcas";
                json = api.obterDados(endereco);
                dadosMarcas = converteDados.obterLista(json, DadosMarca.class);
            break;
        }

        dadosMarcas.forEach(System.out::println);

        System.out.println("\nAgora digite o código da marca que deseja realizar a consulta: ");

        var marcaVeiculo = Integer.parseInt(leitura.nextLine());

        endereco = endereco + "/"+marcaVeiculo+"/modelos";
        System.out.println(endereco);

        json = api.obterDados(endereco);

        Modelos modelos = converteDados.obterDados(json, Modelos.class);

        modelos.modelos().forEach(System.out::println);

        System.out.println("\nAgora Informe o código do modelo desejado: ");

        var codModelo = Integer.parseInt(leitura.nextLine());

        modelos.anos().forEach(System.out::println);

        System.out.println("\n Por ultimo, digite o código do ano: ");

        var codAno = leitura.nextLine();

        endereco = endereco + "/" + codModelo + "/anos/" + codAno;

        json = api.obterDados(endereco);

        ModeloVeiculo modeloVeiculo = converteDados.obterDados(json, ModeloVeiculo.class);

        System.out.println(modeloVeiculo);
    }
}
