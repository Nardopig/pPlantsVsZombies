package control;

import logic.Game;
import logic.Level;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Controller {
    private Game game;
    private Scanner in;
    boolean finish;
    Level level;


    public Controller(Level level) {
        this.level = level;
        game = new Game(level);
        in = new Scanner(System.in);
        finish = false;
    }


    public void run() {
        while (!finish) {
            game.update();
            System.out.println("Number of cycles: " + game.cycleCount);
            System.out.println("Sun coins: " + game.getSuncoins());
            System.out.println("Remaining zombies: " + game.getZombiesLeftToAppear());
            System.out.println();
            System.out.print(game.toString());
            System.out.println();
            comandExe();
            System.out.println();

            game.addZombie();
            if (game.computerWon() || game.userWon()) {
                finish = true;
            } else {
                game.cycleCount++;
            }
        }
        System.out.println("Game Over");
        if (game.computerWon())
            System.out.println("Player wins!");
        else if (game.userWon())
            System.out.println("Computer wins!");
    }

    private void comandExe() {
        System.out.print("Command > ");
        String inputLine = in.nextLine().toLowerCase();


        // delimitador por cada espacio
        StringTokenizer tokenizer = new StringTokenizer(inputLine, " ");

        // trozo siguiente del delimitador
        String command = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";

        switch (command) {
            case "add":
            case "a":
                addPlant(tokenizer);
                break;
            case "list":
            case "l":
                list();
                break;
            case "reset":
            case "r":
                reset();
                break;
            case "help":
            case "h":
                help();
                break;
            case "exit":
            case "e":
                exit();
                break;
            case "":
                break;
            default:
                badCommand();
                break;

        }
    }

    private void badCommand() {
        System.out.println("Command > Bad command");
        System.out.println("Unknown command");
        System.out.println();
        comandExe();
    }

    private void exit() {
        finish = true;
    }

    private void help() {
        System.out.println("Add <plant> <x> <y>: Adds a plant in position x, y.");
        System.out.println("List: Prints the list of available plants.");
        System.out.println("Reset: Starts a new game.");
        System.out.println("Help: Prints this help message.");
        System.out.println("Exit: Terminates the program.");
        System.out.println("[none]: Skips cycle.");
        System.out.println();
        comandExe();
    }

    private void reset() {
        game = new Game(level);
    }

    private void list() {
        System.out.println("[S]unflower: Cost: 20 suncoins Harm: 0");
        System.out.println("[P]eashooter: Cost: 50 suncoins Harm: 1");
        System.out.println();
        comandExe();
    }

    private void addPlant(StringTokenizer tokenizer) {
        String plant = tokenizer.nextToken();

        int i = Integer.valueOf(tokenizer.nextToken());
        int j = Integer.valueOf(tokenizer.nextToken());

        boolean validPosition = validPosition(i, j);

        if (validPosition) {
            switch (plant) {
                case "p":
                    game.addPeashooter(i, j);
                    return;
                case "s":
                    game.addSunflower(i, j);
                    return;
                default:
                    invalidObject();
                    comandExe();
                    break;
            }
        }else{
            comandExe();
        }

    }

    private boolean validPosition(int i, int j) {
        if ((i < 0 || i > 7) || (j < 0 || j > 3)) {
            System.out.println("Invalid position");
            System.out.println();
            return false;
        }

        return true;
    }

    private void invalidObject() {
        System.out.println("Invalid object");
        System.out.println();
    }
}
