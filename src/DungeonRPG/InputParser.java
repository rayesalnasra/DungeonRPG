package DungeonRPG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rayesa
 */

public class InputParser implements java.io.Serializable {
    private ArrayList<String> userInputCommandList;
    private Map<String, Boolean> validCommands;
    private Map<String, Boolean> validTargets;
    private Map<String, Boolean> validDirections;
    private Map<String, Boolean> validItems;
    private PlayerManager playerManager;
    private TextAdventure game;

    /**
     * Constructs a new InputParser object.
     * It initializes the command list, valid commands, valid targets,
     * valid directions, and valid items maps. It also creates a new
     * PlayerManager and stores a reference to the TextAdventure object.
     * @param game the TextAdventure object
     */
    public InputParser(TextAdventure game) {
        this.userInputCommandList = new ArrayList<>();
        this.validCommands = new HashMap<>();
        this.validTargets = new HashMap<>();
        this.validDirections = new HashMap<>();
        this.validItems = new HashMap<>();

        initializeValidCommands();
        initializeValidTargets();
        initializeValidDirections();
        initializeValidItems();

        this.playerManager = new PlayerManager(game);
        this.game = game;
    }

    /**
     * Initializes the valid commands map.
     * It adds the supported commands and their validity status to the map.
     */
    private void initializeValidCommands() {
        validCommands.put("take", true);
        validCommands.put("drop", true);
        validCommands.put("move", true);
        validCommands.put("observe", true);
        validCommands.put("save", true);
        validCommands.put("load", true);
        validCommands.put("check", true);
    }

    /**
     * Initializes the valid targets map.
     * It adds the supported targets and their validity status to the map.
     */
    private void initializeValidTargets() {
        validTargets.put("carrot", true);
        validTargets.put("sausage", true);
        validTargets.put("paper", true);
        validTargets.put("pencil", true);
        validTargets.put("ring", true);
        validTargets.put("wombat", true);
        validTargets.put("north", true);
        validTargets.put("south", true);
        validTargets.put("west", true);
        validTargets.put("east", true);
        validTargets.put("area", true);
        validTargets.put("inventory", true);
        validTargets.put("game", true);
    }

    /**
     * Initializes the valid directions map.
     * It adds the supported directions and their validity status to the map.
     */
    private void initializeValidDirections() {
        validDirections.put("north", true);
        validDirections.put("south", true);
        validDirections.put("west", true);
        validDirections.put("east", true);
    }

    /**
     * Initializes the valid items map.
     * It adds the supported items and their validity status to the map.
     */
    private void initializeValidItems() {
        validItems.put("carrot", true);
        validItems.put("sausage", true);
        validItems.put("paper", true);
        validItems.put("pencil", true);
        validItems.put("ring", true);
        validItems.put("wombat", true);
    }

    /**
     * Runs the user's command and processes the input.
     * It converts the user input to lowercase, splits it into a command list,
     * and then processes the user's action.
     * @param userInput the user's input command
     * @return a message describing the result of the user's action
     */
    public String runCommand(String userInput) {
        String lowerCaseString = userInput.trim().toLowerCase();
        String message = "";

        if (lowerCaseString.equals("")) {
            message = "Please enter a command";
        } else {
            userInputToCommandList(userInput);
            message = processUserCommand();
        }

        return message;
    }

    /**
     * Converts the user's input into a command list.
     * It splits the input string on whitespace and other delimiters, and
     * adds each command to the userInputCommandList.
     * @param userInput the user's input command
     */
    public void userInputToCommandList(String userInput) {
        // Clear the previous list
        this.userInputCommandList.clear();

        String[] commands = userInput.toLowerCase().split("[ \\t,.:;?!\\\"']+");

        for (String command : commands) {
            this.userInputCommandList.add(command);
        }
    }

    /**
     * Processes the user's command.
     * It checks if the user's input is a valid 2-word command, and if so,
     * calls the processUserAction() method to handle the command.
     * @return a message describing the result of the user's action
     */
    public String processUserCommand() {
        String message = "";

        if (userInputCommandList.size() != 2) {
            message = "Only 2 word commands are allowed";
            this.userInputCommandList.clear();
        }

        if (userInputCommandList.size() == 2) {
            message = processUserAction();
        }

        return message;
    }

    /**
     * Processes the user's action.
     * It checks if the command and target are valid, and then performs the
     * appropriate action based on the command and target.
     * @return a message describing the result of the user's action
     */
    public String processUserAction() {
        String command = userInputCommandList.get(0);
        String target = userInputCommandList.get(1);

        String message = "";

        if (!validCommands.containsKey(command)) {
            message = command + " is not a valid command. Valid commands are: "
                    + "take, drop, move, observe, save, load, check";
        }

        if (!validTargets.containsKey(target)) {
            message = target + " is not a valid target. "
                    + "Valid targets are: north, south, west, east, area, "
                    + "inventory, game, as well as any items in the area";
        }

        if (validCommands.containsKey(command) && validTargets.containsKey(target)) {
            if (validDirections.containsKey(target) && command.equals("move")) {
                message = game.movePlayerTo(target);
            }

            if (validItems.containsKey(target) && (command.equals("take") || command.equals("drop"))) {
                if (command.equals("take")) {
                    message = playerManager.grabLoot(target);
                } else if (command.equals("drop")) {
                    message = playerManager.dropLoot(target);
                }
            }

            if (command.equals("observe") && target.equals("area")) {
                message = playerManager.observePlayerLocation();
            }

            if (command.equals("check") && target.equals("inventory")) {
                message = playerManager.checkPlayerInventory();
            }
        }

        this.userInputCommandList.clear();
        return message;
    }
}