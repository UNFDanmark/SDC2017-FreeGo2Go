package software.unf.dk.freego2go;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BoardSize();
        Variables.Board = makeBoard();

        //nigiri();

        while (true) {
            playerTurn();
        }

        //Vundet method


    }

    //Nigiri Colorselection()
    //Vælger random tal, hvis inputtet svarer til vores generede tal så starter spilleren (ulige/lige)
    protected static void nigiri() {
        int number = 1 + (int) (Math.random() * 50);
        System.out.println(number);

        if (number % 2 == 0) {
            System.out.println("Odd=1 or even=2?");
            Scanner start = new Scanner(System.in);
            int n = start.nextInt();
            if (n == 2) {
                Variables.turn = false; //set black
                System.out.println("you got b");
            } else {
                Variables.turn = true; //set white
                System.out.println("you got w");
            }

        } else {
            System.out.println("Odd=1 or even=2?");
            Scanner start = new Scanner(System.in);
            int n = start.nextInt();
            if (n == 2) {
                Variables.turn = true; //set white
                System.out.println("you got w");

            } else {
                Variables.turn = false; //set black
                System.out.println("you got b");
            }
        }
    }

    // set board size
    public static void BoardSize() {

        System.out.println("Hvor stort skal brættet være?");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Variables.boardsizeModifier = n;

    }

    //Create Board
    public static ArrayList<ArrayList<Integer>> makeBoard() {
        //TODO: Add change boardModifierFunction
        ArrayList<ArrayList<Integer>> Board = new ArrayList<>();
        for (int i = 0; i < Variables.boardsizeModifier; i++) {
            Board.add(new ArrayList<Integer>());
            for (int j = 0; j < Variables.boardsizeModifier; j++) {
                Board.get(i).add(0);

            }
            System.out.println(Board.get(i));
        }
        return Board;
    }

    public static void playerTurn() {
        // Skifte turn og relavante variabler
        // User input til position på brættet
        if (Variables.turn) {
            // blacks turn
            //Spørg efter x eller pass
            System.out.println("B: Indtast koordinater x or pass");

            Scanner scanx = new Scanner(System.in);
            String in = scanx.next();
            //Check for string of int - Pass
            if (in.equals("pass")) {
            } else {
                Variables.currentX = Integer.parseInt(in);

                //Spørg efter y
                System.out.println("B: Indtast koordinater y");
                Scanner scany = new Scanner(System.in);
                Variables.currentY = scany.nextInt();
                //Repeat if invalid move
                while (!search.tileCheck(Variables.currentX, Variables.currentY)) {
                    playerTurn();
                }
            }


            Variables.amountOfTurns++;
            //TODO IF-STATEMENTS SOM ÆNDRER POINTVARIABLER

        } else {
            // Whites turn
            //Spørg efter x eller pass
            System.out.println("W: Indtast koordinater x eller pass");

            Scanner scanx = new Scanner(System.in);
            String in = scanx.next();
            //Check for string of int - Pass
            if (in.equals("pass")) {
            } else {
                Variables.currentX = Integer.parseInt(in);

                //Spørg efter y
                System.out.println("W: Indtast koordinater y");
                Scanner scany = new Scanner(System.in);
                Variables.currentY = scany.nextInt();
                //Repeat if invalid move
                while (!search.tileCheck(Variables.currentX, Variables.currentY)) {
                    playerTurn();
                }
            }


            Variables.amountOfTurns++;
            //TODO IF-STATEMENTS SOM ÆNDRER POINTVARIABLER

        }
        System.out.println(Variables.Board);

        //Skift spiller efter turslut
        Variables.turn = !Variables.turn;
        System.out.println("\nAmount of Turns: " + Variables.amountOfTurns);
    }

}

    //Board Generator()

    //Tile Search()

    //State Switch()


    /*Should have
     *
      * Scorecheck()
      *
      * Liberties()
      *
      * Capture Area Search()
      *
      * Hook up Graphics
      *
      * */
