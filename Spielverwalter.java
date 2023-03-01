

public class Spielverwalter   {

    int[][] feld; 
    public Spielverwalter() {
       new MyKeyListener("Mein KeyListener");
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
            while(positionierteDamen<8){
            //Zufallsposition für eine Dame
            int randomX = (int) (Math.random()*8)+1;
            int randomY = (int) (Math.random()*8)+1;

            if(feld[randomX][randomY]==0){
                feld[randomX][randomY]=1; 
                positionierteDamen++;
                System.out.println("Positionierte Damen: "+positionierteDamen);
            }
           }
       // }
         //Ausgabe
         int umbruchzaehler=0;
         for(int x=1;x<9;x++){
            for(int y=1;y<9;y++){       
                if(umbruchzaehler%8==0){
                    System.out.println("");
                }
                        System.out.print(feld[x][y]);
                        umbruchzaehler++;
                    
            }
        }
    }

}
