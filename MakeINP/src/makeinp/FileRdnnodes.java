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
public class FileRdnnodes {
    String path;
    
    private void ReadFile( String file_path) {
        path = file_path;
    }
    
   public int OpenFile(String file_path) throws IOException {
        
       path = file_path;
       FileReader fr = new FileReader(path);
       BufferedReader textReader = new BufferedReader(fr);
       
       CountNodes count = new CountNodes();
       int nnodes = count.readLines(path);
       
       //System.out.println(nnodes);
      
       return nnodes;
    }    
 
 }
