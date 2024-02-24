package com.jey;

class Item {
	
	private int buffer;
	private boolean flag = false;
	
	public synchronized void produceItem(int value) throws InterruptedException {
		if(flag) {
			wait();
		}
		this.buffer = value;
		System.out.println("Produced item: " + buffer);
		flag = true;
		notify();

	}
	
	public synchronized int consumeItem() throws InterruptedException {
		if(!flag) {
			wait();
		}
		
		System.out.println("Consumed item: " + buffer);
		flag = false;
		notify();
		return this.buffer;	
	}
}
