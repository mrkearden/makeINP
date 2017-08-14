/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeinp;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 *
 * @author titan
 */
public class WriteNodeInp {
    public void writeNode( String file_path,
            boolean append_value, String[] aryLine,
            int nnode) throws IOException {
        String path = file_path; 
        boolean append_to_file = append_value;
     FileWriter write = new FileWriter( path , append_to_file);
     PrintWriter print_line = new PrintWriter( write );
     print_line.printf("*node,nset=all\n");
     int i=0;
     while (i < nnode)
     {
     print_line.printf(aryLine[i]+"\n");
      i++;   
     }
     print_line.close();
 }
}
