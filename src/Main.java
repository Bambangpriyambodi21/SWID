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
        ArrayList<Integer> konversi = new ArrayList<Integer>();
        ArrayList<String> konversialfa = new ArrayList<String>();
        ArrayList<String> fix = new ArrayList<String>();
        String word = "";

        Map<String, Integer> letter = new HashMap<>();

        Map<String, Integer> sortedByValueAscending = new TreeMap<>(
                (k1, k2) -> letter.get(k1).compareTo(letter.get(k2))
        );

        for (int f=0;f<=kata.length-1;f++){
            word = word + kata[f];
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int ascii = (int) c;
            if (ascii != 32){
                konversi.add(ascii);
                konversialfa.add(String.valueOf(c));
            }
        }

        for (int l=0;l<konversi.size();l++){
            int jml = 0;
            for (int k = 0; k<konversi.size();k++){
                if (konversi.get(l).equals(konversi.get(k))){
                    jml++;
                }
            }
            if (!fix.contains(konversialfa.get(l))) {
                fix.add(konversialfa.get(l));
                letter.put(konversialfa.get(l), jml);

                sortedByValueAscending.putAll(letter);

                if (l==letter.size()){
                    Set<String> keys = letter.keySet();
                    for (String key : keys) {
                        System.out.print(key);
                    }
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        satu("coding is fun");
        String[] kata = {"Oke", "One"};
        dua(kata);
    }
}