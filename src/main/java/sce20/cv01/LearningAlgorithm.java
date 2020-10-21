package sce20.cv01;

import java.util.List;

/**
 * The algorithm to train networks.
 */
public interface LearningAlgorithm {

    /**
     * Completely trains the network using a training data set.
     *
     * @param trainingSet dataset do be used for training
     */
    void train(List<DataSetRow> trainingSet);
}
