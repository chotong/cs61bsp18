import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testPalindrome(){
        String a = "aba";
        String b = "Aba";
        String c = "a";
        String d = "ab";
        String e = "";
        assertEquals(true, palindrome.isPalindrome(a));
        assertEquals(false, palindrome.isPalindrome(b));
        assertEquals(true, palindrome.isPalindrome(c));
        assertEquals(false, palindrome.isPalindrome(d));
        assertEquals(true,palindrome.isPalindrome(e));
    }



}
