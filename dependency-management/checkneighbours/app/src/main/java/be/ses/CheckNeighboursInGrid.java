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
        List<Integer> result = new ArrayList<>();
        List<Integer> gridList = convertIterableToList(grid);
        
        // Validate input parameters
        if (gridList.size() != width * height || indexToCheck < 0 || indexToCheck >= gridList.size()) {
            return result; // Return empty list for invalid input
        }
        
        // Get the value of the element at indexToCheck
        int valueToCheck = gridList.get(indexToCheck);
        
        // Calculate the row and column of the element
        int row = indexToCheck / width;
        int col = indexToCheck % width;
        
        // Check the 8 possible neighbors (if they exist)
        // Top-left
        checkAndAddNeighbor(gridList, width, row-1, col-1, valueToCheck, result);
        // Top
        checkAndAddNeighbor(gridList, width, row-1, col, valueToCheck, result);
        // Top-right
        checkAndAddNeighbor(gridList, width, row-1, col+1, valueToCheck, result);
        // Left
        checkAndAddNeighbor(gridList, width, row, col-1, valueToCheck, result);
        // Right
        checkAndAddNeighbor(gridList, width, row, col+1, valueToCheck, result);
        // Bottom-left
        checkAndAddNeighbor(gridList, width, row+1, col-1, valueToCheck, result);
        // Bottom
        checkAndAddNeighbor(gridList, width, row+1, col, valueToCheck, result);
        // Bottom-right
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
    
    // Helper method to check if a neighbor exists, has the same value, and add its index to the result
    private static void checkAndAddNeighbor(List<Integer> grid, int width, int row, int col, int valueToCheck, List<Integer> result) {
        // Check if the neighbor coordinates are valid
        if (row >= 0 && col >= 0 && row < grid.size() / width && col < width) {
            int neighborIndex = row * width + col;
            // Check if the neighbor has the same value
            if (grid.get(neighborIndex) == valueToCheck) {
                result.add(neighborIndex);
            }
        }
    }
}