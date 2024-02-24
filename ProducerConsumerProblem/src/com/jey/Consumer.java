package com.jey;

public class Consumer extends Thread{
	
	Item item;
	
	public Consumer(Item item) {
		this.item = item;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				item.consumeItem();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
