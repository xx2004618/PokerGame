package com.imooc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OnTheTable {
	
	private List<Gamer> gamerList;
	private InitialPoker initialPoker;
	private Scanner console;
	
	public List<Gamer> getGamerList() {
		return gamerList;
	}
	
	public void setGamerList(List<Gamer> gamerList) {
		this.gamerList = gamerList;
	}
	
	public InitialPoker getInitialPoker() {
		return initialPoker;
	}
	
	public void setInitialPoker(InitialPoker initialPoker) {
		this.initialPoker = initialPoker;
	}
	
	public OnTheTable() {
		System.out.println("-----------------成功创建房间-----------------");
		this.gamerList = new ArrayList<Gamer>();
		this.initialPoker = new InitialPoker();
		System.out.println("-------------------开始游戏------------------");
	}
	
	/**
	 * 创建ID
	 */
	public void createNewGamer(){
		Gamer gamer = new Gamer();
		System.out.println("请创建一个新的ID：");
		do{
			try{
				console = new Scanner(System.in);
				int enterId = console.nextInt();
				gamer.setId(enterId);
				if(gamerList.contains(gamer)){
					System.out.println("此ID已被占用，请重新输入：");
					continue;
				}
				break;
			}catch(Exception e){
				System.out.println("ERROR：请输入一个整数！");
				System.out.println("请再输入一遍：");
			}
		}while(true);
		System.out.println("请输入您的姓名：");
		String name = console.next();
		gamer.setName(name);
		gamerList.add(gamer);
		System.out.println("成功创建"+gamer.getId()+"."+gamer.getName());
	}
	
	/**
	 * 发牌
	 * @param args
	 */
	public void deal(){
		for(Gamer gamer:gamerList){
			//发牌
			gamer.getHand().add(initialPoker.getPokerPile().get(0));
//			System.out.println(gamer.getName()+"的第"+gamer.getHand().size()+"张牌是："+initialPoker.getPokerPile().get(0).getColor()+initialPoker.getPokerPile().get(0).getNumber());
			initialPoker.getPokerPile().remove(0);
		}
		System.out.println("第"+gamerList.get(0).getHand().size()+"次发牌！");
	}
	
	/**
	 * 比较手牌大小
	 * @param args
	 */
	public void compareHand(){
		int sizeOfHand = gamerList.get(0).getHand().size();
		for(Gamer gamer:gamerList){
			Collections.sort(gamer.getHand());
//			for(Poker poker:gamer.getHand()){
//				System.out.println(gamer.getName()+"的第"+(gamer.getHand().indexOf(poker)+1)+"是："+poker.getColor()+poker.getNumber());
//			}
		}
		Gamer winner = new Gamer();
		winner = gamerList.get(0);
		for(int i=1; i<gamerList.size(); i++){
			if(winner.getHand().get(sizeOfHand-1).compareTo(gamerList.get(i).getHand().get(sizeOfHand-1))<0){
				winner = gamerList.get(i);
			}
		}
		System.out.println("-------------------最终胜者------------------");
		System.out.println("最终胜者是："+winner.getName());
		System.out.println("他拥有的最大的手牌是："+winner.getHand().get(sizeOfHand-1).getColor()+winner.getHand().get(sizeOfHand-1).getNumber());
	}
	
	/**
	 * 显示所有人的所有手牌
	 * @param args
	 */
	public void displayEveryHand(){
		for(Gamer gamer:gamerList){
			System.out.println("");
			System.out.print(gamer.getName()+"的手牌是：");
			for(Poker poker:gamer.getHand()){
				System.out.print("  "+poker.getColor()+poker.getNumber());
			}
		}
	}
	
	/**
	 * 显示所有在场的人
	 * @param args
	 */
	public void displayEveryGamer(){
		System.out.println("-------------------房间信息------------------");
		System.out.println("目前房间里有"+gamerList.size()+"个人");
		for(Gamer gamer:gamerList){
			System.out.println(gamer.getId()+"."+gamer.getName());
		}
	}

	public static void main(String args[]){
		OnTheTable onTheTable = new OnTheTable();
		onTheTable.createNewGamer();
		onTheTable.createNewGamer();
		onTheTable.getInitialPoker().generatePile();
		onTheTable.displayEveryGamer();
		onTheTable.deal();
		onTheTable.deal();
		onTheTable.compareHand();
		onTheTable.displayEveryHand();
	}
}
