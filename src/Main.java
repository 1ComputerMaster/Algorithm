import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean canMake100Points(String word) {
        int points = 0;
        for (char c : word.toCharArray()) {
            points += (int)(c - 'a') + 1;
        }
        return points == 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            List<String> strings = readStringsFromFile("input.txt");

            for (String str : strings) {
                if (canMake100Points(str.toLowerCase())) {
                    System.out.println(str);
                } else {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readStringsFromFile(String filePath) throws IOException {
        List<String> strings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }
        }

        return strings;
    }

}