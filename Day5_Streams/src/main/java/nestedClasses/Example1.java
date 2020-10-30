package nestedClasses;

public class Example1 {
    private static int iPrivVar;

    class Inner {
        private int kek;
        void setPrivOfA(int a) {
            Example1.iPrivVar = a;
        }
    }
}
