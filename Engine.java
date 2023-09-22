public class Engine {
    int feld[][] = new int[8][8];
    int platzierteFiguren = 0;
    int x;
    int y;
    int versuche;
    public Engine() {
        setFeld(); //Füllt das Feld mit Nullen

        while (platzierteFiguren < 8) {
            x = (int) (Math.random() * 8);
            y = (int) (Math.random() * 8);

            if (!checkLine(x, y) && !checkDiagonal(x, y) && !checkFeld(x, y)) {
                feld[x][y] = 1;
                platzierteFiguren++;
                 System.out.println("Figur Nr:"+platzierteFiguren);
                 versuche = 0;
            }
            versuche++;
            if(versuche>1000){
                setFeld();
                platzierteFiguren=0;
                System.out.println("Reset");
            }
        } // Ende der Schleife


        System.out.println(arrayAusgabe(feld));
        System.out.println(arrayAusgabe(feld).length());
        System.out.println(schachbrettAusgabe(feld));

    }

    // Liefert true zurück, wenn eine Figur auf der Linie steht
    public boolean checkLine(int x, int y) {
        for (int i = 0; i < 8; i++) {
            if (feld[x][i] == 1)
                return true;
        }
        for (int i = 0; i < 8; i++) {
            if (feld[i][y] == 1)
                return true;
        }
        return false;
    }

    // Liefert true zurück, wenn eine Figur bereits auf der Diagonalen steht
    public boolean checkDiagonal(int x, int y) {
        // oben links
        int x1 = x;
        int y1 = y;
        while (x1 > 0 && y1 > 0) {
            x1--;
            y1--;
            if (feld[x1][y1] == 1)
                return true;
        }
        // unten rechts
        x1 = x;
        y1 = y;
        while (x1 < 7 && y1 < 7) {
            x1++;
            y1++;
            if (feld[x1][y1] == 1)
                return true;
        }
        // oben rechts
        x1 = x;
        y1 = y;
        while (x1 < 7 && y1 > 0) {
            x1++;
            y1--;
            if (feld[x1][y1] == 1)
                return true;
        }
        // unten links
        x1 = x;
        y1 = y;
        while (x1 > 0 && y1 < 7) {
            x1--;
            y1++;
            if (feld[x1][y1] == 1)
                return true;
        }
        return false;
    }

    // Gibt einen die Schachbrettstellen als einen langen einzeiligen String
    public String arrayAusgabe(int[][] feld) {
        String ausgabe = "";
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                ausgabe = ausgabe + feld[i][k];
            }
        }
        return ausgabe;
    }

    // Gibt die Schachbrettstellung formartiert als String zurück
    public String schachbrettAusgabe(int[][] feld) {
        String ausgabe = "";
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                ausgabe = ausgabe + " " + feld[i][k];
            }
            ausgabe = ausgabe + "\n";
        }
        return ausgabe;
    }

    // Überprüft, ob auf dem Feld schon eine Figur steht
    public boolean checkFeld(int x, int y) {
        if (feld[x][y] == 1) {
            return true;
        }
        return false;
    }

    public void setFeld(){
        // Feld ausfüllen mit Nullen
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                feld[i][k] = 0;
            }
        }

    }
}
