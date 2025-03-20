import unittest
from checkneighbours import get_same_neighbours_ids

class TestFunctions(unittest.TestCase):
    def test_gegevenVoorbeeldgridWith4Height4IndexToCheck5_wanneerGetSameNeighboursIds_dan2en4en10(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 5)
        # Assert
        self.assertEqual(result, [2,4,10])

    def test_gegevenElementInHetMidden_wanneerGetSameNeighboursIdsCalled_danCorrectNeighboursReturned17(self):
        # Arrange
        grid = [ 1, 2, 3,
                4, 2, 6,
                7, 2, 9 ]
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 4)
        # Assert
        self.assertCountEqual(result, [1, 7])

    def test_gegevenElementAanLinkerRand_wanneerGetSameNeighboursIdsCalled_danCorrectNeighboursReturned47(self):
        # Arrange
        grid = [ 1, 2, 3,
                5, 5, 6,
                7, 5, 9 ]
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 3)
        # Assert
        self.assertCountEqual(result, [4, 7])

    def test_gegevenElementAanBovenRand_wanneerGetSameNeighboursIdsCalled_danCorrectNeighboursReturned23(self):
        # Arrange
        grid = [ 1, 3, 3,
                3, 5, 6,
                7, 8, 9 ]
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 1)
        # Assert
        self.assertCountEqual(result, [2, 3])

    def test_gegevenElementInLinkerBovenhoek_wanneerGetSameNeighboursIdsCalled_danCorrectNeighboursReturned13(self):
        # Arrange
        grid = [ 4, 4, 3,
                4, 5, 6,
                7, 8, 9 ]
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 0)
        # Assert
        self.assertCountEqual(result, [1, 3])

    def test_gegevenElementMetGeenMatchendeNeighbours_wanneerGetSameNeighboursIdsCalled_danLegeLijstReturned(self):
        # Arrange
        grid = [ 1, 2, 3,
                4, 5, 6,
                7, 8, 9 ]
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 4)
        # Assert
        self.assertEqual(result, [])

    def test_gegevenElementMetAlleMatchendeNeighbours_wanneerGetSameNeighboursIdsCalled_danAlleNeighboursReturned(self):
        # Arrange
        grid = [ 7, 7, 7,
                7, 7, 7,
                7, 7, 7 ]
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 4)
        # Assert
        self.assertCountEqual(result, [0, 1, 2, 3, 5, 6, 7, 8])

    def test_gegevenOngeldigeGridDimensies_wanneerGetSameNeighboursIdsCalled_danLegeLijstReturned(self):
        # Arrange
        grid = [1, 2, 3, 4, 5, 6, 7, 8]
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 4)
        # Assert
        self.assertEqual(result, [])

    def test_gegevenIndexBuitenBereik_wanneerGetSameNeighboursIdsCalled_danLegeLijstReturned(self):
        # Arrange
        grid = [ 1, 2, 3,
                4, 5, 6,
                7, 8, 9 ]
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 10)
        # Assert
        self.assertEqual(result, [])

    def test_gegevenNullGrid_wanneerGetSameNeighboursIdsCalled_danExceptionGeworpen(self):
        # Arrange
        grid = None
        # Assert
        with self.assertRaises(TypeError) as context:
            # Act
            get_same_neighbours_ids(grid, 3, 3, 4)
        
        self.assertIn("Grid kan niet none zijn", str(context.exception))

if __name__ == '__main__':
    unittest.main()