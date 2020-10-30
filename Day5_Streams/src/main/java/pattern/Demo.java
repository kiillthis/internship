package pattern;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/Users/killthis/Documents/Java/war.txt"));
        editor.events.unsubscribe("save", new EmailNotificationListener("kek@gmail.com"));

        try {
            editor.openFile("/Users/killthis/Documents/Java/test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
