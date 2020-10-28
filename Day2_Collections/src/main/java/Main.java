import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CustomLinkList<Integer> l = new CustomLinkList<Integer>();

        l.insert(10);
        l.insert(20);
        l.insert(30);
        l.insert(40);

        l.add(3,8);
        l.add(4,8);
        l.add(5,8);

        CustomArrayList<Integer> al = new CustomArrayList<Integer>();

        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        al.add(2, 35);
        al.add(2, 89);
        al.add(2, 116);
        al.add(2, 2456);

        System.out.println(al);
    }
}
