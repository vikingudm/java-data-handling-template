package com.epam.izh.rd.online;

import com.epam.izh.rd.online.repository.FileRepository;
import com.epam.izh.rd.online.repository.SimpleFileRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileRepositoryTest {

    private static final String TEST_DIR_COUNT_PATH = "testDirCountFiles";
    private static final String TEST_DIR_CREATE_PATH = "testDirCreateFile";
    private static final String TEST_FILE_TO_CREATE = "newFile.txt";

    private static FileRepository fileRepository;

    @BeforeAll
    static void setup() {
        fileRepository = new SimpleFileRepository();
    }

    @BeforeEach
    void clean() {
        File file = getFile(TEST_DIR_CREATE_PATH + "/" + TEST_FILE_TO_CREATE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    @DisplayName("Тест метода FileRepository.countDirsInDirectory(String path)")
    void testCountDirsInDirectory() throws IOException {
        assertEquals(7, fileRepository.countDirsInDirectory(TEST_DIR_COUNT_PATH));
    }

    @Test
    @DisplayName("Тест метода FileRepository.countFilesInDirectory(String path)")
    void testCountFilesInDirectory() throws IOException {
        assertEquals(10, fileRepository.countFilesInDirectory(TEST_DIR_COUNT_PATH));
    }

    @Test
    @DisplayName("Тест метода FileRepository.createFile(String path)")
    void testCreateFile() throws IOException {
        fileRepository.createFile(TEST_DIR_CREATE_PATH, TEST_FILE_TO_CREATE);

        assertTrue(getFile(TEST_DIR_CREATE_PATH + "/" + TEST_FILE_TO_CREATE).exists());
    }

    @Test
    @DisplayName("Тест метода FileRepository.readFileFromResources(String fileName)")
    void testReadFileFromResources() throws IOException {
        assertEquals("Ya-hoo!", fileRepository.readFileFromResources("readme.txt"));
    }


    private File getFile(String path) {
        File file = new File("src/main/resources/" + path);
        if (file.exists()) {
            return file;
        }
        return new File("");
    }
}
