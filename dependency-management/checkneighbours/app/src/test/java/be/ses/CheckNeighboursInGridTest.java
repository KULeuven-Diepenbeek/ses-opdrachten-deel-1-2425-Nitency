package be.ses;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class CheckNeighboursInGridTest {

    @Test
    public void gegevenElementInHetMidden_wanneerGetSameNeighboursIdsCalled_danCorrectNeighboursReturned17() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            1, 2, 3,
            4, 2, 6,
            7, 2, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4; // Middle element with value 2

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Assert
        assertThat(result).containsExactlyInAnyOrder(1, 7)
            .withFailMessage("Verwachte neighbors met dezelfde waarde (2) op posities 1 and 7");
    }

    @Test
    public void gegevenElementAanLinkerRand_wanneerGetSameNeighboursIdsCalled_danCorrectNeighboursReturned47() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            1, 2, 3,
            5, 5, 6,
            7, 5, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 3; // Left edge element with value 5

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Assert
        assertThat(result).containsExactlyInAnyOrder(4, 7)
            .withFailMessage("Verwachte neighbors met dezelfde waarde (5) op posities 4 and 7");
    }

    @Test
    public void gegevenElementAanBovenRand_wanneerGetSameNeighboursIdsCalled_danCorrectNeighboursReturned23() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            1, 3, 3,
            3, 5, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 1; // Top edge element with value 3

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Assert
        assertThat(result).containsExactlyInAnyOrder(2, 3)
            .withFailMessage("Verwachte neighbors met dezelfde waarde (3) op posities 2 and 3");
    }

    @Test
    public void gegevenElementInLinkerBovenhoek_wanneerGetSameNeighboursIdsCalled_danCorrectNeighboursReturned13() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            4, 4, 3,
            4, 5, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 0; // Top-left corner element with value 4

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Assert
        assertThat(result).containsExactlyInAnyOrder(1, 3)
            .withFailMessage("Verwachte neighbors met dezelfde waarde (4) op posities 1 and 3");
    }

    @Test
    public void gegevenElementMetGeenMatchendeNeighbours_wanneerGetSameNeighboursIdsCalled_danLegeLijstReturned() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4; // Middle element with no matching neighbors

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Assert
        assertThat(result).withFailMessage("Verwachte lege lijst wanneer geen neighbors matchen")
            .isEmpty();
    }

    @Test
    public void gegevenElementMetAlleMatchendeNeighbours_wanneerGetSameNeighboursIdsCalled_danAlleNeighboursReturned() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            7, 7, 7,
            7, 7, 7,
            7, 7, 7
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4; // Middle element with all matching neighbors

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Assert
        assertThat(result).containsExactlyInAnyOrder(0, 1, 2, 3, 5, 6, 7, 8)
            .withFailMessage("Verwachte alle neighbours gereturned als ze allemaal matchen");
    }

    @Test
    public void gegevenOngeldigeGridDimensies_wanneerGetSameNeighboursIdsCalled_danLegeLijstReturned() {
        // Arrange
        List<Integer> grid = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int width = 3;
        int height = 3; // Should be 9 elements for 3x3, but we provide only 8
        int indexToCheck = 4;

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Assert
        assertThat(result).withFailMessage("Verwachte lege lijst wanneer grid dimensies fout zijn")
            .isEmpty();
    }

    @Test
    public void gegevenIndexBuitenBereik_wanneerGetSameNeighboursIdsCalled_danLegeLijstReturned() {
        // Arrange
        List<Integer> grid = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int width = 3;
        int height = 3;
        int indexToCheck = 10; // Out of bounds index

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Assert
        assertThat(result).withFailMessage("Verwachte lege lijst wanneer index buiten de array ligt")
            .isEmpty();
    }
}