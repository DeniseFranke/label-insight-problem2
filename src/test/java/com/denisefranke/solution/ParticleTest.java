package com.denisefranke.solution;

import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * ParticleTest - This tests the Particle pojo
 * 
 * @author Denise Franke
 *
 */
public class ParticleTest {
	private Particle particle;

	@BeforeEach
	void init() {
	}

	@AfterEach
	void tearDown() {
		particle = null;
	}

	/**
	 * Test 0)   Given:  A Particle instantiated with 2, ..L.... Returns: The
	 * particle's location along the channel at time t If the particle has exited
	 * the channel, it returns a null when queried.
	 */
	@DisplayName("Particle Test 0 - Time Change")
	@Test
	void particleTest0() {
		particle = new Particle(2, 'R', 2);
		Integer expected = 2; // time 0
		Integer actual = particle.getCurrentLocationGivenTime(0, 7);
		assert (expected == actual);
		expected = 4; // time 1
		actual = particle.getCurrentLocationGivenTime(1, 7);
		assert (expected == actual);
		expected = 6; // time 2
		actual = particle.getCurrentLocationGivenTime(2, 7);
		assert (expected == actual);
		expected = null; // time 3
		actual = particle.getCurrentLocationGivenTime(3, 7);
		assertNull(actual);
	}

	/**
	 * Test 1)  Test left Given:  2, ..L....
	 * 
	 */
	@DisplayName("Particle Test 1 - Direction Change ")
	@Test
	void particleTest1() {
		particle = new Particle(2, 'L', 2);
		Integer expected = 2; // {"..X....", ".......", "......."};
		Integer actual = particle.getCurrentLocationGivenTime(0, 7);
		assert (expected == actual);
		expected = 0;
		actual = particle.getCurrentLocationGivenTime(1, 7);
		assert (expected == actual);
		expected = null;
		actual = particle.getCurrentLocationGivenTime(2, 7);
		assertNull(actual);
		expected = null;
		actual = particle.getCurrentLocationGivenTime(3, 7);
		assertNull(actual);
	}

	/**
	 * Test 2)  Test Right with minimal (1) change in time Given:  1, ..R....
	 * 
	 */
	@DisplayName("TestParticleTest2 - SpeedChange")
	@Test
	void testParticleTest2() {
		particle = new Particle(1, 'R', 2);
		Integer expected = 2; // {"..X....","...X...","....X..",".....X.","......X","......."};
		Integer actual = particle.getCurrentLocationGivenTime(0, 7);
		assert (expected == actual);
		expected = 3;
		actual = particle.getCurrentLocationGivenTime(1, 7);
		assert (expected == actual);
		expected = 4;
		actual = particle.getCurrentLocationGivenTime(2, 7);
		assert (expected == actual);
		expected = 5;
		actual = particle.getCurrentLocationGivenTime(3, 7);
		assert (expected == actual);
		expected = 6;
		actual = particle.getCurrentLocationGivenTime(4, 7);
		assert (expected == actual);
		expected = null;
		actual = particle.getCurrentLocationGivenTime(5, 7);
		assertNull(actual);
	}

	/**
	 * Test 3)  Test left when particle's location is at the minimal boundary
	 * Given:  1, L......
	 * 
	 */
	@DisplayName("TestParticleTest3 - Speed change with left starting at 1")
	@Test
	void testParticleTest3() {
		particle = new Particle(2, 'L', 0);
		Integer expected = 0; // {"X......", "......."};
		Integer actual = particle.getCurrentLocationGivenTime(0, 7);
		assert (expected == actual);
		expected = null;
		actual = particle.getCurrentLocationGivenTime(1, 7);
		assertNull(actual);
	}

	/**
	 * Test 4)  Test right when particle's location is at the maximal boundary  
	 * Given:  1, ......R
	 * 
	 */
	@DisplayName("TestParticleTest4 - Speed change with right starting at 7")
	@Test
	void testParticleTest4() {
		particle = new Particle(1, 'R', 6);
		Integer expected = 6; // {"......X", "......."};
		Integer actual = particle.getCurrentLocationGivenTime(0, 7);
		assert (expected == actual);
		expected = null;
		actual = particle.getCurrentLocationGivenTime(1, 7);
		assertNull(actual);
	}

}