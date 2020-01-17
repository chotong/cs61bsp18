public class Palindrome{
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for(int i =0; i<word.length();i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque d = wordToDeque(word);
        while(d.size()>1) {
            if(d.removeFirst() != d.removeLast()){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque d = wordToDeque(word);
        while(d.size()>1) {
            char a = (char) d.removeFirst();
            char b = (char) d.removeLast();
            if(!cc.equalChars(a,b)){
                return false;
            }
        }
        return true;
    }
}

