package com.game.game.conversions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Conversionsservice {
	
	@Autowired
	private Conversions conversions; 
	
	public double toCelsius() {
		double k = conversions.getK();
		double c;
		c = k - 273.15;
		return c;
	}
	
	 public double toKelvin() {
		 double c = conversions.getC();
		  double k;
		  k = c + 273.15; 
		  return k; 
		  }
	 
	 public double toKilometers() {
		 double m = conversions.getM();
		  double k; 
		  k = m * 1.6; 
		  return k; 
		  }
	 
	 public double toMiles() {
		 double k =conversions.getKm();
		  double m;
		  m = k/1.6; 
		  return m;
		  }
}