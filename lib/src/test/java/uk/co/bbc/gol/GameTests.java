package uk.co.bbc.gol;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTests {

    @Test
    public void testThatASingleCellDies() throws Exception {
        final Grid firstGen = createGrid(Cell.at(0,0));
        final Grid secondGen = firstGen.evolve();
        assertFalse(secondGen.contains(Cell.at(0,0)));
    }

    @Test
    public void testThatACellWithOneNeighbourDies() throws Exception {
        final Grid firstGen = createGrid(
                Cell.at(0, 0),
                Cell.at(1, 0));
        final Grid secondGen = firstGen.evolve();
        assertFalse(secondGen.contains(Cell.at(0, 0)));
    }

    @Test
    public void testThatACellWithTwoNeighboursSurvives() throws Exception {
        final Grid firstGen = createGrid(
                Cell.at(0, 0),
                Cell.at(0, 1),
                Cell.at(1, 0));
        final Grid secondGen = firstGen.evolve();
        assertTrue(secondGen.contains(Cell.at(0,0)));
    }

    @Test
    public void testThatACellWithFourNeighboursDies() throws Exception {
        final Grid firstGen = createGrid(
                Cell.at(1, 1),
                Cell.at(0, 0),
                Cell.at(1, 0),
                Cell.at(2, 0),
                Cell.at(0, 1));
        final Grid secondGen = firstGen.evolve();
        assertFalse(secondGen.contains(Cell.at(1,1)));
    }

    @Test
    public void testThatADeadCellWith3NeighboursIsBorn() throws Exception {
        final Grid firstGen = createGrid(
                Cell.at(1, 0),
                Cell.at(2, 0),
                Cell.at(0, 1));
        final Grid secondGen = firstGen.evolve();
        assertTrue(secondGen.contains(Cell.at(1,1)));
    }

    private Grid createGrid(Cell ... cells) {
        return new Grid(new HashSet<>(Arrays.asList(cells)));
    }
}