# J8GameOfLife

## Solution

https://www.youtube.com/watch?v=6_tsZ1y6WVk&list=PLzj8N0bHraZB4soO1QPlmW5JKIPHc14gj

https://github.com/jwgsbbc/J8GameOfLife/commit/54c3c5a8ca8f5e3c21603aab76560e31e911d873

## Setup

The bare (no solution) setup can be accessed at this commit: 

https://github.com/jwgsbbc/J8GameOfLife/commit/fe3018bc6903ca223f929b10488ae9c83ccf61e1

Since we're using Java 8 all the code needs to go in the Java 8 lib (/lib). There is a main and an example test in there.

## Implementation Rules

No assignment, only initialisation.

This means:
* No for loops with e.g. i++
* No array[x] = y
* No .set(x)
* Only final variables
* Only final fields
* Only immutable data structures

## Game Rules

The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or dead, or "populated" or "unpopulated". Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:

* Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
* Any live cell with two or three live neighbours lives on to the next generation.
* Any live cell with more than three live neighbours dies, as if by overpopulation.
* Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

## Proof of concept

10 iterations of the ‘Toad’, or some other more interesting pattern:

https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#/media/File:Game_of_life_toad.gif

