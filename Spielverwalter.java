import GLOOP.*;
public class Spielverwalter {
    public Spielverwalter(){
        new GLKamera();
        new GLLicht();
        new GLQuader(0,0,0,30,30, 30);
        new Map(); 

        hauptschleife();  
    }

    private void hauptschleife(){

    }

    private void camPosition(){
        //Kamera Sicht aus der Vogelperspektive auf das Schachbrett
    }
}
