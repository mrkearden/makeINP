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
 * @author dipstick
 */
public class ReadNodeData {
    
   public String[] OpenNodeFile(String file_path,
           int nnodes) throws IOException {
        
       String nheader="  2411";
        
      
       FileReader fr = new FileReader(file_path);
       BufferedReader textReader = new BufferedReader(fr);
       
       
       
       String aLine;
     
       int i=0;
       while (i < 6000000) {
          aLine = textReader.readLine();
          if (aLine.equals(nheader)) {
              break;
          }
          i++;
       }
       // file in right position
        String[] textNode = new String[nnodes];
        String textData, nlabel,xv,yv,zv;
       i=0;while (i < nnodes) {
           nlabel = textReader.readLine();
           textData = textReader.readLine();
           xv=textData.substring(0, 25);
           yv=textData.substring(25,50);
           zv=textData.substring(50,75);
           textNode[i] = nlabel.substring(0,11).trim()+","+xv.trim()
                   +","+yv.trim()+","+zv.trim();
           i++;
       }
      return textNode;
    } 
}
