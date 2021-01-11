package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileUtils {

    public static boolean fileExists(String filepath){
        return getFileFromCurrentDir(filepath).isFile();
    }

    public static void removeFile(String filepath){
        File f = getFileFromCurrentDir(filepath);
        f.delete();
    }

    public static void addFileToStaging(String filename, String stagingFilename) throws IOException {
        String source = getFilePathInCurrentDir(filename);
        Path sourcePath = Path.of(source);
        String target = ".gitlet/staging/" + stagingFilename;
        Path targetPath = Path.of(target);
        Files.copy(targetPath, sourcePath, StandardCopyOption.REPLACE_EXISTING);
    }

    public static File getFileFromCurrentDir(String filename){
        String filepath = getFilePathInCurrentDir(filename);
        File f = new File(filepath);
        return f;
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
