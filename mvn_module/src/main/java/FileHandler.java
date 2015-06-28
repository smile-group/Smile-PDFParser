import com.google.common.io.PatternFilenameFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ruben on 15/06/15.
 */
public class FileHandler {

    public static List<File> getPDFilesPaths(String target) {
        List<File> files = new ArrayList<>();
        try {
            files = Files.walk(Paths.get(target))
                         .map(Path::toFile)
                         .filter(s -> s.getName().endsWith("pdf") || s.getName().endsWith("PDF"))
                         .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return files;
    }

    public static void writeStringIntoFile(String fileName, String content) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        assert writer != null;
        writer.write(content);
        writer.close();
    }
}
