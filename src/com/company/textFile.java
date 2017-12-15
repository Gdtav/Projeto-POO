package com.company;

import java.io.*;

public class textFile {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public void openRead(String name) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(name));
    }

    public void openWrite(String name) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(name));
    }

    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }
    public void writeLine(String line) throws IOException {
        bufferedWriter.write(line,0,line.length());
        bufferedWriter.newLine();
    }

    public void closeRead() throws IOException {
        bufferedReader.close();
    }

    public void closeWrite() throws IOException {
        bufferedWriter.close();
    }
}
