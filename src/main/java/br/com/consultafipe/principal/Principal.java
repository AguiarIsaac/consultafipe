package br.com.consultafipe.principal;

import br.com.consultafipe.model.DadosMarca;
import br.com.consultafipe.model.DadosModelo;
import br.com.consultafipe.service.ConsumoApi;
import br.com.consultafipe.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private final String URL = "https://parallelum.com.br/fipe/api/v1";
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi api = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
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

        System.out.println(json);

//        List<DadosModelo> dadosModelos = converteDados.obterlista(json, DadosModelo.class);
//
//        System.out.println(dadosModelos);
//
//        String modelos = api.obterDados(endereco);
//
//        System.out.println(modelos);
//
//        System.out.println("Digite o código do modelo desejado: ");
//
//        var codModelo = Integer.valueOf(leitura.nextLine());
//
//        endereco = "https://parallelum.com.br/fipe/api/v1/motos/marcas/80/modelos/"+codModelo+"/anos";
//        System.out.println(endereco);
//
//        String anoModelo = api.obterDados(endereco);
//
//        System.out.println(anoModelo);
//
//        System.out.println("Digite o ano: ");
//
//        String codAno = leitura.nextLine();
//
//        String resultadoFinal = api.obterDados("https://parallelum.com.br/fipe/api/v1/motos/marcas/80/modelos/"+codModelo+"/anos/" + codAno);
//
//        System.out.println(resultadoFinal);
    }
}
