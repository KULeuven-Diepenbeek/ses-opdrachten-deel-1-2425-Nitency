package be.ses;

import java.util.ArrayList;
import java.util.List;

public class CheckNeighboursInGrid {
    /**
     * This method takes a 1D Iterable and an element in the array and gives back an iterable containing the indexes of all neighbours with the same value as the specified element
     * @return - Returns a 1D Iterable of ints, the Integers represent the indexes of all neighbours with the same value as the specified element on index 'indexToCheck'.
     * @param grid - This is a 1D Iterable containing all elements of the grid. The elements are integers.
     * @param width - Specifies the width of the grid.
     * @param height - Specifies the height of the grid (extra for checking if 1D grid is complete given the specified width)
     * @param indexToCheck - Specifies the index of the element which neighbours that need to be checked
     */
    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid, int width, int height, int indexToCheck) {
        if (grid == null) {
            throw new NullPointerException("Grid kan niet null zijn");
        }
        
        List<Integer> result = new ArrayList<>();
        List<Integer> gridList = convertIterableToList(grid);

        if (gridList.size() != width * height || indexToCheck < 0 || indexToCheck >= gridList.size()) {
            return result;
        }
        
        int valueToCheck = gridList.get(indexToCheck);
        
        int row = indexToCheck / width;
        int col = indexToCheck % width;
        
        checkAndAddNeighbor(gridList, width, row-1, col-1, valueToCheck, result);
        checkAndAddNeighbor(gridList, width, row-1, col, valueToCheck, result);
        checkAndAddNeighbor(gridList, width, row-1, col+1, valueToCheck, result);
        checkAndAddNeighbor(gridList, width, row, col-1, valueToCheck, result);
        checkAndAddNeighbor(gridList, width, row, col+1, valueToCheck, result);
        checkAndAddNeighbor(gridList, width, row+1, col-1, valueToCheck, result);
        checkAndAddNeighbor(gridList, width, row+1, col, valueToCheck, result);
        checkAndAddNeighbor(gridList, width, row+1, col+1, valueToCheck, result);
        
        return result;
    }
    
    // Helper method to convert Iterable<Integer> to List<Integer>
    private static List<Integer> convertIterableToList(Iterable<Integer> iterable) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : iterable) {
            list.add(i);
        }
        return list;
    }

    private static void checkAndAddNeighbor(List<Integer> grid, int width, int row, int col, int valueToCheck, List<Integer> result) {
        // Check of coordinaten bestaan
        if (row >= 0 && col >= 0 && row < grid.size() / width && col < width) {
            int neighborIndex = row * width + col;
            // Check als neighbor zelfde waarde is
            if (grid.get(neighborIndex) == valueToCheck) {
                result.add(neighborIndex);
            }
        }
    }
}