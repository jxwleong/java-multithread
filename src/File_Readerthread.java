/* Class File_Readerthread */
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.zip.*;
/* This particular class reads the data fom the file and stores in to the vector */
public class File_Readerthread extends Thread
{
    private String _filename;
    private FileInputStream fis;
    private File f;
    private StreamTokenizer stk;
    private Vector v_data;
    String [] name_dept;
    Datastore de;
    String [] id_val;
    public File_Readerthread(String filename)
    {
        try{
            _filename = filename;
            f = new File(_filename);
            fis = new FileInputStream(f);
            stk = new StreamTokenizer(fis);
            v_data = new Vector();
            id_val = new String[100];
            name_dept = new String[100];
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
                de = new Datastore();
                de.name = name_dept[i];
                de.dept = name_dept[i+1];
                no_access = (i/2);
                de.id = id_val[no_access];
                System.out.println(de.name);
                System.out.println(de.dept);
                System.out.println(de.id);
                v_data.addElement(de);
            }
        } //end try
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    } //end run
} //end class
