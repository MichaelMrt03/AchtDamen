public class Test {
  static int doppelungen = 0;

  public static void main(String[] args) {
    String s[] = new String[10];
    for (int i = 0; i < s.length; i++) {
      s[i] = "";
    }
    for (int i = 0; i < s.length; i++) {
      for (int j = 0; j < 3; j++) {
        s[i] = s[i] + Integer.toString((int) (Math.random() * 2));
      }
    }
    arrayAusgabe(s);
    checkClones(s);
  }

  public static void checkClones(String[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if (i != j) {
          if (array[i].equals( array[j])) {
            System.out.println("DOPPELUNG GEFUNDEN! NR" + ++doppelungen);
          }
        }
      }
    }
  }

  public static void arrayAusgabe(String[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }
}
