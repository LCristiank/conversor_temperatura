package br.dev.luan.model;

public class Temperatura {
	private double celsius;
	
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	public double getCelsius() {
		return celsius;
	}
	
	public double converterParaKelvin() {
		double kelvin = celsius + 273.15;
		return kelvin;
	}
	public double converterParaFahreinhelt() {
		double fahreinhelt = (celsius * 1.8) + 32;
		return fahreinhelt;
	}
}
