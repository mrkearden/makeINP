/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeinp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author dipstick
 */
public class WriteElemInp {
    public void writeElem( String file_path,
            boolean append_value, String[][] aryLine,
            int nelem) throws IOException {
        String path = file_path; 
        boolean append_to_file = append_value;
     FileWriter write = new FileWriter( path , append_to_file);
     PrintWriter print_line = new PrintWriter( write );
     
     int i=0;
     while (i < nelem)
     {
     if (Integer.valueOf(aryLine[i][1]) > 0) {
     print_line.printf(aryLine[i][0]+"\n");
     }
      i++;   
    
     }
     print_line.close();
    }
    }
