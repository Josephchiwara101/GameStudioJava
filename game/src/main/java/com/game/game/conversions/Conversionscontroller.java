package com.game.game.conversions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Conversionscontroller {
	
	@Autowired
	private Conversionsservice conversionsservice;
	
	@RequestMapping("/conversions/ktoc")
	public double toCelsius() {
		return conversionsservice.toCelsius();}
	
	  @RequestMapping("/conversions/ctok") 
	  public double toKelvin() {
		  return conversionsservice.toKelvin(); }
	  
	  @RequestMapping("/conversions/mtok") 
	  public double toKilometers() {
		  return conversionsservice.toKilometers(); }
	  
	  @RequestMapping("/conversions/ktom") 
	  public double toMiles() {
		  return conversionsservice.toMiles(); }
	 
}