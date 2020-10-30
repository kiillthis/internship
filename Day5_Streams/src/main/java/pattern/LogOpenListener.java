package pattern;

import java.io.File;

public class LogOpenListener implements EventListener {
    private File log;

    public LogOpenListener(String path) {
        this.log = new File(path);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + log + ": Someone has perfomed "
                + eventType + " operation with the following file: "
                + file.getName());
    }
}
