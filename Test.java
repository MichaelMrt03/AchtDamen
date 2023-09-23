public class Test {
    public static void main(String[] args) {
        String s[] = new String[10];
        s[0] = "100";
        s[1] = "101";
        s[2] = "102";
        s[3] = "103";
        s[4] = "104";

      for(int i=0;i<5;i++){
        if(s[i]=="103"){
            System.out.println("Gefunden");
        }
      }
      
    }
}
