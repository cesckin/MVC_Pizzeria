package controller;

public class Time {
	
	public static void wait(int ms)
	{
		try {
	        Thread.sleep(ms);
	    } catch (InterruptedException e) {
	        System.err.format("IOException: %s%n", e);
	    }
	}
	
}
