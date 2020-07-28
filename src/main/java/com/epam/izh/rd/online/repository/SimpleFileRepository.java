package com.epam.izh.rd.online.repository;

import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Files;

public class SimpleFileRepository implements FileRepository {

    @Override
    public long countFilesInDirectory(String path) throws UnsupportedEncodingException {
        long count = 0;
        File dir = new File(URLDecoder.decode(getClass().getClassLoader().getResource(path).getFile(), "UTF-8"));
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                count++;
            } else {
                count += countFilesInDirectory(file.getPath().replace(file.getParent(), path));
            }
        }
        return count;
    }

    @Override
    public long countDirsInDirectory(String path) throws UnsupportedEncodingException {
        long count = 1;
        File file = new File(URLDecoder.decode(getClass().getClassLoader().getResource(path).getFile(), "UTF-8"));
        for (File dir : file.listFiles()) {
            if (dir.isDirectory()) {
                count += countDirsInDirectory(dir.getPath().replace(dir.getParent(), path));
            }
        }
        return count;
    }

    @Override
    public void copyTXTFiles(String from, String to) throws IOException {
        if (from.endsWith(".txt")) {
            Files.copy(new File(from).toPath(), new File(to).toPath());
        }
    }

    @Override
    public boolean createFile(String path, String name) throws IOException {
        return new File("src/main/resources/" + path + "/" + name).createNewFile();
    }

    @Override
    public String readFileFromResources(String fileName) throws IOException {
        return new BufferedReader(new FileReader("src/main/resources/" + fileName)).readLine();
    }
}
