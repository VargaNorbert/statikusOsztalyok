package hu.petrik.statikusosztalyok;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Veletlen {

    private Veletlen() {

    }

    private static final Random rnd = new Random();

    private static final List<String> vezNevek = feltolt("veznev.txt");
    private static final List<String> ferfiKerNevek = feltolt("ferfikernev.txt");
    private static final List<String> noiKerNevek = feltolt("noikernev.txt");
    private static final List<String>  sport = feltolt("sportag.txt");
    private static final List<String>  egyesulet = feltolt("egyesulet.txt");




    private static List<String> feltolt(String fajlnev) {
        List<String> lista = new ArrayList<>();


        try {
            Scanner file = new Scanner(new File(fajlnev));
            while (file.hasNext()) {
                String sor = file.nextLine();
                lista.add(sor);
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return lista;
    }

    public static int velEgesz(int min, int max) {
        return rnd.nextInt(max - min + 1) + min;
    }

    public static char velKarakter(char min , char max){
        return (char) velEgesz(min,max);
    }

    public static String velVezetekNev(){

        return vezNevek.get(rnd.nextInt(vezNevek.size()));

    }

    /**
     * Véletlen magyar keresztnév generálása
     * @param nem A generált név neme. Férfi esetén true, nő esetén false.
     * @return A generált keresztnév.
     */
    public  static String velKeresztNev(boolean nem){

        String keresztNev;

        if(nem){
            keresztNev= velFerfiKeresztNev();
        }else{
            keresztNev= velNoiKeresztNev();
        }

        return  keresztNev;
    }

    private static String velFerfiKeresztNev(){
        return ferfiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }

    private static String velNoiKeresztNev(){
        return  noiKerNevek.get(rnd.nextInt(noiKerNevek.size()));
    }

    /**
     * Véletlen magyar keresztnév generálása
     * @param nem A generált név neme. Férfi esetén true, nő esetén false.
     * @return A generált keresztnév.
     */

    public static String velTeljesNev(boolean nem){
        return velVezetekNev()+ " " + velKeresztNev(nem);
    }

    public static String velDatum(int ev1, int ev2){
        int ev = rnd.nextInt(ev1 - ev2);
        int hnap = rnd.nextInt(1 - 12);
        int nap = rnd.nextInt(1-31);

        return ev+"-"+hnap+"-"+nap;
    }

    public static String velEmail(String nev){
        String email;
        email = String.format("%s%d@gmail.com",nev.toLowerCase(),velEgesz(1,100));
        return email;
    }

    public static String velMobil(){
        String mobil = "+3630";

        for (int i = 0; i < 7; i++) {
            mobil+=velEgesz(1,9);
        }

        return mobil;
    }

    public static String velSportag(){
        return sport.get(rnd.nextInt(sport.size()));
    }

    public static String velEgyesulet(){
        return sport.get(rnd.nextInt(egyesulet.size()));
    }


}
