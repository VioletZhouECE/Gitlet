package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.apache.commons.io.FileUtils;

public class FileHelper {

    public static boolean fileExists(String filepath){
        File f = new File(filepath);
        return f.isFile();
    }

    public static void removeFile(String filepath){
        File f = new File(filepath);
        f.delete();
    }

    public static void addFileToStaging(String filename) throws IOException {
        String source = getFilePathInCurrentDir(filename);
        Path sourcePath = Path.of(source);
        String target = ".gitlet/staging/";
        Path targetPath = Path.of(target);
        Files.copy(targetPath, sourcePath, StandardCopyOption.REPLACE_EXISTING);
    }

    public static String getFilePathInCurrentDir(String filename){
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File f = new File(currentDirectory, filename);
        return f.getAbsolutePath();
    }

    public static boolean isFileIdentical(String filepath1, String filepath2){
        return true;
    }
}
