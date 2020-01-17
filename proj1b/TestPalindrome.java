import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();
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

    @Test
    public void testPalindrome2(){
        String a = "flake";
        String b = "a";
        String c = "Aa";
        String d = "";
        assertEquals(true, palindrome.isPalindrome(a,offByOne));
        assertEquals(true, palindrome.isPalindrome(b,offByOne));
        assertEquals(false, palindrome.isPalindrome(c,offByOne));
        assertEquals(true,palindrome.isPalindrome(d,offByOne));
    }
}
