/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeinp;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 *
 * @author dipstick
 */
public class CountNodes {
    
   int readLines(String path) throws IOException {
        
        String dheader="    -1";
        String nheader="  2411";
        
       FileReader file_to_read = new FileReader(path);
       BufferedReader bf = new BufferedReader(file_to_read);
       
       String aLine;
       int nnodes = 0;
       int i=0;
       while (i < 6000000) {
          aLine = bf.readLine();
          if (aLine.equals(nheader)) {
              break;
          }
          i++;
       }
       nnodes=0;
       i=0;
           while ( i < 6000000) {
           aLine =bf.readLine();
           if (aLine.equals(dheader)) {
               break;
           }
           nnodes++;
           aLine =bf.readLine();
       }
               bf.close();
       
       return nnodes;
            
    } 
}
