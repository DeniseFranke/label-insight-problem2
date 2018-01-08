package com.denisefranke.solution;

import java.util.List;

public class Channel {
 
  private List<Particle> particles;
  private int chamberSize = 0;
  
  public Channel getChannel() {
	return this;	  
  }
  
  public void initializeParticles(int speed, String s) {
	 for (int i = 0; i < s.length(); i++) {
		 Particle particle = new Particle();
		 String p = String.valueOf(s.charAt(i));
		 particle.setDirection(p);
		 particle.setSpeed(speed);
		 particle.setStartingLocation(i);
		 this.particles.add(particle);
	 }
  }
  
  public int getChamberSize() {
	  return chamberSize;
  }
  
  public void setPositions(int positions) throws Exception {
	  if (positions > 0 && positions <= 50) {
		  chamberSize = positions;
	  } else {
		  throw new Exception();
	  }	  
  } 

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
  
  
  public String getParticlesAtTimeUnit(int time, int channelLength) {
	   StringBuilder c = new StringBuilder();
		   c.replace(0, channelLength, ".");  
	   if ( particles != null ) {
		   for (Particle particle : particles) {
		      int p = particle.getCurrentLocationGivenTime(time);
		      if ( p > 0 && p <= 50) {
		    	  		c.setCharAt(p,'X');
		      } else {
		    	  	   particles.remove(particle);
		      }
		   }
	   }
	return c.toString(); 
	
  }
   
  
   
 
}
 