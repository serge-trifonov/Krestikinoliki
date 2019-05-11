package KN;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class EcouteurSouris extends JFrame implements MouseListener{

	int x, y;
	private char [][] champ;
	public static final int MAX =3;
	boolean fin = false;
    public EcouteurSouris(JPanel pan, JLabel jl) {
    	label = jl;
    	this.pan = pan;
    	champ = new char[MAX][MAX];
  	    int i, j;
  	    for(i=0; i<MAX; i++) {
  		  for(j=0; j<MAX; j++) {
  			  champ[i][j]=' ';
  		  }
  	  }
}
    
    public void restart() {
    	int i, j;
    	for(i=0; i<MAX; i++) {
    		  for(j=0; j<MAX; j++) {
    			  champ[i][j]=' ';
    		  }
    	  }
    	fin = false;
    }
	public void mouseClicked(MouseEvent eve) {
		int x = eve.getX(); 
		int y = eve.getY();
		 System.out.println(x+" "+y);
		Graphics2D g = (Graphics2D)pan.getGraphics();
		BasicStroke pen1 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
	    g.setStroke(pen1);
	    g.setPaint(Color.red);
		if(!fin) {
			 if(x<110) { if(y<110) { if(champ[0][0]==' ') { g.drawLine(20, 20, 100, 100);
             g.drawLine(20, 100, 100, 20);
             tourDeJeu(0, 0);
             fin = finJeu('o')||finJeu('x');
             }}
             else if(y<210) { if(champ[0][1]==' '){ g.drawLine(20, 120, 100, 200);
                       g.drawLine(100, 120, 20, 200);
                       tourDeJeu(0, 1);
                       fin = finJeu('o')||finJeu('x');
             } }
             else if(y<310) { if(champ[0][2]==' '){ g.drawLine(20, 220, 100, 300);
                       g.drawLine(100, 220, 20, 300);
                       tourDeJeu(0, 2);
                       fin = finJeu('o')||finJeu('x');
       } }
}
else if(x<210) { if(y<110) { if(champ[1][0]==' ') { g.drawLine(120, 20, 200, 100);
                        g.drawLine(120, 100, 200, 20);
                        tourDeJeu(1, 0);
                        fin = finJeu('o')||finJeu('x');
                }}
            else if(y<210) { if(champ[1][1]==' '){ g.drawLine(120, 120, 200, 200);
                       g.drawLine(120, 200, 200, 120);
                       tourDeJeu(1, 1);
                       fin = finJeu('o')||finJeu('x');
                    } }
            else if(y<310) { if(champ[1][2]==' '){ g.drawLine(120, 220, 200, 300);
                       g.drawLine(120, 300, 200, 220);
                       tourDeJeu(1, 2);
                       fin = finJeu('o')||finJeu('x');
                   } }
     }
else if(x<310) { if(y<110) {if(champ[2][0]==' ') { g.drawLine(220, 20, 300, 100);
                        g.drawLine(220, 100, 300, 20);
                        tourDeJeu(2, 0);
                        fin = finJeu('o')||finJeu('x');
                 }}
    else if(y<210) {if(champ[2][1]==' '){ g.drawLine(220, 120, 300, 200);
                    g.drawLine(220, 200, 300, 120);
                    tourDeJeu(2, 1);
                    fin = finJeu('o')||finJeu('x');
          } }
    else if(y<310) { if(champ[2][2]==' '){ g.drawLine(220, 220, 300, 300);
                    g.drawLine(220, 300, 300, 220);
                    tourDeJeu(2, 2);
                    fin = finJeu('o')||finJeu('x');
          } }
        }
		}
	}

	
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
		
	public void igra(int x, int y) {
		Graphics2D g = (Graphics2D)pan.getGraphics();
		BasicStroke pen1 = new BasicStroke(10);
	    g.setStroke(pen1);
	    g.setPaint(Color.blue);
 	    switch(x) {
 	    case 0: if(y==0) g.drawOval(15, 15, 90, 90);
 	            else if(y==1) g.drawOval(15, 115, 90, 90);
 	            else if(y==2) g.drawOval(15, 215, 90, 90);
 	            break;
 	    case 1: if(y==0)  g.drawOval(115, 15, 90, 90);
 	            else if(y==1)  g.drawOval(115, 115, 90, 90);
 	            else if(y==2) g.drawOval(115, 215, 90, 90);
 	            break;
 	    case 2: if(y==0) g.drawOval(215, 15, 90, 90);
 	            else if(y==1) g.drawOval(215, 115, 90, 90);
 	            else if(y==2) g.drawOval(215, 215, 90, 90);
 	            break;
 	    }
 	    }

	
      
      public boolean tourDeJeu(int x, int y) {
    	  int i, j;
    	  if(champ[x][y]==' ') champ[x][y]='x';
          if(!fin&&!finJeu('x')&&!deuxDeTroix('o')&&!deuxDeTroix('x')) {
        	      if(champ[1][1]==' ') {champ[1][1]='o';
        	                            igra(1, 1);
                  return true;}
        	      if(x==1&&y==1) {

        	    		int rand =  (int)(Math.random()*4);
        	    	   switch(rand) {
        	    	   case  0: if(champ[0][0]==' ') {champ[0][0]='o';
                       igra(0, 0);
                       return true;}
        	    		   break;
        	    	   case 1:if( champ[0][2]==' ') {champ[0][2]='o';
                       igra(0, 2);
                       return true;}
        	    		   break;
        	    	   case  2:if( champ[2][0]==' ') {champ[2][0]='o';
                       igra(2, 0);
                       return true;}
        	    		   break;
        	    	   case 3:if( champ[2][2]==' ') {champ[2][2]='o';
                       igra(2, 2);
                       return true;}
        	    		   break;
        	    	   }
        	      }
        	      if(y+1<MAX&&champ[x][y+1]==' ') {champ[x][y+1]='o';
        	                                       igra(x, y+1);
        		                                   return true;
        	      }
        		  if(y-1>0&&champ[x][y-1]==' ') {champ[x][y-1]='o';
        		                                 igra(x, y-1);
                                                 return true;
        		  }
        		  if(x+1<MAX&&champ[x+1][y]==' ') {champ[x+1][y]='o';
        		                                   igra(x+1, y);
                  return true;
                  }
                  if(x-1>0&&champ[x-1][y]==' ') {champ[x-1][y]='o';
                                                 igra(x-1, y);
                  return true;
                  }

                  for(i=0; i<MAX; i++) {
            		  for(j=0; j<MAX; j++) {
            			  if(champ[i][j]==' ') {champ[i][j]='o';
            			                        igra(i, j);
            			                        return true;
            			  }
            		  }
            	  }
                  drawFin('e');
                  return false;
                  }
         
          else 
        	  return true;
    }

      
      public boolean finJeu(char c) {
    	  
    	  int i, j;
    	  //vericale
    	  for(i=0; i<MAX; i++) {
    		  j=0;
    		  while(j<MAX&&champ[j][i]==c) {
    			j++;	  
    		  }
    		  if(j==3) {
    			  drawLine(i, 'h'); 
    			  drawFin(c);
    			        return true; 
    		  }
    	  }
    	  //horisontale
    	  for(i=0; i<MAX; i++) {
    		  j=0;
    		  while(j<MAX&&champ[i][j]==c) {
    			j++;	  
    		  }
    		  if(j==3) {drawLine(i, 'v');
    		  drawFin(c);
                
		        return true; 
	      }
    	  }
    	  //diagonale1
    	  for(i=0, j=0; i<MAX; i++) {
    		  if(champ[i][i]==c) 
    			j++;	  
    	      }
    		  if(j==3){drawLine(1, 'd'); 
    		  drawFin(c);
                
		        return true; 
	          }

    	  //diagonale2
    	  for(i=0, j=0; i<MAX; i++) {
    		  if(champ[i][MAX-1-i]==c)
    			j++;	  
    		  }
    		  if(j==3) {drawLine(2, 'd'); 
    		  drawFin(c);
                
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
    			  igra(position, i);
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
    			  igra(i, position);
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
    		                                                igra(position, position);
    		  return true;}
    	  //diagonale2
    		  count=0;
    	  for(i=0; i<MAX; i++) { ;
    		  if(champ[i][MAX-1-i]==c)count++;
    		  else if (champ[i][MAX-1-i]==' ') position = i;
    		  }
    		  if(count==2&&champ[position][MAX-1-position]==' ') {
    			  champ[position][MAX-1-position]='o';
    			  igra(position, MAX-1-position);
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
      
      public void drawLine(int x, char c) {
    	    
    	    Graphics2D g = (Graphics2D)pan.getGraphics();
    	    BasicStroke pen1 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
    	    g.setStroke(pen1);
    	    g.setPaint(Color.red);
    	  switch(c) {
    	  case 'v': 
    		  if(x==0) g.drawLine(60, 20, 60, 310);
    		  else if(x==1)g.drawLine(160, 20, 160, 310);
    		  else if(x==2)g.drawLine(260, 20, 260, 310);
    	            break;
    	  case 'h':
    		  if(x==0) g.drawLine(15, 60, 310, 60);
    		  else if(x==1)g.drawLine(15, 160, 310, 160);
    		  else if(x==2)g.drawLine(15, 260, 310, 260);
    	            break;
    	  case 'd' :
    		  if(x==1) g.drawLine(15, 15, 300, 300);
    		  else if(x==2) g.drawLine(300, 15, 15, 300);
    		  break;
    	  }

    	  try {
    	  Thread.sleep(1000);
    	  }
    	  catch(InterruptedException e) {}
    	  
      }
    public void drawFin(char c) {
 
		Graphics2D g = (Graphics2D)pan.getGraphics();
		if(c=='x') {
	    g.setPaint(Color.green);
	    g.fillRoundRect(10, 10, 310, 310, 10, 10);
	    g.setPaint(Color.black);
	    Font f = new Font("Courier", Font.BOLD, 22);
		g.setFont(f);
	  	g.drawString("Vous avez gagné!", 65, 90);
	  	 BasicStroke pen1 = new BasicStroke(7, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
 	    g.setStroke(pen1);
	  	g.drawOval(90, 120, 150, 150);
	  	g.drawOval(130, 175, 3, 3);
	  	g.drawOval(200, 175, 3, 3);
	  	g.drawArc(125, 170, 80, 80, 210, 120);
	    }
		else if(c=='o'){
		    g.setPaint(Color.black);
			    g.fillRoundRect(10, 10, 310, 310, 10, 10);
			    g.setPaint(Color.white);
			    Font f = new Font("Courier", Font.BOLD, 22);
				g.setFont(f);
			  	g.drawString("Vous avez perdu!", 65, 90);
			  	 BasicStroke pen1 = new BasicStroke(7, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
			 	    g.setStroke(pen1);
				  	g.drawOval(90, 120, 150, 150);
				  	g.drawOval(130, 175, 3, 3);
				  	g.drawOval(200, 175, 3, 3);
				  	g.drawArc(125, 220, 80, 80, 30, 120);
			    }
		else {
			g.setPaint(Color.gray);
		    g.fillRoundRect(10, 10, 310, 310, 10, 10);
		    g.setPaint(Color.pink);
		    Font f = new Font("Courier", Font.BOLD, 22);
			g.setFont(f);
		  	g.drawString("Egalité", 100, 90);
		  	 BasicStroke pen1 = new BasicStroke(7, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
		 	    g.setStroke(pen1);
			  	g.drawOval(90, 120, 150, 150);
			  	g.drawOval(130, 175, 3, 3);
			  	g.drawOval(200, 175, 3, 3);
			  	g.drawLine(130, 230, 200, 230);
		}
    }
	JPanel pan;
	JLabel label;
}
