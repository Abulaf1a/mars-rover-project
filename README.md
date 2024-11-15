**MARS ROVER README**
# Table of Contents:

# 1. Project Description:
This project simulates a rover on the surface of Mars! The current functionality is very
limited but I intend to expand the project in future to include additional features. 

# 2. Installation Instructions:
1. Fork and clone the repo at https://github.com/Abulaf1a/mars-rover-project.git 
2. Open the project in a java IDE and run the Main class main method 


# 3. Input Instructions:
1. Input two initial numbers when prompted. This will represent the map size. There is currently 
no upper limit on map size, however, maps that are too large will fail to print properly to the
console.
2. Input the rover start position and direction in the following format: <x> <y> <direction>. 
An example string input would be "1 4 N" This represents a rover at position 1 on the x axis and 4 
on the y axis, facing north. 
3. Input a series of instructions to move the rover. The three instruction characters are:
M, L, R for Move, rotate Left and rotate Right respectively. An example instruction would be:
MRRMMMLMMLM which will move the rover one square in the direction it is facing, before rotating
direction to the right twice. The the rover will move three squares in that direction, before
rotating left, moving twice, rotating left again, and moving a final time.

If you're wondering what a compass looks like with right and left directions: 

     L <- N -> R
R          |         L
>          |         <
|          |         |     
W----------*---------E
|          |         |
>          |         <
L          |         R
      R <- S -> L 

Note: The left/right directions are handled as if you are facing in that cardinal direction: 
Left of north is west, right of north if east. 
Left of west south, right of west is north
Left of south is east, right of south is west
Left of east is north, right of east is south. 

**NOTE**
If you input an instruction that would place the rover OFF the edge of the map, it will
simply ignore that instruction, and move on to the next instruction in the list of instructions
If you don't see your rover moving, and it is on either the top, bottom, left or right of the 
map, this is why. 

     
     






