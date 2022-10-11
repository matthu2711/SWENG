import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {

    static final List<Character> VALIDATOR = Arrays.asList('0', '1', '3', '4', '5', '6', '7', '8', '9',
            '+', '-', '*');
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        StringBuilder sb = new StringBuilder();
        List<String> equation = new ArrayList<>();
        int result = -1;

        while(!quit){
            System.out.print("Enter equation to solve (or quit to close): ");
            String request = input.next();
            if(request.equalsIgnoreCase("quit"))
                quit = true;
            else {
                for(int i = 0; i < request.length(); i++) {
                    if (!VALIDATOR.contains(request.charAt(i))) {
                        System.out.println("Please input a valid equation!");
                        break;
                    } else {
                        if (request.charAt(i) == '+' || request.charAt(i) == '-'
                                || request.charAt(i) == '*') {
                            if (i == 0 || i == request.length() - 1) {
                                System.out.println("Please input a valid equation!");
                                break;
                            }
                            equation.add(sb.toString());
                            sb.setLength(0);
                            equation.add(String.valueOf(request.charAt(i)));
                        } else
                            sb.append(request.charAt(i));
                    }
                }
                equation.add(sb.toString());

                for (int j = 0; j < equation.size() - 1; j++) {
                    switch (equation.get(j)) {
                        case "+" -> result = (result == -1 ? (Integer.parseInt(equation.get(j - 1)) + Integer.parseInt(equation.get(j + 1))) : (result + Integer.parseInt(equation.get(j + 1))));
                        case "-" -> result = (result == -1 ? (Integer.parseInt(equation.get(j - 1)) - Integer.parseInt(equation.get(j + 1))) : (result - Integer.parseInt(equation.get(j + 1))));
                        case "*" -> result = (result == -1 ? (Integer.parseInt(equation.get(j - 1)) * Integer.parseInt(equation.get(j + 1))) : (result * Integer.parseInt(equation.get(j + 1))));
                    }
                }
                System.out.printf("The answer is: %d \n", result);
                }
            }
        }
    }
