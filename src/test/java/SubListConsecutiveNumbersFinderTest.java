import org.junit.Assert;
import org.junit.Test;

public class SubListConsecutiveNumbersFinderTest {

    @Test
    public void shouldReturnOne() {
        // Arrange
        int[] input = new int[] { 1, 6 };
        int[] input2 = new int[] { 2, 6, 1 };

        // Act
        SubListConsecutiveNumbersFinder subListConsecutiveNumbersFinder = new SubListConsecutiveNumbersFinder();

        int result = subListConsecutiveNumbersFinder.calculateSubarray(input);
        int result2 = subListConsecutiveNumbersFinder.calculateSubarray(input2);

        // Assert
        Assert.assertEquals(1, result);
        Assert.assertEquals(1, result2);
    }

    @Test
    public void shouldReturnTwo() {
        // Arrange
        int[] input = new int[] { 1, 2 };

        // Act
        int result = new SubListConsecutiveNumbersFinder().calculateSubarray(input);

        // Assert
        Assert.assertEquals(2, result);

    }

    @Test
    public void shouldReturnFour() {
        // Arrange
        int[] input = new int[] { 10, 5, 2, 3, 4 };

        // Act
        SubListConsecutiveNumbersFinder subListConsecutiveNumbersFinder = new SubListConsecutiveNumbersFinder();

        int result = subListConsecutiveNumbersFinder.calculateSubarray(input);

        // Assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void shouldReturnSix() {
        // Arrange
        int[] input = new int[] { 1, 3, 4, 6, 2, 5, 10, 7, 8  };

        // Act
        SubListConsecutiveNumbersFinder subListConsecutiveNumbersFinder = new SubListConsecutiveNumbersFinder();

        int result = subListConsecutiveNumbersFinder.calculateSubarray(input);

        // Assert
        Assert.assertEquals(6, result);
    }

    @Test
    public void shouldReturnTen() {
        // Arrange
        int[] input = new int[] { 1, 3, 4, 6, 2, 5, 10, 7, 8, 9 };

        // Act
        SubListConsecutiveNumbersFinder subListConsecutiveNumbersFinder = new SubListConsecutiveNumbersFinder();

        int result = subListConsecutiveNumbersFinder.calculateSubarray(input);

        // Assert
        Assert.assertEquals(10, result);
    }

}
