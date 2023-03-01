

public class Spielverwalter   {
    boolean keepRunning;
    int i=0;
    public Spielverwalter() {
       new MyKeyListener("Mein KeyListener");
        keepRunning=true;
        hauptschleife();  
    }

    private void hauptschleife(){
        while(!MyKeyListener.keyPressedESC()){ //Läuft solange bis Escape gedrückt wird
            System.out.println(i);
            i++;
        }
       
    }

}
