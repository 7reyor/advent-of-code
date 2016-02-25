package com.adventOfCode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 --- Day 2: I Was Told There Would Be No Math ---

 The elves are running low on wrapping paper, and so they need to submit an order for more. They have a list of the dimensions (length l, width w, and height h) of each present, and only want to order exactly as much as they need.

 Fortunately, every present is a box (a perfect right rectangular prism), which makes calculating the required wrapping paper for each gift a little easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l. The elves also need a little extra paper for each present: the area of the smallest side.

 For example:

 A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of wrapping paper plus 6 square feet of slack, for a total of 58 square feet.
 A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of wrapping paper plus 1 square foot of slack, for a total of 43 square feet.
 All numbers in the elves' list are in feet. How many total square feet of wrapping paper should they order?

 day02input.txt

 */
public class day02part01 {


    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\wavefunction\\IdeaProjects\\advent-of-code\\src\\com\\adventOfCode\\day02input.txt";

        List<String> list = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        String[] input =  list.toArray(new String[list.size()]);
        int result = 0;

        for(int i=0; i<input.length; i++ ){

            // Split string into l, w, and h
            String[] dimension_array = input[i].split("x");
            int l = Integer.parseInt(dimension_array[0]);
            int w = Integer.parseInt(dimension_array[1]);
            int h = Integer.parseInt(dimension_array[2]);

            // Get area of box
            int lw = l*w;
            int wh = w*h;
            int hl = h*l;
            int area = 2*(lw + wh + hl);

            // Get minimum
            int min = minimum(lw, wh, hl);

            int boxCost = min + area;
            result += boxCost;

        }


        System.out.println(result);
    }

    public static int minimum(int x, int y, int z){
        if(y<x)
            x=y;
        if(z<x)
            x=z;
        return x;
    }


}
