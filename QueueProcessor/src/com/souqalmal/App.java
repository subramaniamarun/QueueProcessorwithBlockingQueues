package com.souqalmal;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueProcessor processor = new QueueProcessor();
		
	
		
		Thread producer = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					processor.producer();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		});
		
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				try {
					processor.consumer("t1");
					
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
			
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				try {
					processor.consumer("t2");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
			
			
		});
		
		
		producer.start();
		t1.start();
		t2.start();
		System.out.println("Queue Processor Begun...");

	}

}
