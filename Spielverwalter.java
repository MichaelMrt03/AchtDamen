

public class Spielverwalter   {

    int[][] feld; 
   
    public Spielverwalter() {
      // new MyKeyListener("Mein KeyListener");
        feld = new int[9][9]; //Damit man das 8*8 Feld mit 1 bis 8 darstellen kann
       //Füllt das Feld mit Nullen
        for(int x=1;x<9;x++){
            for(int y=1;y<9;y++){
                feld[x][y]=0;
            }
       }

       hauptschleife(); 
    }

    private void hauptschleife(){
      for(int i=1;i<9;i++){
            //Zufallsposition für eine Dame
            int randomX = (int) (Math.random()*8)+1;
            int randomY = (int) (Math.random()*8)+1;

          while(!checkLine(feld, randomX, randomY)){
            randomX = (int) (Math.random()*8)+1;
            randomY = (int) (Math.random()*8)+1;
          }
          feld[randomX][randomY]=1;
          System.out.println("\nFiguren auf dem Feld:"+ i);
      }
         //Ausgabe
    int umbruchzaehler=0;
    for(int y=1;y<9;y++){
       for(int x=1;x<9;x++){       
           if(umbruchzaehler%8==0){
               System.out.println("");
           }
                   System.out.print(" "+feld[x][y]);
                   umbruchzaehler++;
               
       }
   }
    }

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
}
