package uk.co.bbc.gol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

class Cell {

    private final int x;
    private final int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Cell at(int x, int y) {
        return new Cell(x,y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        return y == cell.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    HashSet<Cell> getNeighbours() {
        return new HashSet<>(Arrays.asList(
                Cell.at(x-1, y-1),
                Cell.at(x,   y-1),
                Cell.at(x+1, y-1),
                Cell.at(x-1, y  ),
                Cell.at(x+1, y  ),
                Cell.at(x-1, y+1),
                Cell.at(x  , y+1),
                Cell.at(x+1, y+1)
        ));
    }
}
