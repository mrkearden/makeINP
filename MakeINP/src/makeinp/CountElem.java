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
public class CountElem {
      
   int readLines(String path) throws IOException {
        
        String dheader="    -1";
        String eheader="  2412";
        //System.out.println(" Start Count ELEM");
       FileReader file_to_read = new FileReader(path);
       BufferedReader bf = new BufferedReader(file_to_read);
       
       String aLine;
       int nelem = 0;
       int i=0,j=0;
       while (i < 6000000) {
          aLine = bf.readLine();
          if (aLine.equals(eheader)) {
              break;
          }
       }
       nelem=0;
       //System.out.println(eheader);
       int nnperelem =4;
       String snnpelem="4";
       i=0;
           while ( i < 6000000) {
           aLine =bf.readLine();
           //System.out.println("Header:"+aLine);
           if (aLine.equals(dheader)) {
               i=7000000;
               break;
           }
           nelem++;
          // System.out.println(nelem);
           snnpelem=aLine.substring(51, 60);
           
           //System.out.println(snnpelem);
           
           nnperelem=Integer.valueOf(snnpelem.trim());
           
           //System.out.println(nnperelem);
           
           int numlines=5;
           if (nnperelem > 32) {numlines=4;}
           if (nnperelem <= 24) {numlines=3;}
           if (nnperelem <= 16) {numlines=2;}
           if (nnperelem <= 8) {numlines=1;}
                   
          
           //System.out.println(numlines);
           j=1;
           while (j <= numlines) {
               aLine = bf.readLine();
               if (aLine.equals("         0         1         1")) {
                   aLine = bf.readLine();
                   //System.out.println("Found one");
               }
               j++;
           }
          
           i++;
       }
               bf.close();
       
       return nelem;
            
    } 
}
