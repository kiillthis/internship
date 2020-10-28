import dnl.utils.text.table.TextTable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

class LinkedListVsArrayList {

    FillingService fs = new FillingService();
    ArrayList<Integer> arrayList = fs.getArrayList();
    LinkedList<Integer> linkedList = fs.getLinkedList();

    CustomArrayList<Integer> arrayListCustom = fs.getArrayListCustom();
    CustomLinkList<Integer> linkedListCustom = fs.getLinkedListCustom();

    int randomInt = (int) (Math.random() * 10);

    @Test
    public void compare() {
        int mid = 1000000 / 2;

        long start;
        long end;

        int iterationInt = 10;
        int position = 0;

        String[] columnNames = {"Iteration","ArrayList", "LinkedList"};

        Object[][] data = new Object[10][1];

        for (int i = 0; i < 100000; i++) {

            start = System.nanoTime();
            arrayList.add(mid, randomInt);
            end = System.nanoTime() - start;

            String end1 = String.valueOf(end);

            start = System.nanoTime();
            linkedList.add(mid, randomInt);
            end = System.nanoTime() - start;

            String end2 = String.valueOf(end);

            mid++;
            if(i == iterationInt || i == 99999){
                data[position] = new Object[]{iterationInt, end1, end2};
                iterationInt = iterationInt * 10;
                position++;
            }
        }

        TextTable tt = new TextTable(columnNames, data);
        tt.getTableModel();
        tt.printTable();
    }

    @Test
    public void compareCustom() {
        int mid = 1000000 / 2;

        long start;
        long end;

        int iterationInt = 10;
        int position = 0;

        String[] columnNames = {"Iteration","ArrayList", "LinkedList"};

        Object[][] data = new Object[10][1];

        for (int i = 0; i < 100000; i++) {

            start = System.nanoTime();
            arrayListCustom.add(mid, randomInt);
            end = System.nanoTime() - start;

            String end1 = String.valueOf(end);

            start = System.nanoTime();
            linkedListCustom.add(mid, randomInt);
            end = System.nanoTime() - start;

            String end2 = String.valueOf(end);

            mid++;
            if(i == iterationInt || i == 99999){
                data[position] = new Object[]{iterationInt, end1, end2};
                iterationInt = iterationInt * 10;
                position++;
            }

        }

        TextTable tt = new TextTable(columnNames, data);
        tt.getTableModel();
        tt.printTable();
    }
}