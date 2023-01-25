package Services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TesteGupy {

	public static void main(String[] args) {

	}

	public void calculaFibonacci() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe um número: ");
		int num = scanner.nextInt();

		int a = 0, b = 1, c = 0;
		boolean encontrado = false;

		while (c < num) {
			c = a + b;
			a = b;
			b = c;
			if (c == num) {
				encontrado = true;
				break;
			}
		}

		if (encontrado) {
			System.out.println(num + " pertence à sequência de Fibonacci.");
		} else {
			System.out.println(num + " não pertence à sequência de Fibonacci.");
		}

	}

	public void Faturamento() {
		 ObjectMapper mapper = new ObjectMapper();
	        List<Double> faturamentos = new ArrayList();
	        try {
	            // Lê o arquivo JSON com os dados de faturamento
	            JsonNode root = mapper.readTree(new File("faturamento.json"));
	            JsonNode dias = root.path("dias");
	            for (JsonNode dia : dias) {
	                if (dia.path("eDiaDeTrabalho").asBoolean()) {
	                    double faturamento = dia.path("faturamento").asDouble();
	                    faturamentos.add(faturamento);
	                }
	            }

	            // Calcula o menor valor de faturamento
	            double menorValor = Double.MAX_VALUE;
	            for (double faturamento : faturamentos) {
	                if (faturamento < menorValor) {
	                    menorValor = faturamento;
	                }
	            }

	            // Calcula o maior valor de faturamento
	            double maiorValor = Double.MIN_VALUE;
	            for (double faturamento : faturamentos) {
	                if (faturamento > maiorValor) {
	                    maiorValor = faturamento;
	                }
	            }

	            // Calcula a média mensal
	            double soma = 0;
	            for (double faturamento : faturamentos) {
	                soma += faturamento;
	            }
	            double media = soma / faturamentos.size();

	            // Conta o número de dias com faturamento acima da média
	            int diasAcimaDaMedia = 0;
	            for (double faturamento : faturamentos) {
	                if (faturamento > media) {
	                    diasAcimaDaMedia++;
	                }
	            }

	            // Imprime os resultados
	            System.out.println("Menor valor de faturamento: " + menorValor);
	            System.out.println("Maior valor de faturamento: " + maiorValor);
	System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
	} catch (IOException e) {
	e.printStackTrace();
	}
	}

	public void RepresentacaoEstado() {

		double sp = 67836.43;
		double rj = 36678.66;
		double mg = 29229.88;
		double es = 27165.48;
		double outros = 19849.53;

		double total = sp + rj + mg + es + outros;

		double percentualSp = (sp / total) * 100;
		double percentualRj = (rj / total) * 100;
		double percentualMg = (mg / total) * 100;
		double percentualEs = (es / total) * 100;
		double percentualOutros = (outros / total) * 100;

		System.out.println("SP: " + percentualSp + "%");
		System.out.println("RJ: " + percentualRj + "%");
		System.out.println("MG: " + percentualMg + "%");
		System.out.println("ES: " + percentualEs + "%");
		System.out.println("Outros: " + percentualOutros + "%");

	}

	public void InverString() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe uma string: ");
		String original = scanner.nextLine();
		String invertida = "";

		for (int i = original.length() - 1; i >= 0; i--) {
			invertida += original.charAt(i);
		}

		System.out.println("String invertida: " + invertida);

	}

}
