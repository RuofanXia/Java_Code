import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;


public class HamcrestTest {
	
	Course c1 = new Course("M", "05:30", 75, "pm");
	Course c2 = new Course("M", "04:20", 75, "pm");
	Course c6 = new Course("M", "05:40", 75, "pm");
	Course c3 = new Course("F", "12:20", 75, "am");
	Course c4 = new Course("F", "01:40", 75, "pm");
	Course c5 = new Course("F", "01:20", 75, "pm");
	
 	@Test
	public void testObject() {
		assertThat(true, equalTo(c1.Overlap(c2)));
		assertThat(false, equalTo(c2.Overlap(c6)));
	}
 	
 	@Test
 	public void testCore(){
 		assertThat(false, is(c1.Overlap(c3)));
 		assertThat(true, is(c1.Overlap(c2)));
 	}
 	
 	@Test
 	public void testLogical(){
 		assertThat(true, not(c3.Overlap(c4)));
 		assertThat(false, not(c3.Overlap(c5)));
 	}
}
