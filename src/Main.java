/* Main.java */
import java.util.*;
import java.lang.*;
import java.io.*;
/* this application starts two threads, one File_Readerthread, which reads from the file
and stores the objects into the linked list (Vector), and another File_WriterThread which
reads from the file and stores in to another file Data */
public class Main
{
    public static void main(String [] args)
    {
        try{
            String filename = null;
            DataInputStream dis = new DataInputStream(System.in);
            System.out.println("Enter the name of the file");
            while((filename = dis.readLine())== null);
            File_Readerthread frt = new File_Readerthread(filename);
            File_Writerthread fwt = new File_Writerthread(filename, "DATA");
            frt.start();
            fwt.start();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
} //end class Main
