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
        game.setLevel(level);
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
    }

    private void comandExe() {
        System.out.print("Command > ");
        String inputLine = in.nextLine().toLowerCase();

        if (inputLine.isEmpty()) {
            return;
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine, " ");
        // delimitador por cada espacio
        String command = tokenizer.nextToken();
        // trozo siguiente del delimitador
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

        }
    }

    private void exit() {
        System.out.println("Game Over");
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
        game.setLevel(level);
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

        if (plant.equals("p")) {
            game.addPeashooter(i, j);
        } else if (plant.equals("s")) {
            game.addSunflower(i, j);
        }
    }
}
