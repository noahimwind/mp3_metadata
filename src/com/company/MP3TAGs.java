package com.company;

import java.io.*;

public class MP3TAGs {
    // Die Meta-Informationen einer mp3-Datei sind in den letzten 128 Byte – dem sog. ID3v1-Tag
    //String path = "C:\\Users\\noah.duerkes\\Documents\\SWD_CD\\m1";
    File x = new File("C:\\Users\\noah.duerkes\\Documents\\SWD_CD\\m1.mp3");
    RandomAccessFile raf = null;


    public MP3TAGs() throws FileNotFoundException {
        raf = new RandomAccessFile(x, "r");
    }

    public void auslesen() throws IOException {
        System.out.println(x.length()); //  Länge der MP3 Datei
        raf.seek(x.length() - 128); // Pointer an Anfang der Metadaten setzen

        raf.skipBytes(3);   // "TAG" überspringen

        System.out.println(raf.readLine());
        raf.close();
    }
}
