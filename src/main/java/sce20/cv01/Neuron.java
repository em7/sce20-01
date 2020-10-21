package sce20.cv01;

import java.util.List;
import java.util.stream.IntStream;

/**
 * A general representation of a neuron in an arbitrary layer
 */
public class Neuron {

    /**
     * Input values of this neuron.
     * <p>
     * Should have the same size as {@link #weight}
     */
    private List<Double> input;

    /**
     * Weights for input values of this neuron.
     * <p>
     * Should have the same size as {@link #input}
     */
    private List<Double> weight;

    /**
     * Bias value of this neuron
     */
    private Double bias;

    /**
     * Activation function for this neuron
     */
    private ActivationFunction activationFunction;

    /**
     * Output value of this neuron
     */
    private Double output = 0.0;

    /**
     * Creates a new arbitrary neuron
     *
     * @param weight                initial weights
     * @param bias                  initial bias
     * @param activationFunction    activation function
     */
    public Neuron(List<Double> weight, Double bias, ActivationFunction activationFunction) {
        this.weight = weight;
        this.bias = bias;
        this.activationFunction = activationFunction;
    }

    /**
     * Calculates the output value of this neuron, stores it to {@link #output} and returns it
     *
     * @return The output value of this neuron.
     * @throws RuntimeException When input and weight lists are not the same size
     */
    public Double calculate() {
        if (getInput().size() != getWeight().size()) {
            throw new RuntimeException("Input and weight lists should have the same size.");
        }

        final double weightedSum = IntStream.range(0, getInput().size())
                .mapToDouble(i -> getInput().get(i) * getWeight().get(i))
                .sum();

        output = activationFunction.value(weightedSum + bias);
        return output;
    }

    /**
     * Sets the new inputs of this neuron,
     * calculates the output value of this neuron, stores it to {@link #output} and returns it
     *
     * @param input new inputs for this neuron, are stored in {@link #input}.
     * @return The output value of this neuron.
     * @throws RuntimeException When input and weight lists are not the same size
     */
    public Double calculate(List<Double> input) {
        setInput(input);
        calculate();
        return getOutput();
    }

    /**
     * Calculates the derivative value of this neuron
     *
     * @return The calculated derivative.
     * @throws RuntimeException When input and weight lists are not the same size
     */
    public Double derivate() {
        if (getInput().size() != getWeight().size()) {
            throw new RuntimeException("Input and weight lists should have the same size.");
        }

        final double weightedSum = IntStream.range(0, getInput().size())
                .mapToDouble(i -> getInput().get(i) * getWeight().get(i))
                .sum();

        final double derivative = activationFunction.derivative(weightedSum + bias);
        return derivative;
    }

    /**
     * Input values of this neuron.
     * <p>
     * Should have the same size as {@link #weight}
     */
    public List<Double> getInput() {
        return input;
    }

    /**
     * Input values of this neuron.
     * <p>
     * Should have the same size as {@link #weight}
     */
    public void setInput(List<Double> input) {
        this.input = input;
    }

    /**
     * Weights for input values of this neuron.
     * <p>
     * Should have the same size as {@link #input}
     */
    public List<Double> getWeight() {
        return weight;
    }

    /**
     * Weights for input values of this neuron.
     * <p>
     * Should have the same size as {@link #input}
     */
    public void setWeight(List<Double> weight) {
        this.weight = weight;
    }

    /**
     * Bias value of this neuron
     */
    public Double getBias() {
        return bias;
    }

    /**
     * Bias value of this neuron
     */
    public void setBias(Double bias) {
        this.bias = bias;
    }

    /**
     * Activation function for this neuron
     */
    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    /**
     * Activation function for this neuron
     */
    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    /**
     * Output value of this neuron
     */
    public Double getOutput() {
        return output;
    }
}
