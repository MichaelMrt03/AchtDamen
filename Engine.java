public class Engine {
    static int feld[][] = new int[8][8];
    static int platzierteFiguren = 0;

    public Engine() {
        while (platzierteFiguren < 8) {
            // Feld ausfüllen mit Nullen
            for (int i = 0; i < 8; i++) {
                for (int k = 0; k < 8; k++) {
                    feld[i][k] = 0;
                }
            }

            int x = (int) (Math.random() * 8);
            int y = (int) (Math.random() * 8);
            if(!checkLine(x,y)){
            feld[x][y] = 1;
            platzierteFiguren++;
            }

        }

    }
    //Liefert true zurück, wenn eine Figur auf der Linie steht
    public static boolean checkLine(int x,int y) {
        for(int i=0;i<8;i++){
            if(feld[x][i] == 1)return true;
        }
        for(int i=0;i<8;i++){
            if(feld[i][y] == 1)return true;
        }
        return false;
    }

    
}
