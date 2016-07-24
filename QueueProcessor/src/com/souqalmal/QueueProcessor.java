package com.souqalmal;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueProcessor {
	
	// A queue object of strings, which is thread safe and fairness policy set to true to guarantee FIFO
	private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(100, true);
	
	private int counter = 0;
	
	private String queueItem;
	
	private int maxTimeout = 2001;
	private int minTimeout = 500;
	
	
	
	public void producer() throws InterruptedException {
		
		while(true) {   //run indefinitely
			
			counter++;
			
			queueItem = "item" +" " + "{" + counter + "}";
			
			System.out.println("Produced   :"+queueItem);
			
			queue.put(queueItem);
			
			Thread.sleep(1000);
			
			
			
		}
		
	}
	
	public void consumer(String threadName) throws InterruptedException {
		
		while(true) {
			
			Random random = new Random();
			int x = random.nextInt(maxTimeout)+minTimeout;
			
			System.out.println(threadName+"   :   "+queue.take());
			
			System.out.println("Consumer Thread "+threadName+"  going to sleep for : "+x);
			
			Thread.sleep(x);
			
		}
		
		
	}
	
	
	

}
