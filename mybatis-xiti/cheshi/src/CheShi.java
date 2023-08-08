public class CheShi {
    public static void main(String[] args) {
        String str = "";
        for (int s = 0; s < 5; s++) {
            str = str + (char) (Math.random() * 26 + 'a');
        }
        System.out.println(str);
    }
}
