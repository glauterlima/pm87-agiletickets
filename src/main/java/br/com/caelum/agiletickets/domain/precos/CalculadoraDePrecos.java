package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		
		TipoDeEspetaculo tipo = sessao.getEspetaculo().getTipo();
		Integer totalIngressos = sessao.getTotalIngressos();		
		Integer ingressosReservados = sessao.getIngressosReservados();		
		BigDecimal precoSessao = sessao.getPreco();
		Integer duracaoEmMinutos = sessao.getDuracaoEmMinutos();
		
		if (duracaoEmMinutos == null){
			duracaoEmMinutos = 0;
		}
		
		preco = calculaValorIngresso(totalIngressos,
				ingressosReservados, precoSessao, duracaoEmMinutos, tipo.getValorAcrescimo() );
		

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal calculaValorIngresso(Integer totalIngressos,
			Integer ingressosReservados, BigDecimal precoSessao,
			Integer duracaoEmMinutos, double valor) {
		BigDecimal preco;
		if((totalIngressos - ingressosReservados) / totalIngressos.doubleValue() <= 0.50) { 
			preco = precoSessao.add(precoSessao.multiply(BigDecimal.valueOf(valor)));
		} else {
			preco = precoSessao;
		}
		
		if(duracaoEmMinutos > 60){
			preco = preco.add(precoSessao.multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

}