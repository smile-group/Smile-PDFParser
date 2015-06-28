import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ruben on 16/06/15.
 */
public class SMILEPDFParser {

    public static void parseAllPDFsFromSourcePathToTarget(String source, String target) {
        List<File> fileList = FileHandler.getPDFilesPaths(source);

        fileList.stream().forEach(filePath -> {
            String dest = target + filePath.getName().substring(0, filePath.getName().length() - 3) + "txt";
            String content = parseFileWithTika(filePath);
            FileHandler.writeStringIntoFile(dest, content);
        });
    }

    public static String parseFileWithTika(File file) {
        Tika apacheTikaParser = new Tika();
        String content = null;
        try {
            content = apacheTikaParser.parseToString(file);
        } catch (IOException | TikaException e) {
            e.printStackTrace();
        }
        return content;
    }
}
