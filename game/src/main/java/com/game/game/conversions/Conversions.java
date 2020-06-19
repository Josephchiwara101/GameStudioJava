package com.game.game.conversions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


	@Configuration
	public class Conversions {


		private double k;
		private double m;
		private double c;
		private double km;
		
		public Conversions() {
			
		}
		
		public Conversions(double k, double m, double c, double km) {
			super();
			this.k = k;
			this.m = m;
			this.c = c;
			this.km = km;
		}
		
		@Bean
		public double getM() {
			return m;
		}
		public void setM(double m) {
			this.m = m;
		}
		
		@Bean
		public double getK() {
			return k;
		}
		public void setK(double k) {
			this.k = k;
		}
		
		@Bean
		public double getC() {
			return c;
		}
		public void setC(double c) {
			this.c = c;
		}
		
		@Bean
		public double getKm() {
			return km;
		}
		public void setKm(double km) {
			this.km = km;
		}
	
}
