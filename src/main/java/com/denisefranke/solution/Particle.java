package com.denisefranke.solution;

/**
 * Particle - This is a pojo for Particle
 * 
 * @author Denise Franke
 */
class Particle {
	private int s; // speed units traveled per unit of time;
	private char d; // direction Right = R / direction Left = L / null 
	private int sl; // starting location in channel (0..channelLength)

	public Particle(int speed, char direction, int startingLocation) {
		s = speed;
		d = direction;
		sl = startingLocation; // location
	}

	public Integer getCurrentLocationGivenTime(int time, int channelLength) {
		Integer location = null;
		if (d == 'R') {
			location = (sl + (s * time));
			location = (location >= channelLength) ? null : location;
		} else if (d == 'L') {
			location = (sl - (s * time));
			location = (location < 0) ? null : location;
		}
		return location;
	}
}
