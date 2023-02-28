import GLOOP.*;
public class Spielverwalter {
    public Spielverwalter(){
        new GLKamera();
        new GLLicht();
        new GLQuader(0,0,0,30,30, 30);
        new Map(); 
    }
}
