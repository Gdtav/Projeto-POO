package com.company;

import java.io.*;

public class ObjectFile {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public void openRead(String name) throws IOException{
        objectInputStream = new ObjectInputStream(new FileInputStream(name));
    }

    public void openWrite(String name) throws IOException{
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(name));
    }

    public Object readObject() throws IOException, ClassNotFoundException {
        return objectInputStream.readObject();
    }

    public void writeObject(Object o) throws IOException{
        objectOutputStream.writeObject(o);
    }

    public void closeRead() throws IOException {
        objectInputStream.close();
    }

    public ObjectFile() {
    }

    public void closeWrite() throws IOException{
        objectOutputStream.close();

    }
}
