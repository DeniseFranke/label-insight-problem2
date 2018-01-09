package com.denisefranke.solution;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//TODO: I assumed the test comparing the arrays would suffice, 
// but left this GSON import here to see if anyone looked at these tests. -Denise
// Uncomment the following two lines & the two in the last test to see the prettified output.  
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

public class ChannelTest {
	private Channel channel;

	@BeforeEach
	void init() {
		setChannel(new Channel());
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@AfterEach
	void tearDown() {
		setChannel(null);
	}

	/**
	 * Animation Test 0:  Given:  2, ..R....
	 * Returns: {"..X....","....X..","......X","......."} Reason:
	 * This sentence contains every letter at least once
	 * 
	 * @throws Exception
	 */
	@DisplayName("Animation Test 0")
	@Test
	void animationTest0() {
		int speed = 2;
		String init = "..R....";
		String[] expected = { "..X....", "....X..", "......X", "......." };
		try {
			String[] actual;
			actual = Channel.animate(speed, init);
			assertArrayEquals(expected, actual);
			assertEquals(expected[0],actual[0]);
			assertEquals(expected[1],actual[1]);
			assertEquals(expected[2],actual[2]);
			assertEquals(expected[3],actual[3]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Animation Test 1:  Given:   3,  "RR..LRL"
	 * Returns: {"XX..XXX",".X.XX..","X.....X","......."} Reason:
	 * Note that, at the first time step after initialization, 
	 * there are actually 4 particles in the chamber,
	 * but two are passing through each other at the 4th position
	 * 
	 */
	@DisplayName("Animation Test 1")
	@Test
	void animationTest1() {
		int speed = 3;
		String init = "RR..LRL";
		String[] expected = { "XX..XXX", ".X.XX..", "X.....X", "......." };
		try {
			String[] actual;
			actual = Channel.animate(speed, init);
			assertArrayEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Animation Test 2:  Given:   2,  "LRLR.LRLR"
	 * Returns: {"XXXX.XXXX","X..X.X..X",".X.X.X.X.",".X.....X.","........."}
	 * Reason: At time 0 (init) there are 8 particles. At time 1, there are 
	 * still 6 particles, but only 4 positions are occupied since particles are
	 * passing through each other.
	 */
	@DisplayName("Animation Test 2")
	@Test
	void animationTest2() {
		int speed = 2;
		String init = "LRLR.LRLR";
		String[] expected = { "XXXX.XXXX", "X..X.X..X", ".X.X.X.X.", ".X.....X.", "........." };
		try {
			String[] actual;
			actual = Channel.animate(speed, init);
			assertArrayEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Animation Test 3:  Given:   10,  "RLRLRLRLRL"
	 * Returns: {"XXXXXXXXXX",".........." } Reason:
	 * These particles are moving so fast that they all exit the chamber by time 1.
	 */
	@DisplayName("Animation Test 3")
	@Test
	void animationTest3() {
		int speed = 10;
		String init = "RLRLRLRLRL";
		String[] expected = { "XXXXXXXXXX", ".........." };
		try {
			String[] actual;
			actual = Channel.animate(speed, init);
			assertArrayEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Animation Test 4:  Given:    1,  "..." Returns:{ "..." } Reason: There are no
	 * particles in short channel
	 */
	@DisplayName("Animation Test 4")
	@Test
	void animationTest4() {
		int speed = 1;
		String init = "...";
		String[] expected = { "..." };
		try {
			String[] actual;
			actual = Channel.animate(speed, init);
			assertArrayEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Animation Test 5:  Given:     1,  "LRRL.LR.LRR.R.LRRL."
	 * Returns:{"XXXX.XX.XXX.X.XXXX.","..XXX..X..XX.X..XX.",".X.XX.X.X..XX.XX.XX","X.X.XX...X.XXXXX..X",".X..XXX...X..XX.X..","X..X..XX.X.XX.XX.X.","..X....XX..XX..XX.X",".X.....XXXX..X..XX.","X.....X..XX...X..XX",".....X..X.XX...X..X","....X..X...XX...X..","...X..X.....XX...X.","..X..X.......XX...X",".X..X.........XX...","X..X...........XX..","..X.............XX.",".X...............XX","X.................X","..................."};
	 * Reason: Super Long Channel moving slowly
	 */
	@DisplayName("Animation Test 5")
	@Test
	void animationTest5() {
		int speed = 1;
		String init = "LRRL.LR.LRR.R.LRRL.";
		String[] expected = { "XXXX.XX.XXX.X.XXXX.", "..XXX..X..XX.X..XX.", ".X.XX.X.X..XX.XX.XX",
				"X.X.XX...X.XXXXX..X", ".X..XXX...X..XX.X..", "X..X..XX.X.XX.XX.X.", "..X....XX..XX..XX.X",
				".X.....XXXX..X..XX.", "X.....X..XX...X..XX", ".....X..X.XX...X..X", "....X..X...XX...X..",
				"...X..X.....XX...X.", "..X..X.......XX...X", ".X..X.........XX...", "X..X...........XX..",
				"..X.............XX.", ".X...............XX", "X.................X", "..................." };
		try {
			String[] actual;
			actual = Channel.animate(speed, init);
			assertArrayEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Animation Test 6:  Given:  1,"LRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRR"
	 * Returns: {"XXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXX","..XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XX",".XXXXX..XXXXXXXXX..XXXXXXXXX..XXXXXXXXX..XXXXXXXXX..XXXXXXXXX..X.X","XX..XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX...X.","X..X.XXX..XXXXX.XXX..XXXXX.XXX..XXXXX.XXX..XXXXX.XXX..XXXXX.XX...X","..X...XX.XXX.XXX.XX.XXX.XXX.XX.XXX.XXX.XX.XXX.XXX.XX.XXX.XXX.XX...",".X...X.XXX..X.XXX.XXX..X.XXX.XXX..X.XXX.XXX..X.XXX.XXX..X.XXX.XX..","X...X..XXX.X.X.XXXXXX.X.X.XXXXXX.X.X.XXXXXX.X.X.XXXXXX.X.X.XXX.XX.","...X..XX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX","..X..XX..XXX.X.XXXXXXXX.X.XXXXXXXX.X.XXXXXXXX.X.XXXXXXXX...X.XXX.X",".X..XX..X..XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX...X.XXX.","X..XX..X...XXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXX.XX...X.XXX","..XX..X...X..XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX...X.XX",".XX..X...X..XXXXX..XXXXXXXXX..XXXXXXXXX..XXXXXXXXX..X.XXX.XX...X.X","XX..X...X..XX..XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX...X.XXX.XX...X.","X..X...X..XX..X.XXX..XXXXX.XXX..XXXXX.XXX..XXXXX.XX...X.XXX.XX...X","..X...X..XX..X...XX.XXX.XXX.XX.XXX.XXX.XX.XXX.XXX.XX...X.XXX.XX...",".X...X..XX..X...X.XXX..X.XXX.XXX..X.XXX.XXX..X.XXX.XX...X.XXX.XX..","X...X..XX..X...X..XXX.X.X.XXXXXX.X.X.XXXXXX.X.X.XXX.XX...X.XXX.XX.","...X..XX..X...X..XX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX","..X..XX..X...X..XX..XXX.X.XXXXXXXX.X.XXXXXXXX...X.XXX.XX...X.XXX.X",".X..XX..X...X..XX..X..XX..XX.XXX.XX..XX.XXX.XX...X.XXX.XX...X.XXX.","X..XX..X...X..XX..X...XXXXX.XXXXXXXXXX.XXXXX.XX...X.XXX.XX...X.XXX","..XX..X...X..XX..X...X..XX..XX.XXX.XX..XX.XXX.XX...X.XXX.XX...X.XX",".XX..X...X..XX..X...X..XXXXX..XXXXXXXXX..X.XXX.XX...X.XXX.XX...X.X","XX..X...X..XX..X...X..XX..XX..XX.XXX.XX...X.XXX.XX...X.XXX.XX...X.","X..X...X..XX..X...X..XX..X.XXX..XXXXX.XX...X.XXX.XX...X.XXX.XX...X","..X...X..XX..X...X..XX..X...XX.XXX.XXX.XX...X.XXX.XX...X.XXX.XX...",".X...X..XX..X...X..XX..X...X.XXX..X.XXX.XX...X.XXX.XX...X.XXX.XX..","X...X..XX..X...X..XX..X...X..XXX.X.X.XXX.XX...X.XXX.XX...X.XXX.XX.","...X..XX..X...X..XX..X...X..XX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX","..X..XX..X...X..XX..X...X..XX..XXX...X.XXX.XX...X.XXX.XX...X.XXX.X",".X..XX..X...X..XX..X...X..XX..X..XX...X.XXX.XX...X.XXX.XX...X.XXX.","X..XX..X...X..XX..X...X..XX..X....XX...X.XXX.XX...X.XXX.XX...X.XXX","..XX..X...X..XX..X...X..XX..X......XX...X.XXX.XX...X.XXX.XX...X.XX",".XX..X...X..XX..X...X..XX..X........XX...X.XXX.XX...X.XXX.XX...X.X","XX..X...X..XX..X...X..XX..X..........XX...X.XXX.XX...X.XXX.XX...X.","X..X...X..XX..X...X..XX..X............XX...X.XXX.XX...X.XXX.XX...X","..X...X..XX..X...X..XX..X..............XX...X.XXX.XX...X.XXX.XX...",".X...X..XX..X...X..XX..X................XX...X.XXX.XX...X.XXX.XX..","X...X..XX..X...X..XX..X..................XX...X.XXX.XX...X.XXX.XX.","...X..XX..X...X..XX..X....................XX...X.XXX.XX...X.XXX.XX","..X..XX..X...X..XX..X......................XX...X.XXX.XX...X.XXX.X",".X..XX..X...X..XX..X........................XX...X.XXX.XX...X.XXX.","X..XX..X...X..XX..X..........................XX...X.XXX.XX...X.XXX","..XX..X...X..XX..X............................XX...X.XXX.XX...X.XX",".XX..X...X..XX..X..............................XX...X.XXX.XX...X.X","XX..X...X..XX..X................................XX...X.XXX.XX...X.","X..X...X..XX..X..................................XX...X.XXX.XX...X","..X...X..XX..X....................................XX...X.XXX.XX...",".X...X..XX..X......................................XX...X.XXX.XX..","X...X..XX..X........................................XX...X.XXX.XX.","...X..XX..X..........................................XX...X.XXX.XX","..X..XX..X............................................XX...X.XXX.X",".X..XX..X..............................................XX...X.XXX.","X..XX..X................................................XX...X.XXX","..XX..X..................................................XX...X.XX",".XX..X....................................................XX...X.X","XX..X......................................................XX...X.","X..X........................................................XX...X","..X..........................................................XX...",".X............................................................XX..","X..............................................................XX.","................................................................XX",".................................................................X",".................................................................."};
	 * Reason: Super Long Channel with 60 particles that move slowly
	 */
	@DisplayName("Animation Test 6")
	@Test
	void animationTest6() {
		int speed = 1;
		String init = "LRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRRLRRLL.RLRRR";
		String[] expected = {"XXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXX","..XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XX",".XXXXX..XXXXXXXXX..XXXXXXXXX..XXXXXXXXX..XXXXXXXXX..XXXXXXXXX..X.X","XX..XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX...X.","X..X.XXX..XXXXX.XXX..XXXXX.XXX..XXXXX.XXX..XXXXX.XXX..XXXXX.XX...X","..X...XX.XXX.XXX.XX.XXX.XXX.XX.XXX.XXX.XX.XXX.XXX.XX.XXX.XXX.XX...",".X...X.XXX..X.XXX.XXX..X.XXX.XXX..X.XXX.XXX..X.XXX.XXX..X.XXX.XX..","X...X..XXX.X.X.XXXXXX.X.X.XXXXXX.X.X.XXXXXX.X.X.XXXXXX.X.X.XXX.XX.","...X..XX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX","..X..XX..XXX.X.XXXXXXXX.X.XXXXXXXX.X.XXXXXXXX.X.XXXXXXXX...X.XXX.X",".X..XX..X..XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX...X.XXX.","X..XX..X...XXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXXXXXXX.XXXXX.XX...X.XXX","..XX..X...X..XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX...X.XX",".XX..X...X..XXXXX..XXXXXXXXX..XXXXXXXXX..XXXXXXXXX..X.XXX.XX...X.X","XX..X...X..XX..XX..XX.XXX.XX..XX.XXX.XX..XX.XXX.XX...X.XXX.XX...X.","X..X...X..XX..X.XXX..XXXXX.XXX..XXXXX.XXX..XXXXX.XX...X.XXX.XX...X","..X...X..XX..X...XX.XXX.XXX.XX.XXX.XXX.XX.XXX.XXX.XX...X.XXX.XX...",".X...X..XX..X...X.XXX..X.XXX.XXX..X.XXX.XXX..X.XXX.XX...X.XXX.XX..","X...X..XX..X...X..XXX.X.X.XXXXXX.X.X.XXXXXX.X.X.XXX.XX...X.XXX.XX.","...X..XX..X...X..XX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX","..X..XX..X...X..XX..XXX.X.XXXXXXXX.X.XXXXXXXX...X.XXX.XX...X.XXX.X",".X..XX..X...X..XX..X..XX..XX.XXX.XX..XX.XXX.XX...X.XXX.XX...X.XXX.","X..XX..X...X..XX..X...XXXXX.XXXXXXXXXX.XXXXX.XX...X.XXX.XX...X.XXX","..XX..X...X..XX..X...X..XX..XX.XXX.XX..XX.XXX.XX...X.XXX.XX...X.XX",".XX..X...X..XX..X...X..XXXXX..XXXXXXXXX..X.XXX.XX...X.XXX.XX...X.X","XX..X...X..XX..X...X..XX..XX..XX.XXX.XX...X.XXX.XX...X.XXX.XX...X.","X..X...X..XX..X...X..XX..X.XXX..XXXXX.XX...X.XXX.XX...X.XXX.XX...X","..X...X..XX..X...X..XX..X...XX.XXX.XXX.XX...X.XXX.XX...X.XXX.XX...",".X...X..XX..X...X..XX..X...X.XXX..X.XXX.XX...X.XXX.XX...X.XXX.XX..","X...X..XX..X...X..XX..X...X..XXX.X.X.XXX.XX...X.XXX.XX...X.XXX.XX.","...X..XX..X...X..XX..X...X..XX.XX...X.XXX.XX...X.XXX.XX...X.XXX.XX","..X..XX..X...X..XX..X...X..XX..XXX...X.XXX.XX...X.XXX.XX...X.XXX.X",".X..XX..X...X..XX..X...X..XX..X..XX...X.XXX.XX...X.XXX.XX...X.XXX.","X..XX..X...X..XX..X...X..XX..X....XX...X.XXX.XX...X.XXX.XX...X.XXX","..XX..X...X..XX..X...X..XX..X......XX...X.XXX.XX...X.XXX.XX...X.XX",".XX..X...X..XX..X...X..XX..X........XX...X.XXX.XX...X.XXX.XX...X.X","XX..X...X..XX..X...X..XX..X..........XX...X.XXX.XX...X.XXX.XX...X.","X..X...X..XX..X...X..XX..X............XX...X.XXX.XX...X.XXX.XX...X","..X...X..XX..X...X..XX..X..............XX...X.XXX.XX...X.XXX.XX...",".X...X..XX..X...X..XX..X................XX...X.XXX.XX...X.XXX.XX..","X...X..XX..X...X..XX..X..................XX...X.XXX.XX...X.XXX.XX.","...X..XX..X...X..XX..X....................XX...X.XXX.XX...X.XXX.XX","..X..XX..X...X..XX..X......................XX...X.XXX.XX...X.XXX.X",".X..XX..X...X..XX..X........................XX...X.XXX.XX...X.XXX.","X..XX..X...X..XX..X..........................XX...X.XXX.XX...X.XXX","..XX..X...X..XX..X............................XX...X.XXX.XX...X.XX",".XX..X...X..XX..X..............................XX...X.XXX.XX...X.X","XX..X...X..XX..X................................XX...X.XXX.XX...X.","X..X...X..XX..X..................................XX...X.XXX.XX...X","..X...X..XX..X....................................XX...X.XXX.XX...",".X...X..XX..X......................................XX...X.XXX.XX..","X...X..XX..X........................................XX...X.XXX.XX.","...X..XX..X..........................................XX...X.XXX.XX","..X..XX..X............................................XX...X.XXX.X",".X..XX..X..............................................XX...X.XXX.","X..XX..X................................................XX...X.XXX","..XX..X..................................................XX...X.XX",".XX..X....................................................XX...X.X","XX..X......................................................XX...X.","X..X........................................................XX...X","..X..........................................................XX...",".X............................................................XX..","X..............................................................XX.","................................................................XX",".................................................................X",".................................................................."};
		try {
			String[] actual;
			actual = Channel.animate(speed, init);
			//TODO: I assumed the test comparing the arrays would suffice, 
			//but left this here to see if anyone looked at these tests.  -Denise
			//Uncomment the following two lines to see this show up in the output.  
			//Gson gson = new GsonBuilder().setPrettyPrinting().create();
			//System.out.println(gson.toJson(actual)); // use this to get pretty Array
			assertArrayEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}