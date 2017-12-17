package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type Text file.
 */
class textFile {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    /**
     * Open for read.
     *
     * @param name the name
     * @throws IOException the io exception
     */
    public void openRead(String name) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(name));
    }

    /**
     * Read line from file.
     *
     * @return the string
     * @throws IOException the io exception
     */
    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    /**
     * Close for read.
     *
     * @throws IOException the io exception
     */
    public void closeRead() throws IOException {
        bufferedReader.close();
    }

}
