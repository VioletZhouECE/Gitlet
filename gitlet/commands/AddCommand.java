package commands;

import utils.FileUtils;
import utils.HashUtils;

import java.io.IOException;

public class AddCommand {
    /*
        Check if the file exists
        If the current working version of the file is identical to the version in the current commit, remove it from the staging area if it exists
        otherwise add it to staging.
    */
    public static void execute(String arg1, String arg2) {
        try{
            String filename = arg2;
            if (!FileUtils.fileExists(filename)){
                System.out.println("File: " + filename + " does not exist.");
                return;
            }

            String stagingFileHash = HashUtils.hashFile(filename);
            String currentCommmitId = "commitid";
            String commitFilePath = ".gitlet/commits/commitid/" + filename;

            if (FileUtils.fileExists(commitFilePath)) {
                String commitFileHash = HashUtils.hashFile(commitFilePath);
                //if versions are identical
                if (commitFileHash.equals(stagingFileHash)){
                    //remove file from staging if it exists
                    String stagingFilePath = ".gitlet/staging/" + filename;
                    if (FileUtils.fileExists(stagingFilePath)) {
                        FileUtils.removeFile(stagingFilePath);
                    }
                    return;
                };
            }

            //add the file to staging
            FileUtils.addFileToStaging("test_file.txt", stagingFileHash);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
