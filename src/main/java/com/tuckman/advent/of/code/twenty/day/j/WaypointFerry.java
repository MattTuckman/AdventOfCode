package com.tuckman.advent.of.code.twenty.day.j;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class WaypointFerry {
    private static final Pattern INSTRUCTION_REGEX = Pattern.compile("([A-Z])([0-9]+)");
    private static final List<Character> MOVE_INSTRUCTIONS = Arrays.asList('N', 'S', 'E', 'W');
    private static final List<Character> TURN_INSTRUCTIONS = Arrays.asList('L', 'R');
    private static final List<Character> FORWARD_INSTRUCTIONS = Arrays.asList('F');
    private static int DEG_90 = 90;

    private int x = 0;
    private int y = 0;

    private int waypointX = 10;
    private int waypointY = 1;

    public void interpret(String instructionStr) {
        Matcher mch = INSTRUCTION_REGEX.matcher(instructionStr);

        if (!mch.find()) {
            throw new RuntimeException("Invalid pattern parsed");
        }

        char instruction = mch.group(1).charAt(0);
        int amount = Integer.parseInt(mch.group(2));

        if (MOVE_INSTRUCTIONS.contains(instruction)) {
            interpretMoveInstruction(instruction, amount);
        } else if (TURN_INSTRUCTIONS.contains(instruction)) {
            interpretTurnInstruction(instruction, amount);
        } else if (FORWARD_INSTRUCTIONS.contains(instruction)) {
            forward(amount);
        } else {
            throw new RuntimeException("No known instruction found");
        }

        System.out.println("X: " + x + ", Y: " + y + ", wayX: " + waypointX + ", wayY: " + waypointY);
    }

    private void interpretMoveInstruction(char instruction, int amount) {
        switch (instruction) {
            case 'N': move(0, amount);
                System.out.println("Moving north " + amount);
                break;
            case 'S': move(0, -amount);
                System.out.println("Moving south " + amount);
                break;
            case 'E': move(amount, 0);
                System.out.println("Moving east " + amount);
                break;
            case 'W': move(-amount, 0);
                System.out.println("Moving west " + amount);
                break;
            default: throw new RuntimeException("No move instruction match.");
        }
    }

    private void move(int xOffset, int yOffset) {
        waypointX += xOffset;
        waypointY += yOffset;
    }

    private void interpretTurnInstruction(char instruction, int amount) {
        switch (instruction) {
            case 'R': turn(1, amount);
                System.out.println("Turned right " + amount + "degrees.");
                break;
            case 'L': turn(-1, amount);
                System.out.println("Turned left " + amount + "degrees.");
                break;
            default: throw new RuntimeException("No turn instruction match.");
        }
    }

    private void forward(int amount) {
        System.out.println("Moving forward " + amount + "x");
        x += amount * waypointX;
        y += amount * waypointY;
    }

    private void turn(int direction, int deg) {
        if (deg % DEG_90 != 0) {
            throw new RuntimeException("We going to have to use trig!");
        }

        switch (deg * direction) {
            case 90:
            case -270:
                int temp = waypointX;
                waypointX = waypointY;
                waypointY = -temp;
                break;
            case -90:
            case 270:
                int temp2 = waypointX;
                waypointX = -waypointY;
                waypointY = temp2;
                break;
            case 180:
            case -180:
                waypointX = -waypointX;
                waypointY = -waypointY;
                break;
            default:
                throw new RuntimeException("Unexpected rotation amount");
        }
    }
}
