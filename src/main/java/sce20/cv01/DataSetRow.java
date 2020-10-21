package sce20.cv01;

import java.util.List;

/**
 * Represents a pair of input and expected output in a data set.
 */
public class DataSetRow {

    /**
     * Input values
     */
    private final List<Double> inputs;

    /**
     * Output or expected values
     */
    private final List<Double> outputs;

    /**
     * Creates a new dataset row
     *
     * @param inputs input values
     * @param outputs output or expected values
     */
    public DataSetRow(List<Double> inputs, List<Double> outputs) {
        this.inputs = inputs;
        this.outputs = outputs;
    }

    /**
     * Gets the input values
     */
    public List<Double> getInputs() {
        return inputs;
    }

    /**
     * Gets the output or expected values
     */
    public List<Double> getOutputs() {
        return outputs;
    }
}
