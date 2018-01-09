/*
 * The MIT License (MIT)
 * 
 * Copyright © 2018 Denise Franke. All rights reserved.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.denisefranke.solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Channel {

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		int speed = 0;
		String init = "";
		if (scan.hasNextInt()) {
			speed = scan.nextInt();
			if (scan.hasNext()) {
				init = scan.next();
			}
			System.out.println(animate(speed, init));
		}
		scan.close();
	}

	public static String[] animate(int speed, String init) throws Exception {
		if (speed == 0 || init.isEmpty()) {
			// TODO: This should never happen, but just in case it does, should probably
			// throw a useful exception here
			return null;
		}
		// initialize particles
		List<Particle> particles = new ArrayList<Particle>();
		for (int u = 0; u < init.length(); u++) {
			particles.add(new Particle(speed, init.charAt(u), u));
		}
		// initialize chamber
		List<String> list = new ArrayList<String>();
		// create a particle iterator to manage removing particles when they exit the
		// channel either direction

		boolean eol = false; // end of life
		for (int t = 0; (t < init.length() && !eol); t++) {
			Character[] chamber = new Character[init.length()];
			Iterator<Particle> iterator = particles.iterator();
			// iterate through particles until all particles are at end of channel
			while (iterator.hasNext()) {
				Particle particle = iterator.next();
				Integer location = particle.getCurrentLocationGivenTime(t, init.length());
				if (location == null || location < 0 || location >= init.length()) {
					iterator.remove();
				} else {
					chamber[location] = 'X';
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int u = 0; u < init.length(); u++) {
				if (null != chamber[u] && chamber[u].equals('X'))
					sb.append(chamber[u]);
				else
					sb.append('.');
			}
			String s = sb.toString();
			list.add(s);

			// even if the time hasn't run out, blank row should only have print once. So
			// break out of for loop here;
			if (!s.contains("X")) {
				eol = true;
			}
		}
		String[] ret = list.toArray(new String[0]);
		return ret;
	}
}
