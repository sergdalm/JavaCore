package src.main.java.com.sergdalm.javacore.chapter20;

// Directory of .HTML files.
import java.io.*;

class OnlyExt implements FilenameFilter {
    String ext;

    public OnlyExt(String ext) {
        this.ext = "." + ext;
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

public class DirListOnly {
    public static void main(String[] args) {
        String dirname = "out/production/JavaCore/src/main/java/com/sergdalm/javacore/chapter20";
        File f1 = new File(dirname);
        FilenameFilter only = new OnlyExt("class");
        String[] s = f1.list(only);

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
