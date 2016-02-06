package com.imooc;

import java.util.ArrayList;
import java.util.List;

public class Gamer {
	
	private String name;
	private int id;
	private List<Poker> hand;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Poker> getHand() {
		return hand;
	}

	public void setHand(List<Poker> hand) {
		this.hand = hand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Gamer))
			return false;
		Gamer other = (Gamer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public Gamer() {
		this.name = "";
		this.id = 0;
		this.hand = new ArrayList<Poker>();
	}

	public static void main(String args[]){
//		Gamer gamer = new Gamer();
	}
}
