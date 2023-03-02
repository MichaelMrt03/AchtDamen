import java.time.Year;

public class Spielverwalter   {

   int[][] feld; 
   int durchlaeufe=0;
   int randomX;
   int randomY;
   int umbruchzaehler;
   int platzierteDamen;
   int anzahlLoesungen=0;
   int[] [][] gespeicherteLösungen;
    public Spielverwalter() {
      // new MyKeyListener("Mein KeyListener");
        feld = new int[9][9]; //Damit man das 8*8 Feld mit 1 bis 8 darstellen kann

       //Füllt das Feld mit Nullen
        for(int x=1;x<9;x++){
            for(int y=1;y<9;y++){
                feld[x][y]=0;
            }
       }
          gespeicherteLösungen = new int[100][9][9];
    
       //fulle lösungen mit nullen
       /* 
       for (int i = 0; i < feld.length; i++) {
         for(int x=1;x<9;x++){
            for(int y=1;y<9;y++){
               gespeicherteLösungen[i][x][y] = 0;
            }
      } 
       }*/
            
      hauptschleife(); 
    }

    private void hauptschleife(){
      while(anzahlLoesungen<10){
         while(platzierteDamen<8){
                  //Zufallsposition für eine Dame
               randomX = (int) (Math.random()*8)+1;
               randomY = (int) (Math.random()*8)+1;
               while(!checkLine(feld, randomX, randomY) || !checkDiagonal(feld, randomX, randomY)){
                     randomX = (int) (Math.random()*8)+1;
                     randomY = (int) (Math.random()*8)+1;
                  durchlaeufe++;
                  if(durchlaeufe>1000){
                  //   System.out.println("\nNeuer Versuch");
                     reset();
                     continue;
                  }
               }

               
               feld[randomX][randomY]=1;
               platzierteDamen++;
             //  System.out.print("\nFiguren auf dem Feld:"+ platzierteDamen);
         }
for (int i = 0; i < 8; i++) {
if(!feldVorgekommen(feld,i)){


      //Neue Speicherung
      for(int x=1;x<9;x++){
         for(int y=1;y<9;y++){
             gespeicherteLösungen[anzahlLoesungen][x][y] = feld[x][y];
         }
    }
      //Ende neue Speicherung
      anzahlLoesungen++;
      }else{
         System.out.println("\nEs gab eine Doppelung!");
      }
   }


      reset();
    } //Ende Lösungsschleife
      System.out.println("\nEnde");
      for (int i = 0; i < anzahlLoesungen; i++) {
         System.out.print("\nNeue Lös: "+ ++i);
         i--;
         for(int x=1;x<9;x++){
            for(int y=1;y<9;y++){
               if(umbruchzaehler%8==0){
                  System.out.print("\n");
            }
               System.out.print(" "+gespeicherteLösungen[i][x][y]);
               umbruchzaehler++;
            }
      } 
       }

   } //Ende Methode hauptschleife
   



    private boolean checkLine(int[][] feld,int x, int y){
      int startX = x;
      int startY = y;
       // rechts 
     do{
         if(feld[x][y]==1){return false;}
         x++;
     }while(x<=8);

    // links 2
     x = startX;
     y = startY;
     do{
      if(feld[x][y]==1){return false;} 
      x--;
     }while(x>=1);

    //unten 3
    x = startX;
    y = startY;
   do{
      if(feld[x][y]==1){return false;}
      y++;
   }while(y<=8);

  //oben 4
  x = startX;
  y = startY;
  do{
   if(feld[x][y]==1){return false;}
   y--;
  }while(y>=1);

      return true;
}
    

    private boolean checkDiagonal(int[][] feld,int x, int y) {
     //oben rechts 1
     int startX = x;
     int startY = y;

     while(x!=8&&y!=1){
      if(x<8){
         x++;
      }

     if(y>1){
        y--;
     }

     if(feld[x][y]==1){
      return false;
     }
     
    }

    //oben links 2
     x = startX;
     y = startY;

    while(x!=1&&y!=1){
      if(x>1){
         x--;
      }

    if(y>1){
       y--;
    }

    if(feld[x][y]==1){
     return false;
     }
    
   }

    //unten links 3
    x = startX;
    y = startY;

   while(x!=8&&y!=8){
    if(x==1)break;
    if(y==8)break;

   if(x>1){
      x--;
   }

   if(y<8){
      y++;
   }

   if(feld[x][y]==1){
      return false;
     }
  }

  //unten rechts 4
  x = startX;
  y = startY;

 while(x!=8&&y!=8){
    if(x==8)break;
    if(y==8)break;

 if(x<8){
    x++;
 }

 if(y<8){
    y++;
 }

 if(feld[x][y]==1){
   return false;
  }
 
}
   return true;
   }

   private void reset(){
      durchlaeufe=0;
      platzierteDamen=0;
      //Füllt das Feld mit Nullen
      for(int x=1;x<9;x++){
         for(int y=1;y<9;y++){
             feld[x][y]=0;
         }
    }
   }

      //Prüft, ob ein Feld schonmal vorgekommen ist
   private boolean feldVorgekommen(int[][] feld,int posArr){
            for(int x=1;x<9;x++){
               for(int y=1;y<9;y++){
                 // System.out.println(gespeicherteLösungen[i][x][y]+" "+feld[x][y]);
                  if(gespeicherteLösungen[posArr][x][y]!=feld[x][y])return false;
               }
         }    
         
         return  true;
   }
}
