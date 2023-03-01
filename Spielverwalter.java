

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
     //  System.out.println(feld[4][4]);

       hauptschleife(); 
    }

    private void hauptschleife(){
        //while(!MyKeyListener.keyPressedESC()){ //Läuft solange bis Escape gedrückt wird
          int positionierteDamen=0;
          int versuchszähler=0;
            while(positionierteDamen<8){
            //Zufallsposition für eine Dame
            int randomX = (int) (Math.random()*8)+1;
            int randomY = (int) (Math.random()*8)+1;

            if(feld[randomX][randomY]==0&&checkDiagonal(feld,randomX,randomY)==true){
                feld[randomX][randomY]=1; 
                positionierteDamen++;
                System.out.println("\n\nPositionierte Damen: "+positionierteDamen);
            }
            
       // }
         //Ausgabe
         int umbruchzaehler=0;
         for(int x=1;x<9;x++){
            for(int y=1;y<9;y++){       
                if(umbruchzaehler%8==0){
                    System.out.println("");
                }
                        System.out.print(" "+feld[x][y]);
                        umbruchzaehler++;
                    
            }
        }
        System.out.println("");
        versuchszähler++;
        if(versuchszähler>1000){
            System.out.println("\nEs gibt wahrscheinlich keine weitere Stellung mehr");
            break;
        }
      }
    }

    private boolean checkDiagonal(int[][] feld,int x, int y) {
         boolean checkObenRechts=false,checkObenLinks=false,checkUntenRechts=false,checkUntenLinks=false;
        int startX = x;
        int startY = y;
        //nach oben rechts prüfen 1
      for(int i=0;i<8;i++){ // Acht mal, da ggf von (1/1) bis (8/8)
        if(x<8){
            x++;
            if(y<8){
                y++;
            }else{
                //Rand erreicht in y
                checkObenRechts=true;
            }
            }else{
            //Rand erreicht in x
            checkObenRechts=true;
        }

        if(feld[x][y]==1){
            return false;
        }
    }

      //nach oben links prüfen 2
        if(checkObenRechts){   
            x = startX;
            y = startY;  
            for(int i=0;i<8;i++){ // Acht mal, da ggf von (1/8) bis (8/1)
                if(x>1){
                    x--;
                    if(y<8){
                        y++;
                    }else{
                        //Rand erreicht in y
                        checkObenLinks=true;
                    }
                    }else{
                    //Rand erreicht in x
                    checkObenLinks=true;
                }

                if(feld[x][y]==1){
                    return false;
                }
            }
        }else{
            //Wenn links false ist
            return false;
        }

        //nach unten links prüfen 3
        if(checkObenLinks){  
            x = startX;
            y = startY;    
            for(int i=0;i<8;i++){ // Acht mal, da ggf von (8/8) bis (1/1)
                if(x>1){
                    x--;
                    if(y>1){
                        y--;
                    }else{
                        //Rand erreicht in y
                        checkUntenLinks=true;
                    }
                    }else{
                    //Rand erreicht in x
                    checkUntenLinks=true;
                }

                if(feld[x][y]==1){
                    return false;
                }
            }
        }else{
            //Wenn links false ist
            return false;
        }

        //nach unten rechts prüfen 4
        if(checkUntenLinks){  
            x = startX;
            y = startY;    
            for(int i=0;i<8;i++){ // Acht mal, da ggf von (1/8) bis (8/1)
                if(x<8){
                    x++;
                    if(y>1){
                        y--;
                    }else{
                        //Rand erreicht in y
                        checkUntenRechts=true;
                    }
                    }else{
                    //Rand erreicht in x
                    checkUntenRechts=true;
                }

                if(feld[x][y]==1){
                    return false;
                }
            }
        }else{
            //Wenn links false ist
            return false;
        }


       if(checkObenRechts&&checkObenLinks&&checkUntenLinks&&checkUntenRechts){
        return true;
       }else{
        return false;
       }
    }
}
