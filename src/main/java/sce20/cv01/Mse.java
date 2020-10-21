package sce20.cv01;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Mse calculation
 */
public class Mse {

    /**
     * Computes mean squared errors from expected and calculated values.
     *
     * @param expectedValues values that are expected
     * @param calculatedValues values that are calculated
     * @return mse
     * @throws RuntimeException when expectedValues and calculatedValues have different sizes
     */
    public static double mse(List<Double> expectedValues, List<Double> calculatedValues){
        if (expectedValues.size() != calculatedValues.size()) {
            throw new RuntimeException("expectedValues and calculatedValues should have the same size.");
        }

        final double mse = IntStream.range(0, expectedValues.size())
                .mapToDouble(i -> Math.pow(expectedValues.get(i) - calculatedValues.get(i), 2))
                .average().orElse(0);
        return mse;
    }

}
