import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static void satu(String kata){
        String text = kata.toLowerCase();
        ArrayList<Integer> konversi = new ArrayList<Integer>();
        ArrayList<String> konversialfa = new ArrayList<String>();
        ArrayList<String> fix = new ArrayList<String>();

        for (int i = 0; i <= text.length()-1; i++) {
            char c = text.charAt(i);
            int ascii = (int) c;
            if (ascii != 32){
                konversi.add(ascii);
                konversialfa.add(String.valueOf(c));
            }
        }

        for (int l=0;l<=konversi.size()-1;l++){
            int jml = 0;
            for (int k = 0; k<= konversi.size()-1;k++){
                if (konversi.get(l)== konversi.get(k)){
                    jml++;
                }
            }
            if (!fix.contains(konversialfa.get(l))) {
                fix.add(konversialfa.get(l));
                System.out.print(konversialfa.get(l)+"="+ jml);
                if (l < konversi.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }

    static void dua(String[] kata) {
        String word = "";
        Map<String, Integer> letter = new TreeMap<>();
        ArrayList<String> hasil = new ArrayList<String>(letter.size());

        for (int f=0;f<=kata.length-1;f++){
            for (int g=0;g<kata[f].length();g++){
                word = word + kata[f].charAt(g);
            }
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int ascii = (int) c;
            if (ascii != 32){
                String huruf = String.valueOf(c);
                if (!letter.containsKey(huruf)) {
                    letter.put(huruf, +1);
                }else {
                    letter.put(huruf, letter.get(huruf)+1);
                }
            }
        }

        ArrayList<String> konversialfa = new ArrayList<String>(letter.keySet());

        for (int i=0;i< konversialfa.size();i++){
            hasil.add(konversialfa.get(i));
                for (int j=0;j<=i;j++){
                    if (letter.get(konversialfa.get(i))>letter.get(hasil.get(j))){
                        String tampung = hasil.get(i);

                        for (int k=i;k>j;k--){
                            hasil.set(k, hasil.get(k-1));
                        }
                        hasil.set(j, tampung);
                        break;
                    }else {
                        hasil.set(i, konversialfa.get(i));
                    }
                }
        }

        for (int i=0;i< hasil.size();i++){
            System.out.print(hasil.get(i));
        }

    }

    public static void main(String[] args) {
        satu("coding is fun");
        String[] kata = {"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"};
        dua(kata);
    }
}