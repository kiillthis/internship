import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        CustomImmutablePerson person = new CustomImmutablePerson("Andrew", 20, "Java developer");

        person.doWork();
        person.haveARest();
        person.sleep();

        MyTreeSet<String> tree = new MyTreeSet<String>();

        tree.insert(1, "Andrew");
        tree.insert(2, "Alisa");
        tree.insert(3, "Bob");

        System.out.println(tree.find(2));

        TreeSet<Integer> kek = new TreeSet<Integer>();

        kek.add(1);
        kek.add(4);
        kek.add(2);
        kek.add(19);
        kek.add(7);

        System.out.println(kek);
    }
}
