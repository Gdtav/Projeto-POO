package com.company;

import java.io.*;

/**
 * The type Text file.
 */
public class textFile {
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
     * Open for write.
     *
     * @param name the name
     * @throws IOException the io exception
     */
    public void openWrite(String name) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(name));
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
     * Write line.
     *
     * @param line the line
     * @throws IOException the io exception
     */
    public void writeLine(String line) throws IOException {
        bufferedWriter.write(line,0,line.length());
        bufferedWriter.newLine();
    }

    /**
     * Close for read.
     *
     * @throws IOException the io exception
     */
    public void closeRead() throws IOException {
        bufferedReader.close();
    }

    /**
     * Close for write.
     *
     * @throws IOException the io exception
     */
    public void closeWrite() throws IOException {
        bufferedWriter.close();
    }
}
