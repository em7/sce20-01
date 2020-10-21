package sce20.cv01;

/**
 * Hyperbolic tangent as an activation function
 */
public class TanhFunction  implements ActivationFunction{

    private final Double coefficient;

    /**
     * Creates a new hyperbolic tangent activation function where the input value is
     * multiplied by a given coeficient.
     *
     * @param coefficient number the input should be multiplied by
     */
    public TanhFunction(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public Double value(Double input) {
        final double exp = Math.exp(-coefficient * input);
        return (1.0 - exp) / (1.0 + exp);
    }

    @Override
    public Double derivative(Double input) {
        return (1.0) - Math.pow(value(input), 2.0);
    }
}
