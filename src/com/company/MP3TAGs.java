package com.company;
// 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
import java.io.*;

public class MP3TAGs {
    // Die Meta-Informationen einer mp3-Datei sind in den letzten 128 Byte – dem sog. ID3v1-Tag
    //String path = "C:\\Users\\noah.duerkes\\Documents\\SWD_CD\\m1";
    File x = new File("C:\\Users\\noah.duerkes\\Documents\\SWD_CD\\m1.mp3");  //ATIW Rechner
//    File x = new File("C:\\Users\\noahd\\Documents\\SWD\\m1.mp3");  //Laptop
//    File g = new File("C:\\Users\\noahd\\Documents\\SWD\\genres.txt");  //File 2 Laptop
    RandomAccessFile raf = null;
    String header;  // 3 Byte
    String title;   // 30 Byte
    String artist;  // 30 Byte
    String album;   // 30 Byte
    int year;       // 4 Byte
    String comment; // 30 Byte
    byte genre;     // 1 Byte
    long metastart = x.length() - 128;


    public MP3TAGs() throws FileNotFoundException {
        raf = new RandomAccessFile(x, "r");
        String header = "";
        String title = "";
        String artist = "";
        String album = "";
        int year = 0;
        String comment = "";
        byte genre = 0;
    }

    public void auslesen() throws IOException {
        this.header = this.rangeReader(metastart, 3);
        this.title = this.rangeReader(metastart + 3, 30);
        this.artist = this.rangeReader(metastart + 33, 30);
        this.album = this.rangeReader(metastart + 63, 30);
        this.year = Integer.parseInt(this.rangeReader(metastart + 93, 4));
        this.comment = this.rangeReader(metastart + 97, 30);
        this.genre = this.readGenre();
    }

    public String rangeReader(long start, int range) throws IOException {
        raf = new RandomAccessFile(x, "r");
        String x = "";
        raf.seek(start);
        for (int i = 0; i < range; i++){
            x += (char)raf.readByte();
        }
        raf.close();
        return x;
    }

    public byte readGenre() throws IOException {
        raf = new RandomAccessFile(x, "r");
        raf.seek(metastart + 127);
        return raf.readByte();
    }

    public void genreName() throws FileNotFoundException {
        // genre name aus csv Datei g
    }

    @Override
    public String toString() {
        return "MP3TAGs{" +
                "header='" + header + '\'' +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                "\n, album='" + album + '\'' +
                ", year=" + year +
                ", comment='" + comment + '\'' +
                ", genre=" + genre +
                '}';
    }

    // NOTES -----------------------------------------------------------------------------------------------------------
    // String x = new String(bf); -> bf = bytefeld [wandelt ein eindimensionales Byte Array in einen String um]
}
