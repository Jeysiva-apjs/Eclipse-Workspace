package com.jey;

public class Producer extends Thread{
	
	Item item;
	
	public Producer(Item item){
		this.item = item;	
	}
	
	public void run() {
		for(int i=1; i<=10; i++) {
			try {
				item.produceItem(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}	
	}
}
