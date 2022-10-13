
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static boolean valid = true;
    private static StringBuilder sb = new StringBuilder();
    private static List<String> equation = new ArrayList<>();

    static final List<Character> VALIDATOR = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '+', '-', '*', ' ');

    public static void main(String[] args) {
        int result = -1;
        Scanner input = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            
            System.out.print("Enter equation to solve (or quit to close): ");
            String request = input.nextLine();
            if (request.equalsIgnoreCase("quit")){
                quit = true;
                valid = false;
            }
                
            else {
                result = Calculator(request);
            }
            if (valid)
                System.out.printf("The answer is: %d \n", result);
            result = -1;
        }
        input.close();
    }

    public static int Calculator(String request) {
        int result = -1;
        valid = true;
        request.strip();
        for (int i = 0; i < request.length(); i++) {
            char current = request.charAt(i);
            if (!VALIDATOR.contains(current)) {
                System.out.println("Please input a valid equation!");
                valid = false;
                break;
            } else if (current == '+' || current == '-' || current == '*' || current == ' ') {
                if (i == 0 || i == request.length() - 1 && valid) {
                    System.out.println("Please input a valid equation!");
                    valid = false;
                    break;
                }
                if (sb.length() != 0)
                    equation.add(sb.toString());
                if (current != ' ')
                    equation.add(String.valueOf(current));
                sb.setLength(0);
            } else {
                sb.append(request.charAt(i));
            }
        }
        if (sb.length() != 0) {
            equation.add(sb.toString());
            sb.setLength(0);
        }
        if (equation.size() < 3 && valid) {
            System.out.println("Please input a valid equation!");
        } else {
            for (int j = 0; j < equation.size() - 1; j++) {
                if (equation.get(j).equalsIgnoreCase("*")) {
                    equation.add(j, String.valueOf(
                            Integer.parseInt(equation.get(j - 1)) * Integer.parseInt(equation.get(j + 1))));
                    equation.remove(j - 1);
                    equation.remove(j + 1);
                    equation.remove(j);
                }
            }
            if (equation.size() == 1)
                result = Integer.parseInt(equation.get(0));
            for (int j = 0; j < equation.size() - 1; j++) {
                switch (equation.get(j)) {
                    case "+" -> result = (result == -1
                            ? (Integer.parseInt(equation.get(j - 1)) + Integer.parseInt(equation.get(j + 1)))
                            : (result + Integer.parseInt(equation.get(j + 1))));
                    case "-" -> result = (result == -1
                            ? (Integer.parseInt(equation.get(j - 1)) - Integer.parseInt(equation.get(j + 1)))
                            : (result - Integer.parseInt(equation.get(j + 1))));
                }
            }
        }
        equation.clear();
        return result;
    }

    public static boolean returnValid(){return valid;}
}
