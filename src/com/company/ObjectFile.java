package com.company;

import java.io.*;

/**
 * The type Object file.
 */
class ObjectFile {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    /**
     * Instantiates a new Object file.
     */
    public ObjectFile() {
    }

    /**
     * Open for read.
     *
     * @param name the name
     * @throws IOException the io exception
     */
    public void openRead(String name) throws IOException {
        objectInputStream = new ObjectInputStream(new FileInputStream(name));
    }

    /**
     * Open for write.
     *
     * @param name the name
     * @throws IOException the io exception
     */
    public void openWrite(String name) throws IOException {
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(name));
    }

    /**
     * Read object from file.
     *
     * @return the object
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public Object readObject() throws IOException, ClassNotFoundException {
        return objectInputStream.readObject();
    }

    /**
     * Write object.
     *
     * @param o the o
     * @throws IOException the io exception
     */
    public void writeObject(Object o) throws IOException {
        objectOutputStream.writeObject(o);
    }

    /**
     * Close for read.
     *
     * @throws IOException the io exception
     */
    public void closeRead() throws IOException {
        objectInputStream.close();
    }

    /**
     * Close for write.
     *
     * @throws IOException the io exception
     */
    public void closeWrite() throws IOException {
        objectOutputStream.close();

    }
}
