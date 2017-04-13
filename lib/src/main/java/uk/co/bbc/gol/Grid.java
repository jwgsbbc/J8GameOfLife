package uk.co.bbc.gol;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Grid {
    private final Set<Cell> cells;

    public Grid(Set<Cell> cells) {
        this.cells = cells;
    }

    public boolean contains(Cell cell) {
        return cells.contains(cell);
    }

    public Grid evolve() {
        final Map<Cell, Long> neighbourCountMap = cells
                .stream()
                .flatMap(Grid::getNeighboursStream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final Set<Cell> nextGen = neighbourCountMap.entrySet().stream()
                .filter(this::willBeAliveInNextGen)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        return new Grid(nextGen);
    }

    private boolean willBeAliveInNextGen(Map.Entry<Cell, Long> entry) {
        final Cell cell = entry.getKey();
        final Long neighbourCount = entry.getValue();
        return neighbourCount == 3 || (cells.contains(cell) && neighbourCount == 2);
    }

    private static Stream<Cell> getNeighboursStream(Cell cell) {
        return cell.getNeighbours().stream();
    }
}
