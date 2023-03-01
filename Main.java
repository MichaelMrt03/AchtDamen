import javax.lang.model.util.ElementScanner6;

public class Main {
    public static void main(String[] args) throws Exception {
        int feldlaenge=4;
        int haeufigkeit=0;
        long zaehler = 0;
        String k;
        int position[][]= new int[feldlaenge][feldlaenge];
       
       int damen=0;
       int vergleich=0;
     while(zaehler<Math.pow(2,Math.pow(feldlaenge,2)))
       //while(zaehler<17)
        {
           

           k = Long.toBinaryString(zaehler);
           k = new StringBuffer(k).reverse().toString();
           zaehler++;
           for(int i=0; i<(int)Math.pow(feldlaenge,2)&&i<k.length();i++){
              if(k.charAt(i)=='1'){
                position[i/feldlaenge][i%feldlaenge]=1;
            damen++;}
              else{
                position[i/feldlaenge][i%feldlaenge]=0;
              }}
              for(int j=0;j<feldlaenge;j++){
             for(int z=0; z<feldlaenge;z++){
                for(int i=0;i<feldlaenge;i++){
                    if(i!=z&&z!=j){
              if(position[z][i]+position[j][i]>=2)
              break;
            }}
            }}
            for(int j=0;j<feldlaenge;j++){
            for(int z=0; z<feldlaenge;z++){
                for(int i=0;i<feldlaenge;i++){
                    if(i!=z&&z!=j){
              if(position[i][z]+position[i][j]>=2)
              damen=0;
            }}
            }}
   // System.out.println(position[0][1]+"pause"+position[1][0]);


              if(vergleich<damen){
              vergleich=damen;}
              
            // System.out.println(damen); 
              
              damen=0;
           
           
        }
        System.out.println(vergleich);
    }
}
