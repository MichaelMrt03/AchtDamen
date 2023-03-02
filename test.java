public class test {

        static int[] [][] daten;
        static int[][] feld;
    public static void main(String[] args) {
         daten = new int[100][9][9];
         feld = new int[9][9];
         //Füllt das Feld mit Nullen
        for(int x=1;x<9;x++){
            for(int y=1;y<9;y++){
                feld[x][y]=0;
            }
       }

       System.out.print(feldVorgekommen(feld));
    }


    private static boolean feldVorgekommen(int[][] feld){
        for(int i=0;i<3;i++){
           for(int x=1;x<9;x++){
              for(int y=1;y<9;y++){
               //  System.out.println(gespeicherteLösungen[i][x][y]+" "+feld[x][y]);
                 if(daten[i][x][y]!=feld[x][y])return false;
              }
          }    
        }
        return  true;
  }
}
