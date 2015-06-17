import java.io.*;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ruben on 15/06/15.
 */
public class FileHandler {

    public static List<File> getPDFilesPaths(String target) {
        File targetDirectory = new File(target);
        String rootPath = targetDirectory.getAbsolutePath() + "/";
        List<String> files = Arrays.asList(targetDirectory.list((dir, name) -> name.substring(name.length() - 3).equalsIgnoreCase("pdf")));

        return files.stream().map((file) -> new File(rootPath + file)).collect(toList());
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
