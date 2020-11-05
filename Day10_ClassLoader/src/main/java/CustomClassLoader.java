import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CustomClassLoader extends ClassLoader {
    private HashMap<String, Class<?>> cache = new HashMap<String, Class<?>>();

    private String jarFileName;

    private String packageName;

    private static String WARNING = "Warning : No jar file found. Packet unmarshalling won't be possible." +
            "Please verify your classpath.";

    public CustomClassLoader(String jarFileName, String packageName) {
        this.jarFileName = jarFileName;
        this.packageName = packageName;

        cacheClasses();
    }

    private void cacheClasses() {
        try {
            JarFile jarFile = new JarFile(jarFileName);

            Enumeration entries = jarFile.entries();

            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();

                if (match(normalize(jarEntry.getName()), packageName)) {
                    byte[] classData = loadClassData(jarFile, jarEntry);
                    if(classData != null) {
                        Class<?> cluzz = defineClass(stripClassName(normalize(jarEntry.getName())), classData, 0, classData.length);
                        cache.put(cluzz.getName(), cluzz);
                        System.out.println("== class " + cluzz.getName() + " loaded in cache");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(WARNING);
        }
    }

    public synchronized Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> result = cache.get(name);

        if (result == null) {
            result = cache.get(packageName + "." + name);
        }

        if(result == null) {
            result = super.findSystemClass(name);
        }

        System.out.println("== loadClass(" + name + ")");

        return result;
    }

    private boolean match(String className, String packageName) {
        return className.startsWith(packageName) && className.endsWith(".class");
    }

    private String normalize(String className) {
        return className.replace('/', '.');
    }

    private String stripClassName(String className) {
        return className.substring(0, className.length() - 6);
    }

    private byte[] loadClassData(JarFile jarFile, JarEntry jarEntry) throws IOException {
        long size = jarEntry.getSize();

        if (size == -1 || size == 0) {
            return null;
        }

        byte[] data = new byte[(int) size];
        InputStream in = jarFile.getInputStream(jarEntry);
        in.read(data);

        return data;
    }

}
