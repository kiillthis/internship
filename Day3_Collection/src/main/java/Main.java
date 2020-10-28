public class Main {

    public static void main(String[] args) {
        String s = "asdfgh";

        StringBuilder sb = new StringBuilder(s);

        sb.delete(0,1);

        System.out.println(sb.toString());
    }
}
