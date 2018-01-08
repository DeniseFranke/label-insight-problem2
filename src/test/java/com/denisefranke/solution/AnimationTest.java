package com.denisefranke.solution;
 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
public class AnimationTest {
  private Animation animation;
  
  @BeforeEach
  void init() {
	  animation = new Animation();
  }
    
  @AfterEach
  void tearDown() {
    animation = null;
  }
 
  /**
   * TestAnimationTest0:
   * Given:  2, ..R....
   * Returns: "" 
   * Reason:  This sentence contains every letter at least once
 * @throws Exception 
   */
  @DisplayName("TestAnimationTest0")
  @Test
  void testAnimationTest0() throws Exception {
    int speed = 2;
    String init = "..R....";
    String[] expected = {"..X....", "....X..","......X","......."};
	assertEquals(expected, animation.animate(speed,init));
	
    
  }
  /**
    1)  3,  "RR..LRL"
    Returns:
      { "XX..XXX",
        ".X.XX..",
        "X.....X",
        "......." }
    Note that, at the first time step after init, there are actually 4 particles in the chamber,
    but two are passing through each other at the 4th position
    2)  2,  "LRLR.LRLR"
    Returns:
      { "XXXX.XXXX",
        "X..X.X..X",
        ".X.X.X.X.",
        ".X.....X.",
        "........." }
    At time 0 (init) there are 8 particles. At time 1, there are still 6 particles, but only 4
    positions are occupied since particles are passing through each other.
    3)  10,  "RLRLRLRLRL"
    Returns:
  { "XXXXXXXXXX",
    ".........." }
These particles are moving so fast that they all exit the chamber by time 1.
4)  1,  "..."
Returns:
  { "..." }
5)  1,  "LRRL.LR.LRR.R.LRRL."
Returns:
  { "XXXX.XX.XXX.X.XXXX.",
    "..XXX..X..XX.X..XX.",
    ".X.XX.X.X..XX.XX.XX",
    "X.X.XX...X.XXXXX..X",
    ".X..XXX...X..XX.X..",
    "X..X..XX.X.XX.XX.X.",
    "..X....XX..XX..XX.X",
    ".X.....XXXX..X..XX.",
    "X.....X..XX...X..XX",
    ".....X..X.XX...X..X",
    "....X..X...XX...X..",
    "...X..X.....XX...X.",
    "..X..X.......XX...X",
    ".X..X.........XX...",
    "X..X...........XX..",
    "..X.............XX.",
    ".X...............XX",
    "X.................X",
   "..................." }
   **/ 
 

}