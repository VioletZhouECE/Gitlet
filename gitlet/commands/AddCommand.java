package commands;

import utils.FileHelper;
import utils.HashHelper;

import java.io.IOException;

public class AddCommand {
    /**
     * Check if the file exists
     * If the current working version of the file is identical to the version in the current commit, remove it from the staging area if it exists
     * otherwise add it to staging.
     */
    public static void execute(String arg2) {
        try{
            String filename = arg2;
            if (!FileHelper.fileExists(filename)){
                System.out.println("File: " + filename + " does not exist.");
                return;
            }

            String stagingFileHash = HashHelper.hashFile(filename);
            String commitFilePath = ".gitlet/commits/commitid/" + filename;

            if (FileHelper.fileExists(commitFilePath)) {
                String commitFileHash = HashHelper.hashFile(commitFilePath);
                //if versions are identical
                if (commitFileHash.equals(stagingFileHash)){
                    //remove file from staging if it exists
                    String stagingFilePath = ".gitlet/staging/" + filename;
                    if (FileHelper.fileExists(stagingFilePath)) {
                        FileHelper.removeFile(stagingFilePath);
                    }
                    return;
                };
            }

            //add the file to staging
            FileHelper.addFileToStaging("test_file.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
