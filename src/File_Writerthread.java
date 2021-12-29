/* Class File_Writerthread.java */
import java.io.*;
import java.util.*;
import java.lang.*;
/* This class reads the data from the file and stores in to another file */
public class File_Writerthread extends Thread
{
    private String _filename;
    private String _towrite;
    private FileInputStream fis;
    private FileOutputStream fws;
    private File f, fw;
    private PrintStream ps;
    private StreamTokenizer stk;
    private Vector v_data;
    String [] name_dept ;
    String [] id_val;
    public File_Writerthread(String filename, String towrite)
    {
        try {
            _filename = filename;
            _towrite = towrite;
            f = new File(_filename);
            fw = new File(_towrite);
            fis = new FileInputStream(f);
            fws = new FileOutputStream(fw);
            stk = new StreamTokenizer(fis);
            ps = new PrintStream(fws);
            name_dept = new String[100];
            id_val = new String[100];
            v_data = new Vector();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
    public void run()
    {
        double p ;
        int no_access =0;
        String buffer, type;
        int no_of_times =0;
        int pi =0;
        try
        {
            int next = stk.nextToken();
            while(next != stk.TT_EOF )
            {
                if (stk.ttype == stk.TT_NUMBER)
                {
                    p = stk.nval;
                    type = new Integer((int)p).toString();
                    no_access = ((no_of_times/2)-1);
                    System.out.println(no_access);
                    id_val[no_access] = type;
                    System.out.println(id_val[no_access]);
                }
                else
                {
                    buffer = stk.sval;
                    name_dept[no_of_times] = buffer;
                    no_of_times++;
                }
                next = stk.nextToken();
            }
            for(int i=0; i< no_of_times ; i = i+2)
            {
                ps.print(name_dept[i]);
                ps.print(" ");
                ps.print(name_dept[i+1]);
                ps.print(" ");
                ps.print(id_val[i/2]);
                ps.print("\n");
            }
        } //end try
        catch(Exception e){System.out.println(e.getMessage());}
    } //end method run
} //end class
