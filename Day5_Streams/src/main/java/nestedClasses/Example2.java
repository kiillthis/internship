package nestedClasses;

public class Example2 {
    public int pubOutVar;

    private int prOutVar;

    public Example2() {
    }

    static class Nested2 {
        public static int pub_innVar;

        public Nested2() {
        }

        int getOuterPublicVariable()
        {
           // return Outer2.this.pubOutVar; // ошибка
           // return Outer2.pubOutVar; // ошибка
            return 0;
        }

        int getOuterPrivateVariable()
        {
           // return Outer2.this.prOutVar; // ошибка
           // return Outer2.prOutVar; // ошибка
            return 0;
        }
    }
}
