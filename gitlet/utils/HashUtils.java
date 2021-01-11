package utils;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HashUtils {
    //hash file in current directory
    public static String hashFile(String filename) throws IOException {
        String filepath = FileUtils.getFilePathInCurrentDir(filename);
        Path path = Path.of(filepath);
        String str = Files.readString(path);
        String sha256hex = DigestUtils.sha256Hex(str);
        return sha256hex;
    }

    public static String hashCommit(String filepath) throws IOException {
        return "to be implemented";
    }
}
