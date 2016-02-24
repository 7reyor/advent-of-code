package com.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 --- Day 1: Not Quite Lisp ---

 Santa was hoping for a white Christmas, but his weather machine's "snow" function is powered by stars, and he's fresh out! To save Christmas, he needs you to collect fifty stars by December 25th.

 Collect stars by helping Santa solve puzzles. Two puzzles will be made available on each day in the advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

 Here's an easy puzzle to warm you up.

 Santa is trying to deliver presents in a large apartment building, but he can't find the right floor - the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows the instructions one character at a time.

 An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.

 The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.

 For example:

    (()) and ()() both result in floor 0.
    ((( and (()(()( both result in floor 3.
    ))((((( also results in floor 3.
    ()) and ))( both result in floor -1 (the first basement level).
    ))) and )())()) both result in floor -3.

 To what floor do the instructions take Santa?

 day1.txt

 */

public class day1 {

    public static void main(String[] args) throws IOException {

        String input = new String(Files.readAllBytes(Paths.get("C:\\Users\\wavefunction\\IdeaProjects\\advent-of-code\\src\\com\\adventOfCode\\inputDay01.txt")));


        char up = "(".charAt(0);
        char down = ")".charAt(0);
        int floor = 0;

        for(char instruction: input.toCharArray()){

            if (instruction == up)
                floor++;
            if (instruction == down)
                floor--;

        }

        System.out.println(floor);


    }

}