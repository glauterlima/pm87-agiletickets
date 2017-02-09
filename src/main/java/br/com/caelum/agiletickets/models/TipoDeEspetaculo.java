package br.com.caelum.agiletickets.models;

public enum TipoDeEspetaculo {
	
	CINEMA (0.10), SHOW (0.10), TEATRO(0.0), BALLET(0.20), ORQUESTRA(0.20);
	
	private double valorAcrescimo;
	
	TipoDeEspetaculo (double valorAcrescimo){
		this.valorAcrescimo = valorAcrescimo;
	}
	
	public double getValorAcrescimo(){
		return valorAcrescimo;
	}
	
}
