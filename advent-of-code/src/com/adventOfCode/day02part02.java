package com.adventOfCode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 --- Part Two ---

 The elves are also running low on ribbon. Ribbon is all the same width, so they only have to worry about the length they need to order, which they would again like to be exact.

 The ribbon required to wrap a present is the shortest distance around its sides, or the smallest perimeter of any one face. Each present also requires a bow made out of ribbon as well; the feet of ribbon required for the perfect bow is equal to the cubic feet of volume of the present. Don't ask how they tie the bow, though; they'll never tell.

 For example:

 A present with dimensions 2x3x4 requires 2+2+3+3 = 10 feet of ribbon to wrap the present plus 2*3*4 = 24 feet of ribbon for the bow, for a total of 34 feet.
 A present with dimensions 1x1x10 requires 1+1+1+1 = 4 feet of ribbon to wrap the present plus 1*1*10 = 10 feet of ribbon for the bow, for a total of 14 feet.
 How many total feet of ribbon should they order?


 */
public class day02part02 {


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

            // Get volume of box
            int vol = l*w*h;

            // Find minimum perimeter around any given face
            int lw = l*w;
            int wh = w*h;
            int hl = h*l;
            int minSide = minimum(lw, wh, hl);
            int minDimension = minimum(l, w, h);
            int perimeter = (2*minSide/minDimension) + 2*minDimension;

            int boxCost = perimeter + vol;
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
