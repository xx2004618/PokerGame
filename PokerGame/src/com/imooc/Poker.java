package com.imooc;

public class Poker implements Comparable<Poker>{

	private String number;
	private String color;
	
	public Poker(String number, String color) {
		this.number = number;
		this.color = color;
	}
	

	public Poker() {
		// TODO Auto-generated constructor stub
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Poker))
			return false;
		Poker other = (Poker) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}


	@Override
	public int compareTo(Poker o) {
		// TODO Auto-generated method stub
		InitialPoker initialPoker = new InitialPoker();
		return initialPoker.getPokerList().indexOf(this) - initialPoker.getPokerList().indexOf(o);
	}
	
	public static void main(String args[]){
		Poker poker1 = new Poker("A", "黑桃");
		Poker poker2 = new Poker("A", "红桃");
		System.out.println("第一张扑克为："+poker1.getColor()+poker1.getNumber());
		System.out.println("第二张扑克为："+poker2.getColor()+poker2.getNumber());
		System.out.println("比较结果为："+poker1.compareTo(poker2));
	}
}
