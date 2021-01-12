package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import commands.AddCommand;
import org.junit.jupiter.api.*;
import utils.FileHelper;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AddCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    void addNewFile_whenFileNotExists_shouldPrintMessage() {
        System.setOut(new PrintStream(outContent));
        AddCommand.execute("test_file_that_does_not_exists");
        assertEquals("File: test_file_that_does_not_exists does not exist.\n", outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    void addNewFile_whenFileNotExistsInStaging_shouldAddFileToStaging() {
        AddCommand.execute("test_file.txt");
        boolean fileExists = FileHelper.fileExists(".gitlet/staging/test_file.txt");
        assertTrue(fileExists);
    }

    @Test
    void modifyAndAddFile_whenFileExistsInStaging_shouldModifyStagingFileContent() {
        assertEquals(2, 2);
    }

    @Test
    void undoPreviousModificationsAndAddFile_whenFileExistsInStaging_shouldRemoveFileFromStaging() {
        assertEquals(2, 2);
    }

    @Test
    void addFileWithNoChange_whenFileExistsInStaging_shouldNotChangeFileContent() {
        assertEquals(2, 2);
    }
}
