import java.util.*;
import java.io.*;


public class Qualitest {

    static void ex1(String word) {

        StringBuilder sb = new StringBuilder(word);
        sb.reverse();

        System.out.println(sb.toString());

    }

    static void ex2(List<String> words) {

        if(words == null | words.size() == 0) {
            System.out.println("The list is empty");
        }

        int max_length = 0;
        for(String word : words) {
            if(word.length() > max_length) {
                max_length = word.length();
            }
        }

        System.out.println("*".repeat(max_length+4));

        for (String word:words) {
            System.out.println("* " + word + " ".repeat(max_length-word.length()) + " *");
        }

        System.out.println("*".repeat(max_length+4));

    }

    static void ex3(List<Object> lista) {

        Set<Integer> arr = new LinkedHashSet<Integer>();

        for (Object value : lista) {
            if (value instanceof Integer) {
                arr.add((Integer) value);
            }
        }

        System.out.println(arr);

    }

    static void ex4(List<String> strings) {

        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<String> audio = new ArrayList<>();
        List<String> video = new ArrayList<>();
        List<String> others = new ArrayList<>();

        for (String value : strings ) {
            String extension = value.split("\\.")[1];

            if ((!extension.equals("mp4")) && (!extension.equals("wav"))) {
                others.add(value);
            } else if (extension.equals("mp4")) {
                video.add(value);
            } else {
                audio.add(value);
            }
        }

        hashMap.put("Video", video);
        hashMap.put("Audio", audio);
        hashMap.put("Others", others);

        System.out.println(hashMap);

    }

    static void ex5(Integer number_rabbits, Integer n_years, Integer rabbits_birth_number) {

        List<Integer> list = Arrays.asList(0,0,0,0);

        list.set(0, number_rabbits);

        for (int i=0; i<n_years; i++) {
            list.set(3, list.get(2));
            list.set(2, list.get(1));
            list.set(1, list.get(0));
            list.set(0, rabbits_birth_number * (list.get(1) + list.get(2)));
        }

        Integer total_number_rabbits = list.stream().reduce(0, Integer::sum);

        System.out.println(total_number_rabbits);

    }


    public static void main(String[] args) {

        ex1("Automation");

        ex2(Arrays.asList("Hello", "World", "in", "a", "frame"));

        ex3(Arrays.asList(1, 3, 67, "1", "62", "Foo", "3", 5, 1, 3, false, 1.3));

        ex4(Arrays.asList("Entry One.mp4", "Entry Two.wav", "Entry Three.jpg", "Entry Four.mng", "Entry Five.png", "Entry Six.csv"));

        ex5(3,2,2);
    }
}
