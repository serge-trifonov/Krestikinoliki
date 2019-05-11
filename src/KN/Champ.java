package KN;

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.*;

public class Champ {
	private char [][] champ;
	public static final int MAX =3;
	public GraphicsMorpion gm;
	int x, y;
      public Champ() {
   	 /*  gm = new GraphicsMorpion();
   	   gm.setVisible(true);
   	   tourOrdi(1);*/
    	  champ = new char[MAX][MAX];
    	  int i, j;
    	  for(i=0; i<MAX; i++) {
    		  for(j=0; j<MAX; j++) {
    			  champ[i][j]=' ';
    		  }
    	  }
      
      }
      
      public boolean tourDeJeu(int x, int y) {
    	  int i, j;
    	  if(champ[x][y]==' ') champ[x][y]='x';
          if(!finJeu('x')&&!deuxDeTroix('o')&&!deuxDeTroix('x')) {
        	      if(champ[1][1]==' ') {champ[1][1]='o';
                  return true;}
        	      if(y+1<MAX&&champ[x][y+1]==' ') {champ[x][y+1]='o';
        		                                   return true;
        	      }
        		  if(y-1>0&&champ[x][y-1]==' ') {champ[x][y-1]='o';
                                                 return true;
        		  }
        		  if(x+1<MAX&&champ[x+1][y]==' ') {champ[x+1][y]='o';
                  return true;
                  }
                  if(x-1>0&&champ[x-1][y]==' ') {champ[x-1][y]='o';
                  return true;
                  }
                  x=(int) (Math.random()*2);
                  y=(int) (Math.random()*2);
                  if(champ[x][y]==' ') {champ[x][y]='o';
            			                        return true;}
                  else { for(i=0; i<MAX; i++) {
            		  for(j=0; j<MAX; j++) {
            			  if(champ[i][j]==' ') {champ[i][j]='o';
            			                        return true;
            			  }
            		  }
            	  }
                  }
                  return false;
                  }
                
          else return true;
    }

      
      public boolean finJeu(char c) {
    	  int i, j;
    	  //vericale
    	  for(i=0; i<MAX; i++) {
    		  j=0;
    		  while(j<MAX&&champ[j][i]==c) {
    			j++;	  
    		  }
    		  if(j==3) {afficherGagne(c);
    			        return true; 
    		  }
    	  }
    	  //horisontale
    	  for(i=0; i<MAX; i++) {
    		  j=0;
    		  while(j<MAX&&champ[i][j]==c) {
    			j++;	  
    		  }
    		  if(j==3) {afficherGagne(c);

		        return true; 
	      }
    	  }
    	  //diagonale1
    	  for(i=0, j=0; i<MAX; i++) {
    		  if(champ[i][i]==c) 
    			j++;	  
    	      }
    		  if(j==3){afficherGagne(c);

		        return true; 
	          }

    	  //diagonale2
    	  for(i=0, j=0; i<MAX; i++) {
    		  if(champ[i][MAX-1-i]==c)
    			j++;	  
    		  }
    		  if(j==3) {afficherGagne(c);

		        return true; 
	  }
    	  return false;
      }
      
      public boolean deuxDeTroix(char c) {
    	  int i, j, count=0, position=0;
    	  //vericale
    	  for(i=0; i<MAX; i++) {
    		  j=0;
    		  count=0;
    		  while(j<MAX&&(champ[j][i]==c||champ[j][i]==' ')) {
    			if(champ[j][i]==c)count++;
    			else position = j;
    			j++;
    		  }
    		  if(count==2&&champ[position][i]==' ') { 
    			  champ[position][i]='o';
    			  return true;
    		      }
    		      
    	  }
    	  //horisontale
    	  for(i=0; i<MAX; i++) {
    		  j=0;
    		  count=0;
    		  while(j<MAX&&(champ[i][j]==c||champ[j][i]==' ')) {
    			if(champ[i][j]==c)count++;
      			else position = j;  
    			j++;	 
    		  }
    		  if(count==2&&champ[i][position]==' ') { 
    			  champ[i][position]='o';
    			  return true;
    		      }
    	  }
    	  //diagonale1
    	  count=0;
    	  for(i=0; i<MAX; i++) {
    		  
    			if(champ[i][i]==c)count++;
    			else if(champ[i][i]==' ')position=i;
    		  }
    		  if(count==2&&champ[position][position]==' ') {champ[position][position]='o'; 
    		  return true;}
    	  //diagonale2
    		  count=0;
    	  for(i=0; i<MAX; i++) { ;
    		  if(champ[i][MAX-1-i]==c)count++;
    		  else if (champ[i][MAX-1-i]==' ') position = i;
    		  }
    		  if(count==2&&champ[position][MAX-1-position]==' ') {
    			  champ[position][MAX-1-position]='o';
    		               return true; 
    		  }
    	  return false;
      }
      
      
      public void afficher() {
    	  int i, j;
    	  for(i=0; i<MAX; i++) {
    		  for(j=0; j<MAX; j++) {
    			  System.out.print(champ[i][j]);
    		  }
    		  System.out.println();
    	  }
      }
      
      public void afficherGagne(char c) {
    	  if(c=='x')
          System.out.print("Vous avez gagne!");
    	  else System.out.println("Vous avez perdu :( ");
    	  }



     public void tourOrdi(JPanel p) {
    	Graphics g = p.getGraphics();
 	    g.drawOval(10, 0, 90, 90);
      }
     

     }
