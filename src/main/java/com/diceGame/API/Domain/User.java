package com.diceGame.API.Domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	private Integer id;
	private String name;
	private String date;
	private double victoryPercentage;
	
	public User() {}
	
	public User(int id) {
		super();
		this.id = id;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		this.date = LocalDate.now().toString();
	}
	
	
	public double getVictoryPercentage() {
		return victoryPercentage;
	}

	public void setVictoryPercentage(double victoryPercentage) {
		this.victoryPercentage = victoryPercentage;
	}
}
