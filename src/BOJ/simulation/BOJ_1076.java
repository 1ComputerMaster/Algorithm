package BOJ.simulation;

import java.util.*;

public class BOJ_1076 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> colorValues = new HashMap<>();
        colorValues.put("black", 0);
        colorValues.put("brown", 1);
        colorValues.put("red", 2);
        colorValues.put("orange", 3);
        colorValues.put("yellow", 4);
        colorValues.put("green", 5);
        colorValues.put("blue", 6);
        colorValues.put("violet", 7);
        colorValues.put("grey", 8);
        colorValues.put("white", 9);

        int firstColor = colorValues.get(scanner.nextLine());
        int secondColor = colorValues.get(scanner.nextLine());
        int multiplyColor = colorValues.get(scanner.nextLine());

        long resistanceValue = (firstColor * 10 + secondColor) * (long) Math.pow(10, multiplyColor);

        System.out.println(resistanceValue);
    }

}
