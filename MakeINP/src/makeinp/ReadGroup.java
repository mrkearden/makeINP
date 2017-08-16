/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeinp;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 *
 * @author dipstick
 */
public class ReadGroup {
    //Custom button text
    int readgdata(String path, String out) throws IOException {
        
        String dheader="    -1";
        String nheader="  2467";
        int iflag=0;
       FileReader file_to_read = new FileReader(path);
       BufferedReader bf = new BufferedReader(file_to_read);

	  FileWriter file_to_write = new FileWriter(out, true);
          PrintWriter print_line = new PrintWriter(file_to_write);
               
       String aLine,i2="",i6="";
       int nnodes = 0,k=0;
       int i=0;
       while (i < 6000000) {
          aLine = bf.readLine();
          if (aLine == null) {
           //System.out.println("No groups found");
           iflag=1;
           break; } 
          if (aLine.equals(nheader)) {
              break;
          }
          i++;
       }
       if (iflag == 1) {
            print_line.close();
            return nnodes;
       }
       
       int nitems;
       int j=0;while(j < 50000) {
       aLine =bf.readLine();
        
       if (aLine.equals(dheader)) {
              break;
          }
       nitems =Integer.valueOf(aLine.substring(71, 80).trim());
       aLine = bf.readLine().trim();
       //System.out.println("Group:"+aLine+" Items:"+nitems);
Object[] options = {"ELSET",
                    "NSET",
                    "Do Not Write"};
int n = JOptionPane.showOptionDialog(null,
    "Would you to Write Group:"+aLine+" as ",
    
    "Group:"+aLine+" Found",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[2]);
	//System.out.println("n:"+n);
      if (n == 0) {
          print_line.printf("*elset,elset="+aLine+"\n");
     }
      if (n == 1) {
	    print_line.printf("*nset,nset="+aLine+"\n");
     }
    int nrows = (nitems+1)/2;
     //System.out.println("nrows:"+nrows);
     i=0;while (i < nrows) {
        aLine =bf.readLine();
        //System.out.println(aLine);
        i2 = aLine.substring(11,20).trim();
        //System.out.println(i2);
        
        if (i == nrows-1) {
        k = nitems-((nrows-1)*2);
        if (k > 1) {
        i6 = aLine.substring(51,61).trim();}
        if (k > 1) {
        if (n < 2) {print_line.printf(i2+","+i6+"\n");}}
        if (k == 1 ){if (n < 2) {print_line.printf(i2+"\n");}}
        }else {
            i6 = aLine.substring(51,61).trim();
            print_line.printf(i2+","+i6+"\n");
                }
                    i++;     }
       
       j++;} // while loop for groups
    print_line.close();
    return nnodes;
    }
}

