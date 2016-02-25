package com.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 --- Part Two ---

 Now, given the same instructions, find the position of the first character that causes him to enter the basement (floor -1). The first character in the instructions has position 1, the second character has position 2, and so on.

 For example:

    ) causes him to enter the basement at character position 1.
    ()()) causes him to enter the basement at character position 5.

 What is the position of the character that causes Santa to first enter the basement?

 */
public class day01part02 {

    public static void main(String[] args) throws IOException {

        String input = new String(Files.readAllBytes(Paths.get("C:\\Users\\wavefunction\\IdeaProjects\\advent-of-code\\src\\com\\adventOfCode\\day01input.txt")));


        char up = "(".charAt(0);
        char down = ")".charAt(0);
        int floor = 0;
        int charPos = 1;

        for(char instruction: input.toCharArray()){

            if(floor == 0 && instruction == down){
                // This is the only thing we care about
                System.out.println(charPos);
                floor--;
            }
            if (instruction == up)
                floor++;
            if (instruction == down)
                floor--;

            charPos++;

        }


    }

}
