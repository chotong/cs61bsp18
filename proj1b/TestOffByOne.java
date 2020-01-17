import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    @Test
    public void testDifference() {
        boolean a = offByOne.equalChars('a','b');
        boolean b = offByOne.equalChars('b','a');
        boolean c = offByOne.equalChars('A','a');
        assertEquals(true,a);
        assertEquals(true,b);
        assertEquals(false,c);
    }

}
