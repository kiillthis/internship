import java.util.ArrayList;
import java.util.LinkedList;

public class FillingService {
    public FillingService() {
    }

    public LinkedList<Integer> getLinkedList() {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < 1000000; i++) {
            list.add((int) (Math.random() * 100));
        }

        return list;
    }

    public ArrayList<Integer> getArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 1000000; i++) {
            list.add((int) (Math.random() * 100));
        }

        return list;
    }

    public CustomLinkList<Integer> getLinkedListCustom() {
        CustomLinkList<Integer> list = new CustomLinkList<Integer>();

        for (int i = 0; i < 1000000; i++) {
            list.insertHead((int) (Math.random() * 100));
        }

        return list;
    }

    public CustomArrayList<Integer> getArrayListCustom() {
        CustomArrayList<Integer> list = new CustomArrayList<Integer>();

        for (int i = 0; i < 1000000; i++) {
            list.add((int) (Math.random() * 100));
        }

        return list;
    }

}
