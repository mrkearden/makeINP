/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeinp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author titan
 */
public class FileRdNumElem {
    
    public int OpenFile2 (String file_path) throws IOException {
        
       FileReader fr = new FileReader(file_path);
       BufferedReader textReader = new BufferedReader(fr);
       
       CountElem celem = new CountElem();
       int nelem = celem.readLines(file_path);
       
       //System.out.println("Number of Elements:"+nelem);
       
       return nelem;
    }  
}
