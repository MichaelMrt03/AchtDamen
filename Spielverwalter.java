

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
      // System.out.println(feld[4][4]);

       hauptschleife(); 
    }

    private void hauptschleife(){
            //Zufallsposition für eine Dame
            int randomX = (int) (Math.random()*8)+1;
            int randomY = (int) (Math.random()*8)+1;
            System.out.println("x:"+randomX+" "+"y:"+randomY);

            feld[randomX][randomY] = 1;
            checkDiagonal(feld, randomX, randomY);

  
    }

    private void checkDiagonal(int[][] feld,int x, int y) {
     //oben rechts
     int startX = x;
     int startY = y;

     while(x!=8&&y!=1){
     if(x<8){
        x++;
     }

     if(y>1){
        y--;
     }

     feld[x][y] = 2;
     
    }

    //Ausgabe
    int umbruchzaehler=0;
    for( y=1;y<9;y++){
       for( x=1;x<9;x++){       
           if(umbruchzaehler%8==0){
               System.out.println("");
           }
                   System.out.print(" "+feld[x][y]);
                   umbruchzaehler++;
               
       }
   }

   }
}
