import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offBy5 = new OffByN(5);
    @Test
    public void testDifference() {

        assertEquals(true,offBy5.equalChars('a', 'f'));
        assertEquals(true,offBy5.equalChars('f', 'a'));
        assertEquals(false,offBy5.equalChars('f', 'h'));
    }
}
