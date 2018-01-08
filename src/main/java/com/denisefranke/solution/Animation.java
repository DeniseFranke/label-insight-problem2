package com.denisefranke.solution;

//import java.util.Scanner;

public class Animation {
	
  public String[] animate(int speed,String init) throws Exception {
	//declare and initialize channel
	Channel channel = new Channel();
	int channelLength = init.length();
	channel.setPositions(channelLength);
	String[] chamber = new String[channelLength];	
	for (int t = 0; t < channelLength; t++) {
		chamber[t] = channel.getParticlesAtTimeUnit(t, channelLength);	
	}
    return chamber;
   }
  
   public static void main(String args[] ) throws Exception {   
	   
   }
  
 
}
 