import static org.junit.Assert.*;

import org.junit.Test;


public class CourseJunitTest {
	
	Course c1 = new Course("M", "08:30", 50, "am");
	Course c2 = new Course("M", "09:30", 50, "am");
	Course c3 = new Course("W", "08:30", 75, "am");
	Course c4 = new Course("W", "09:30", 75, "am");
 	
	@Test
	public void testOverlap() {
		assertEquals(false, c1.Overlap(c2));
		assertEquals(true, c3.Overlap(c4));
	}

}
