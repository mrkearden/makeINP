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
public class ReadElemData {
    public String[][] OpenElemFile(String file_path,
           int nelem, boolean Getbtn[]) throws IOException {
        
       String nheader="  2412";
       int iflag=0,tflag=0;
      
       FileReader fr = new FileReader(file_path);
       BufferedReader textReader = new BufferedReader(fr);
       
       
       
       String aLine, snnpelem, ifed;
       int nnperelem;
       String[] n=new String[32];
     
       int i=0;
       while (i < 6000000) {
          aLine = textReader.readLine();
          if (aLine.equals(nheader)) {
              break;
          }
          i++;
       }
       // file in right position
        String[][] textElem = new String[nelem][2];
        String textData, elabel;
       i=0;while (i < nelem) {
           textElem[i][1] = "1";
           tflag=0;
           elabel = textReader.readLine();
           System.out.println(elabel);
           snnpelem=elabel.substring(51, 60);
           ifed = elabel.substring(11,21);
           //System.out.println(ifed+ iflag);
           if (Integer.valueOf(ifed.trim()) != iflag){
               iflag = 0;
               //System.out.println("Iflag reset");
           }
           
// Process Bricks if found and button on

           if (ifed.trim().equals("115")){
               tflag=1;
               //System.out.println(ifed);
               //MainForm ntext = new MainForm();
               //ntext.Update(ifed);
           if (Getbtn[10] == false){ textElem[i][1] = "0";}    
           
               nnperelem=Integer.valueOf(snnpelem.trim());
           
           textData = textReader.readLine();
           //if (textData.equals("         0         1         1")) {
           //       textData = textReader.readLine();
                   //System.out.println("Found one in elem data");
            //   }
           
           if (nnperelem ==8) {
               if (iflag == 0){
               textElem[i][0]="*element,type=c3d8,elset=bricks\n";
               iflag=115;
               }
               else {textElem[i][0]="";}
               n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,21);
               n[3] = textData.substring(21,31);
               n[4] = textData.substring(31,41);
               n[5] = textData.substring(41,51);
               n[6]= textData.substring(51,61);
               n[7] = textData.substring(61,71);
               n[8]= textData.substring(71,80);
          
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
               textElem[i][0] = textElem[i][0]+","+n[3].trim();
               textElem[i][0] = textElem[i][0]+","+n[4].trim();
               textElem[i][0] = textElem[i][0]+","+n[5].trim();
               textElem[i][0] = textElem[i][0]+","+n[6].trim();
               textElem[i][0] = textElem[i][0]+","+n[7].trim();
               textElem[i][0] = textElem[i][0]+","+n[8].trim();
                    }
           }
           
 // End Bricks
 
 // Process triangles if found
           if (ifed.trim().equals("41") || ifed.trim().equals("91")){
               tflag=1;
               //System.out.println(ifed);
              // MainForm ntext = new MainForm();
              // ntext.Update(ifed);
              if (Getbtn[6] == false){ textElem[i][1] = "0";} 
               
           
               nnperelem=Integer.valueOf(snnpelem.trim());
               //System.out.println(nnperelem);
           textData = textReader.readLine();
           //if (textData.equals("         0         1         1")) {
           //        textData = textReader.readLine();
           //        //System.out.println("Found one in elem data");
           //    }
           
           if (nnperelem ==3) {
               if (iflag == 0){
               textElem[i][0]="*element,type=s3,elset=trias\n";
               iflag=41;
               }
               else {textElem[i][0]="";}
               n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,21);
               n[3] = textData.substring(21,30);
                         
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
               textElem[i][0] = textElem[i][0]+","+n[3].trim();
               
                    }
           }
 // End tirangles
 // Process triangles if found
           if (ifed.trim().equals("42") || ifed.trim().equals("92")){
               tflag=1;
               //System.out.println(ifed);
              // MainForm ntext = new MainForm();
              // ntext.Update(ifed);
              if (Getbtn[8] == false){ textElem[i][1] = "0";} 
               
           
               nnperelem=Integer.valueOf(snnpelem.trim());
               //System.out.println(nnperelem);
           textData = textReader.readLine();
           //if (textData.equals("         0         1         1")) {
           //        textData = textReader.readLine();
           //        //System.out.println("Found one in elem data");
           //    }
           if (nnperelem ==6) {
               if (iflag == 0){
               textElem[i][0]="*element,type=s6,elset=shells\n";
               iflag=42;
               }
               else {textElem[i][0]="";}
              n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,21);
               n[3] = textData.substring(21,31);
               n[4] = textData.substring(31,41);
               n[5] = textData.substring(41,51);
               n[6]= textData.substring(51,60);
                         
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
               textElem[i][0] = textElem[i][0]+","+n[3].trim();
               textElem[i][0] = textElem[i][0]+","+n[4].trim();
               textElem[i][0] = textElem[i][0]+","+n[5].trim();
               textElem[i][0] = textElem[i][0]+","+n[6].trim();
               
                    }
           }
 // End tirangles
 // Process beams if found
           if (ifed.trim().equals("11") || ifed.trim().equals("21")){
               tflag=1;
               //System.out.println(ifed);
              // MainForm ntext = new MainForm();
              // ntext.Update(ifed);
              if (Getbtn[4] == false){ textElem[i][1] = "0";} 
               
           
               nnperelem=Integer.valueOf(snnpelem.trim());
               //System.out.println(nnperelem);
           textData = textReader.readLine();
           textData = textReader.readLine();
                  //System.out.println("Found one in elem data");
              
           if (nnperelem ==2) {
               if (iflag == 0){
               textElem[i][0]="*element,type=b32,elset=beams\n";
               iflag=11;
               }
               else {textElem[i][0]="";}
               n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,20);
                         
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
                          
                    }
           }
 // End beams
 // Process beams if found
           if (ifed.trim().equals("22") || ifed.trim().equals("24")){
               tflag=1;
               //System.out.println(ifed);
              // MainForm ntext = new MainForm();
              // ntext.Update(ifed);
              if (Getbtn[5] == false){ textElem[i][1] = "0";} 
               
           
               nnperelem=Integer.valueOf(snnpelem.trim());
               //System.out.println(nnperelem);
           textData = textReader.readLine();
           textData = textReader.readLine();
                  //System.out.println("Found one in elem data");
               
           if (nnperelem ==3) {
               if (iflag == 0){
               textElem[i][0]="*element,type=b32,elset=beams\n";
               iflag=22;
               }
               else {textElem[i][0]="";}
               n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,21);
               n[3] = textData.substring(21,30);
                         
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
               textElem[i][0] = textElem[i][0]+","+n[3].trim();
               
                    }
           }
 // End beams
 // Process quads if found
           if (ifed.trim().equals("44") || ifed.trim().equals("94")){
               tflag=1;
               //System.out.println(ifed);
              // MainForm ntext = new MainForm();
              // ntext.Update(ifed);
               if (Getbtn[7] == false){ textElem[i][1] = "0";} 
           
               nnperelem=Integer.valueOf(snnpelem.trim());
               //System.out.println(nnperelem);
           textData = textReader.readLine();
           //if (textData.equals("         0         1         1")) {
           //        textData = textReader.readLine();
           //        //System.out.println("Found one in elem data");
           //    }
           if (nnperelem ==4) {
               if (iflag == 0){
               textElem[i][0]="*element,type=s4,elset=quads\n";
               iflag=44;
               }
               else {textElem[i][0]="";}
              n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,21);
               n[3] = textData.substring(21,31);
               n[4] = textData.substring(31,40);
                         
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
               textElem[i][0] = textElem[i][0]+","+n[3].trim();
               textElem[i][0] = textElem[i][0]+","+n[4].trim();
               
                    }
           }
 // End quads
 // Process Bricks if found
           if (ifed.trim().equals("45") || ifed.trim().equals("95")){
               tflag=1;
               //System.out.println(ifed);
               //MainForm ntext = new MainForm();
               //ntext.Update(ifed);
               if (Getbtn[11] == false){ textElem[i][1] = "0";} 
           
               nnperelem=Integer.valueOf(snnpelem.trim());
           
           textData = textReader.readLine();
          // if (textData.equals("         0         1         1")) {
          //         textData = textReader.readLine();
          //         //System.out.println("Found one in elem data");
          //     }
           if (nnperelem ==8) {
               if (iflag == 0){
               textElem[i][0]="*element,type=s8,elset=quads\n";
               iflag=45;
               }
               else {textElem[i][0]="";}
               n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,21);
               n[3] = textData.substring(21,31);
               n[4] = textData.substring(31,41);
               n[5] = textData.substring(41,51);
               n[6]= textData.substring(51,61);
               n[7] = textData.substring(61,71);
               n[8]= textData.substring(71,80);
          
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
               textElem[i][0] = textElem[i][0]+","+n[3].trim();
               textElem[i][0] = textElem[i][0]+","+n[4].trim();
               textElem[i][0] = textElem[i][0]+","+n[5].trim();
               textElem[i][0] = textElem[i][0]+","+n[6].trim();
               textElem[i][0] = textElem[i][0]+","+n[7].trim();
               textElem[i][0] = textElem[i][0]+","+n[8].trim();
                    }
           }
 // End Bricks
 // Process wedges if found
           if (ifed.trim().equals("112")){
               tflag=1;
               //System.out.println(ifed);
              // MainForm ntext = new MainForm();
              // ntext.Update(ifed);
               if (Getbtn[9] == false){ textElem[i][1] = "0";} 
           
               nnperelem=Integer.valueOf(snnpelem.trim());
               //System.out.println(nnperelem);
           textData = textReader.readLine();
           //if (textData.equals("         0         1         1")) {
           //        textData = textReader.readLine();
           //        //System.out.println("Found one in elem data");
           //    }
           if (nnperelem ==6) {
               if (iflag == 0){
               textElem[i][0]="*element,type=c3d6,elset=wedges\n";
               iflag=112;
               }
               else {textElem[i][0]="";}
               n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,21);
               n[3] = textData.substring(21,31);
               n[4] = textData.substring(31,41);
               n[5] = textData.substring(41,51);
               n[6]= textData.substring(51,60);
                         
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
               textElem[i][0] = textElem[i][0]+","+n[3].trim();
               textElem[i][0] = textElem[i][0]+","+n[4].trim();
               textElem[i][0] = textElem[i][0]+","+n[5].trim();
               textElem[i][0] = textElem[i][0]+","+n[6].trim();
               
                    }
           }
 // End wedges
 // Process 20 node brick if found
           if (ifed.trim().equals("116")){
               tflag=1;
               //System.out.println(ifed);
              // MainForm ntext = new MainForm();
              // ntext.Update(ifed);
               if (Getbtn[3] == false){ textElem[i][1] = "0";} 
           
               nnperelem=Integer.valueOf(snnpelem.trim());
               //System.out.println(nnperelem);
           textData = textReader.readLine();
           //if (textData.equals("         0         1         1")) {
           //        textData = textReader.readLine();
           //        //System.out.println("Found one in elem data");
           //    }
           if (nnperelem ==20) {
               if (iflag == 0){
               textElem[i][0]="*element,type=c3d20,elset=bricks\n";
               iflag=116;
               }
               else {textElem[i][0]="";}
               n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,21);
               n[3] = textData.substring(21,31);
               n[4] = textData.substring(31,41);
               n[5] = textData.substring(41,51);
               n[6] = textData.substring(51,61);
               n[7] = textData.substring(61,71);
               n[8] = textData.substring(71,80);
               textData = textReader.readLine();
               n[9] = textData.substring(0,11);
               n[10] = textData.substring(11,21);
               n[11] = textData.substring(21,31);
               n[12] = textData.substring(31,41);
               n[13] = textData.substring(41,51);
               n[14] = textData.substring(51,61);
               n[15] = textData.substring(61,71);
               n[16] = textData.substring(71,80);
               textData = textReader.readLine();
               n[17] = textData.substring(0,11);
               n[18] = textData.substring(11,21);
               n[19] = textData.substring(21,31);
               n[20] = textData.substring(31,40);
                         
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
               textElem[i][0] = textElem[i][0]+","+n[3].trim();
               textElem[i][0] = textElem[i][0]+","+n[4].trim();
               textElem[i][0] = textElem[i][0]+","+n[5].trim();
               textElem[i][0] = textElem[i][0]+","+n[6].trim();
               textElem[i][0] = textElem[i][0]+","+n[7].trim();
               textElem[i][0] = textElem[i][0]+","+n[8].trim();
               textElem[i][0] = textElem[i][0]+","+n[9].trim();
               textElem[i][0] = textElem[i][0]+","+n[10].trim();
               textElem[i][0] = textElem[i][0]+","+n[11].trim();
               textElem[i][0] = textElem[i][0]+","+n[12].trim();
               textElem[i][0] = textElem[i][0]+","+n[13].trim();
               textElem[i][0] = textElem[i][0]+","+n[14].trim();
               textElem[i][0] = textElem[i][0]+","+n[15].trim()+",\n";
               textElem[i][0] = textElem[i][0]+n[16].trim();
               textElem[i][0] = textElem[i][0]+","+n[17].trim();
               textElem[i][0] = textElem[i][0]+","+n[18].trim();
               textElem[i][0] = textElem[i][0]+","+n[19].trim();
               textElem[i][0] = textElem[i][0]+","+n[20].trim();
                    }
           }
 // End bricks
 // Process 15 node wedge if found
           if (ifed.trim().equals("113")){
               tflag=1;
               //System.out.println(ifed);
              // MainForm ntext = new MainForm();
              // ntext.Update(ifed);
               if (Getbtn[2] == false){ textElem[i][1] = "0";} 
           
               nnperelem=Integer.valueOf(snnpelem.trim());
               //System.out.println(nnperelem);
           textData = textReader.readLine();
           //if (textData.equals("         0         1         1")) {
           //        textData = textReader.readLine();
           //        //System.out.println("Found one in elem data");
           //    }
           if (nnperelem ==15) {
               if (iflag == 0){
               textElem[i][0]="*element,type=c3d15,elset=wedges\n";
               iflag=113;
               }
               else {textElem[i][0]="";}
               n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,21);
               n[3] = textData.substring(21,31);
               n[4] = textData.substring(31,41);
               n[5] = textData.substring(41,51);
               n[6] = textData.substring(51,61);
               n[7] = textData.substring(61,71);
               n[8] = textData.substring(71,80);
               textData = textReader.readLine();
               n[9] = textData.substring(0,11);
               n[10] = textData.substring(11,21);
               n[11] = textData.substring(21,31);
               n[12] = textData.substring(31,41);
               n[13] = textData.substring(41,51);
               n[14] = textData.substring(51,61);
               n[15] = textData.substring(61,70);
                         
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
               textElem[i][0] = textElem[i][0]+","+n[3].trim();
               textElem[i][0] = textElem[i][0]+","+n[4].trim();
               textElem[i][0] = textElem[i][0]+","+n[5].trim();
               textElem[i][0] = textElem[i][0]+","+n[6].trim();
               textElem[i][0] = textElem[i][0]+","+n[7].trim();
               textElem[i][0] = textElem[i][0]+","+n[8].trim();
               textElem[i][0] = textElem[i][0]+","+n[9].trim();
               textElem[i][0] = textElem[i][0]+","+n[10].trim();
               textElem[i][0] = textElem[i][0]+","+n[11].trim();
               textElem[i][0] = textElem[i][0]+","+n[12].trim();
               textElem[i][0] = textElem[i][0]+","+n[13].trim();
               textElem[i][0] = textElem[i][0]+","+n[14].trim();
               textElem[i][0] = textElem[i][0]+","+n[15].trim();
                    }
           }
 // End wedges
 // Process 10 noded tet  if found
           if (ifed.trim().equals("118")){
               tflag=1;
               //System.out.println(ifed);
              // MainForm ntext = new MainForm();
              // ntext.Update(ifed);
               if (Getbtn[1] == false){ textElem[i][1] = "0";} 
           
               nnperelem=Integer.valueOf(snnpelem.trim());
               //System.out.println(nnperelem);
           textData = textReader.readLine();
           //if (textData.equals("         0         1         1")) {
           //        textData = textReader.readLine();
           //        //System.out.println("Found one in elem data");
           //    }
           if (nnperelem ==10) {
               if (iflag == 0){
               textElem[i][0]="*element,type=c3d10,elset=solids\n";
               iflag=118;
               }
               else {textElem[i][0]="";}
               n[1] = textData.substring(0,11);
               n[2] = textData.substring(11,21);
               n[3] = textData.substring(21,31);
               n[4] = textData.substring(31,41);
               n[5] = textData.substring(41,51);
               n[6] = textData.substring(51,61);
               n[7] = textData.substring(61,71);
               n[8] = textData.substring(71,80);
               textData = textReader.readLine();
               n[9] = textData.substring(0,11);
               n[10] = textData.substring(11,20);
                         
               textElem[i][0] = textElem[i][0]+elabel.substring(0,11).trim();
               textElem[i][0] = textElem[i][0]+","+n[1].trim();
               textElem[i][0] = textElem[i][0]+","+n[2].trim();
               textElem[i][0] = textElem[i][0]+","+n[3].trim();
               textElem[i][0] = textElem[i][0]+","+n[4].trim();
               textElem[i][0] = textElem[i][0]+","+n[5].trim();
               textElem[i][0] = textElem[i][0]+","+n[6].trim();
               textElem[i][0] = textElem[i][0]+","+n[7].trim();
               textElem[i][0] = textElem[i][0]+","+n[8].trim();
               textElem[i][0] = textElem[i][0]+","+n[9].trim();
               textElem[i][0] = textElem[i][0]+","+n[10].trim();
              
                    }
           }
 // End wedges
           if (tflag == 0) {
              // System.out.println(ifed+" not found");
               elabel = textReader.readLine();
               textElem[i][1] = "0";
               
               if (iflag == 0){
               textElem[i][0] = "** Usupported Element Type "+ifed+" found";
               iflag=Integer.valueOf(ifed.trim());
               textElem[i][1] = "1";
               }
               
           }
           i++;
       }
      return textElem;
    } 
}
