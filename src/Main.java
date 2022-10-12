import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {

    static final List<Character> VALIDATOR = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '+', '-', '*');
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        StringBuilder sb = new StringBuilder();
        List<String> equation = new ArrayList<>();
        int result = -1;

        while(!quit){
            System.out.print("Enter equation to solve (or quit to close): ");
            String request = input.nextLine();
            if(request.equalsIgnoreCase("quit"))
                quit = true;
            else {
                request.strip();
                for(int i = 0; i < request.length(); i++) {
                    if(request.charAt(i) != ' ') {
                       if (!VALIDATOR.contains(request.charAt(i)) && request.charAt(i) != ' ') {
                            System.out.println("Please input a valid equation!");
                            break;
                       } else if (request.charAt(i) == '+' || request.charAt(i) == '-' || request.charAt(i) == '*') {
                           if (i == 0 || i == request.length() - 1) {
                               System.out.println("Please input a valid equation!");
                               break;
                           }
                           if(sb.length() != 0)
                            equation.add(sb.toString());
                           equation.add(String.valueOf(request.charAt(i)));
                           sb.setLength(0);
                       } else {
                           sb.append(request.charAt(i));
                       }
                    }
                    else if(sb.length() != 0) {
                        equation.add(sb.toString());
                        sb.setLength(0);
                    }
                }
                if(sb.length() != 0) {
                    equation.add(sb.toString());
                    sb.setLength(0);
                }

                for (int j = 0; j < equation.size() - 1; j++) {
                    switch (equation.get(j)) {
                        case "+" -> result = (result == -1 ? (Integer.parseInt(equation.get(j - 1)) + Integer.parseInt(equation.get(j + 1))) : (result + Integer.parseInt(equation.get(j + 1))));
                        case "-" -> result = (result == -1 ? (Integer.parseInt(equation.get(j - 1)) - Integer.parseInt(equation.get(j + 1))) : (result - Integer.parseInt(equation.get(j + 1))));
                        case "*" -> result = (result == -1 ? (Integer.parseInt(equation.get(j - 1)) * Integer.parseInt(equation.get(j + 1))) : (result * Integer.parseInt(equation.get(j + 1))));
                    }
                }
                System.out.printf("The answer is: %d \n", result);
                equation.clear();
                result = -1;
                }
            }
        }
    }
