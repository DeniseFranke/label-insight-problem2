package com.denisefranke.solution;
 
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
 
public class ChannelTest {
  private Channel channel;
  private List<Particle> particles;
  private int positions = 0;
  
  @BeforeEach
  void init() {
	  channel= new Channel();
  }
    
  @AfterEach
  void tearDown() {
    channel = null;
  }
  
  /**
   * Test 0)  Check exceptions
   * 		  Returns: Return Exception 
   *          Reason: If positions passed <= 0 or >50 won't work.
   * @throws Exception 
   */
  @Rule
  public final ExpectedException exception = ExpectedException.none() ;
  @DisplayName("ChannelTest0 - 0 or null")
  @Test
  public void testChannelTest0() {
    exception.expect(Exception.class);
    try {
		channel.setPositions(-5);
	} catch (Exception expectedException) {
		// Do Nothing
	}
  }
  
 

}