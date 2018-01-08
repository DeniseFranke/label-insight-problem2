package com.denisefranke.solution;
 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

 
public class ParticleTest {
  private Particle particle;
  private int startingLocation;
  private int speed;
  private int time;
  private String direction; //either (L)eft or (R)ight
  
  @BeforeEach
  void init() {
	  particle = new Particle();
  }
    
  @AfterEach
  void tearDown() {
    particle = null;
  }
 
  /**
   * Test 0)  Given:  2, ..R....
   * 		  Returns: "" 
   *          Reason:  This sentence contains every letter at least once
   */
  @DisplayName("TestParticleTest0 - empty")
  @Test
  void testParticleTest0() {
	particle.setSpeed(2);
	particle.setStartingLocation(3);
	particle.setDirection("R");
	time = 0;
    //String init = "..R....";
    //int expected = {"..X....", "....X..","......X","......."};
    int expected = 3;
	int actual = particle.getCurrentLocationGivenTime(time);
    assert(expected == actual);
  
  }
  
 

}