package sce20.cv01;

/**
 * Interface representing an activation function applicable to a neuron
 */
public interface ActivationFunction {

    /**
     * Computes the value of the function for given input
     *
     * @param input the input value to the activation function (weighted sum + bias)
     * @return function output
     */
    Double value(Double input);

    /**
     * Computes the value of the derivative of the function
     *
     * @param input the input value to the function (weighted sum + bias)
     * @return derivative function output
     */
    Double derivative(Double input);
}
