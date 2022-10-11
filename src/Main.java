import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;

        while(!quit){
            System.out.println("Enter equation to solve (or quit to close): ");
            String request = input.next();
            if(request.equalsIgnoreCase("quit"))
                quit = true;
            else {
                
            }
        }
    }
}