package com.souqalmal;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

final public class QueueProcessor {
	
	// A queue object of strings, which is thread safe and fairness policy set to true to guarantee FIFO
	private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(100, true);
	
	private Integer counter = 0; //Immutable
	
	private String queueItem;
	
	private Integer maxTimeout = 2001;
	private Integer minTimeout = 500;
	
	
	
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
