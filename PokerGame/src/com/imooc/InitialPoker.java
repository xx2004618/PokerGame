package com.imooc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitialPoker {

	private List<Poker> pokerList;
	private List<Poker> pokerPile;
	private List<String> pokerColor;

	public List<Poker> getPokerList() {
		return pokerList;
	}
	
	public void setPokerList(List<Poker> pokerList) {
		this.pokerList = pokerList;
	}

	public List<Poker> getPokerPile() {
		return pokerPile;
	}

	public void setPokerPile(List<Poker> pokerPile) {
		this.pokerPile = pokerPile;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pokerColor == null) ? 0 : pokerColor.hashCode());
		result = prime * result + ((pokerList == null) ? 0 : pokerList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof InitialPoker))
			return false;
		InitialPoker other = (InitialPoker) obj;
		if (pokerColor == null) {
			if (other.pokerColor != null)
				return false;
		} else if (!pokerColor.equals(other.pokerColor))
			return false;
		if (pokerList == null) {
			if (other.pokerList != null)
				return false;
		} else if (!pokerList.equals(other.pokerList))
			return false;
		return true;
	}
	/**
	 * 生成一系列的扑克牌
	 */
	public InitialPoker(){
		System.out.println("-----------------正在加载游戏-----------------");
		Poker poker;
		pokerColor = new ArrayList<String>();
		pokerList = new ArrayList<Poker>();
		pokerPile = new ArrayList<Poker>();
		pokerColor.add("方片");
		pokerColor.add("梅花");
		pokerColor.add("红桃");
		pokerColor.add("黑桃");
		for(int i=0; i<52; i++){
			poker = new Poker();
			poker.setColor(pokerColor.get(i%4));
			int k = (int)(i/4)+2;
			if(k<11)
				poker.setNumber(Integer.toString(k));
			else if(k==11)
				poker.setNumber("J");
			else if(k==12)
				poker.setNumber("Q");
			else if(k==13)
				poker.setNumber("K");
			else
				poker.setNumber("A");
			pokerList.add(poker);
		}
		System.out.println("-----------------成功生成纸牌-----------------");
		generatePile();
		System.out.println("-------------------载入完成------------------");
	}

	/**
	 * 生成牌堆
	 */
	public void generatePile(){
		//不能使用Set进行随机生成，因为set并非完全随机的
//		Set<Poker> pokerSet = new HashSet<Poker>(pokerList);
//		for(Poker pokerTemp:pokerSet){
//			pokerPile.add(pokerTemp);
//			System.out.println(pokerTemp.getColor()+pokerTemp.getNumber());
//		}
		Random random = new Random();
		List<Poker> pokerListTemp = new ArrayList<Poker>();
		pokerListTemp = pokerList;
		int k=0;
		for(int i=0; i<pokerList.size(); i++){
			k = random.nextInt(pokerListTemp.size()-1);
			pokerPile.add(pokerListTemp.get(k));
			pokerListTemp.remove(k);
		}
		System.out.println("-------------------完成洗牌------------------");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitialPoker initialPoker = new InitialPoker();
		initialPoker.generatePile();
	}

}
