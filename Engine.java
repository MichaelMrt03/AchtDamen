public class Engine {
    int feld[][] = new int[8][8];
    int platzierteFiguren = 0;
    int x;
    int y;

    public Engine() {
        // Feld ausfüllen mit Nullen
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                feld[i][k] = 0;
            }
        }

        while (platzierteFiguren < 8) {
            x = (int) (Math.random() * 8);
            y = (int) (Math.random() * 8);

            if (!checkLine(x, y)) {
                feld[x][y] = 1;
                platzierteFiguren++;
                System.out.println(x + " " + y);
            }
        } // Ende der Schleife
        System.out.println(arrayAusgabe(feld));
        System.out.println(arrayAusgabe(feld).length());

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

    // Gibt einen Array als String aus
    public String arrayAusgabe(int[][] array) {
        String ausgabe = "";
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                ausgabe = ausgabe + feld[i][k];
            }
        }
        return ausgabe;
    }

}
