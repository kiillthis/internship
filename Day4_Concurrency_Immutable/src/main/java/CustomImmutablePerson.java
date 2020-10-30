public final class CustomImmutablePerson {
    private final String name;
    private final int age;
    private final String work;

    public CustomImmutablePerson(String name, int age, String work) {
        this.name = name;
        this.age = age;
        this.work = work;
    }

    public final void doWork() {
        System.out.println("Doing work...");
    }

    public final void sleep() {
        System.out.println("Sleeping...");
    }

    public final void haveARest() {
        System.out.println("Having a have...");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWork() {
        return work;
    }
}
