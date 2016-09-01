package com.algorithms.dp;

public class Item {
	private String name;
	private float weight;
	private int value;
	
	Item(String name, float weight, int value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public float getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}

}
