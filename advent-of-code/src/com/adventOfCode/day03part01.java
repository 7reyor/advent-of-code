package com.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 --- Day 3: Perfectly Spherical Houses in a Vacuum ---

 Santa is delivering presents to an infinite two-dimensional grid of houses.

 He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>), or west (<). After each move, he delivers another present to the house at his new location.

 However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off, and Santa ends up visiting some houses more than once. How many houses receive at least one present?

 For example:

    > delivers presents to 2 houses: one at the starting location, and one to the east.
    ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
    ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.

 day03input.txt

 */
public class day03part01 {

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
        int x = MAX_COORD;
        int y = MAX_COORD;

        // For each instruction
        for(char instruction: input.toCharArray()){

            // Increase present count at starting location by 1
            houseGrid[x][y]++;

            // Depending on direction, increase specific house value by 1
            if (instruction == north){
                y++;
                houseGrid[x][y]++;
            }
            if (instruction == south){
                y--;
                houseGrid[x][y]++;
            }
            if (instruction == west){
                x--;
                houseGrid[x][y]++;
            }
            if (instruction == east){
                x++;
                houseGrid[x][y]++;
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
