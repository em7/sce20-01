package sce20.cv01;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a learning algorithm 'Delta Rule'.
 */
public class DeltaRule implements LearningAlgorithm{

    private final Neuron neuron;

    private final Double learningRate;

    private final Double targetMse;

    private final int maxEpochs;

    /**
     * Creates a new representation of a learning algorithm 'Delta Rule'.
     *
     * @param neuron input neuron
     * @param learningRate learning rate
     * @param targetMse MSE to stop learning
     * @param maxEpochs maximal number of learning epochs
     */
    public DeltaRule(Neuron neuron, Double learningRate, Double targetMse, int maxEpochs) {
        this.neuron = neuron;
        this.learningRate = learningRate;
        this.targetMse = targetMse;
        this.maxEpochs = maxEpochs;
    }

    @Override
    public void train(List<DataSetRow> trainingSet) {

        int epoch = 0;
        double mse = Double.MAX_VALUE;

        while (epoch < maxEpochs && mse > targetMse) {

            final List<Double> allExpected = new ArrayList<>(trainingSet.size());
            final List<Double> allCalculated = new ArrayList<>(trainingSet.size());

            for (DataSetRow dataSetRow : trainingSet) {
                final double calcOutput = neuron.calculate(dataSetRow.getInputs());
                allCalculated.add(calcOutput);
                allExpected.add(dataSetRow.getOutputs().get(0));
                final double derivative = neuron.derivate();
                final double diff = dataSetRow.getOutputs().get(0) - calcOutput;

                for (int i = 0; i < dataSetRow.getInputs().size(); i++) {
                    final double input = dataSetRow.getInputs().get(i);
                    final double delta = learningRate * diff * derivative * input;
                    neuron.getWeight().set(i, neuron.getWeight().get(i) + delta);
                }

                final double delta = learningRate * diff * derivative;
                neuron.setBias(neuron.getBias() + delta);
            }

            mse = Mse.mse(allExpected, allCalculated);
            epoch++;

            System.out.printf("Epoch %d, MSE %f\n", epoch, mse);
        }
    }
}
