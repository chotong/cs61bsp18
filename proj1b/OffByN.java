public class OffByN implements CharacterComparator{
    private int num;

    OffByN(int N){
        num = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == num) return true;
        else return false;
    }
}