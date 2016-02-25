package com.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 --- Part Two ---

 The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents with him.

 Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take turns moving based on instructions from the elf, who is eggnoggedly reading from the same script as the previous year.

 This year, how many houses receive at least one present?

 For example:

    ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
    ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
    ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.

 */
public class day03part02 {

    public static void main(String[] args) throws IOException {

        String input = new String(Files.readAllBytes(Paths.get("C:\\Users\\wavefunction\\IdeaProjects\\advent-of-code\\src\\com\\adventOfCode\\day03input.txt")));

        // Any coordinate can be at most the length of the input string.
        // Thus, the array should be able to handle at most twice the length if the input.
        final int MAX_COORD = input.length();

        int[][] houseGrid = new int[MAX_COORD*2][MAX_COORD*2];

        char north = "^".charAt(0);
        char south = "v".charAt(0);
        char west = "<".charAt(0);
        char east = ">".charAt(0);

        // Let santa start at the "origin"
        int santa_x = MAX_COORD;
        int santa_y = MAX_COORD;
        // Let robo-santa also start at the "origin"
        int robo_santa_x = MAX_COORD;
        int robo_santa_y = MAX_COORD;

        // For each instruction
        boolean useRoboSanta = false;
        for(char instruction: input.toCharArray()){

            if(useRoboSanta){
                // We will use robot santa this iteration
                // Place present at starting location
                houseGrid[robo_santa_x][robo_santa_y]++;

                // Instruction dependent cases
                if(instruction == north){
                    robo_santa_y++;
                    houseGrid[robo_santa_x][robo_santa_y]++;
                }
                if(instruction == south){
                    robo_santa_y--;
                    houseGrid[robo_santa_x][robo_santa_y]++;
                }
                if(instruction == west){
                    robo_santa_x--;
                    houseGrid[robo_santa_x][robo_santa_y]++;
                }
                if(instruction == east){
                    robo_santa_x++;
                    houseGrid[robo_santa_x][robo_santa_y]++;
                }
                // Don't use robot santa next loop
                useRoboSanta = false;
            }
            else {
                // We will use regular santa this iteration
                // Place present at starting location
                houseGrid[santa_x][santa_y]++;

                // Instruction dependent cases
                if (instruction == north) {
                    santa_y++;
                    houseGrid[santa_x][santa_y]++;
                }
                if (instruction == south) {
                    santa_y--;
                    houseGrid[santa_x][santa_y]++;
                }
                if (instruction == west) {
                    santa_x--;
                    houseGrid[santa_x][santa_y]++;
                }
                if (instruction == east) {
                    santa_x++;
                    houseGrid[santa_x][santa_y]++;
                }
                // Use robot santa next loop
                useRoboSanta = true;
            }
        }

        // Loop through houseGrid and find houses with at least one present
        int result = 0;
        for(int i=0; i<(MAX_COORD*2); i++){
            for(int j=0; j<(MAX_COORD*2); j++){
                if(houseGrid[i][j] >= 1)
                    result++;
            }
        }

        System.out.println(result);
    }

}
