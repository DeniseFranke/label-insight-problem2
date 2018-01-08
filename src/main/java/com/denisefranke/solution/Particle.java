package com.denisefranke.solution;

/**
 * Particle - this is a pojo for Particle
 * with an extra method to get the particle's current location in a channel given the current state of time
 * @author Denise Franke
 *
 */

public class Particle {
  private int startingLocation = 0;
  private int speed = 0;
  private String direction = "L";

  public String getDirection() {
	  return direction;
  }

  public void setDirection(String direction) {
	  this.direction = direction;
  }

  public int getStartingLocation() {
	  return startingLocation;
  }

  public void setStartingLocation(int startingLocation) {
	  this.startingLocation = startingLocation;
  }

  public int getSpeed() {
	  return speed;
  }
  
  public void setSpeed(int speed) {
	  this.speed = speed;
  }
  
  public Integer getCurrentLocationGivenTime(int time) {
	  if (speed >= 0 && time >=0 ) {
		  if (direction.equals("L"))  
    	  		return startingLocation  + (speed * time);
		  if (direction.equals("R"))
    	  		return startingLocation - (speed * time);
	  }
	 return null;  	 
  }
}
 