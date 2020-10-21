package sce20.cv01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class MainDeltaRule
{
    public static void main( String[] args )
    {
        Random random = new Random();
        List<DataSetRow> dataSet = createOrDataSet();
        //List<DataSetRow> dataSet = createXorDataSet();

        Neuron neuron = new Neuron(Arrays.asList(random.nextDouble(), random.nextDouble()),
                    0.0,
                    new TanhFunction(1.0));

        System.out.printf("Original values\n[input], [expected] -> [neuron output]\n");
        for (DataSetRow row : dataSet) {
            final Double calculated = neuron.calculate(row.getInputs());
            printRow(row, Collections.singletonList(calculated));
        }

        DeltaRule deltaRule = new DeltaRule(neuron, 0.2, 0.005, 2500);
        deltaRule.train(dataSet);

        System.out.printf("Original values\n[input], [expected] -> [neuron output]\n");

        for (DataSetRow row : dataSet) {
            final Double calculated = neuron.calculate(row.getInputs());
            printRow(row, Collections.singletonList(calculated));
        }
    }

    private static void printRow(DataSetRow dataSetRow, List<Double> calculated) {
        System.out.printf("%s, %s -> %s\n", dataSetRow.getInputs(), dataSetRow.getOutputs(), calculated);
    }

    private static List<DataSetRow> createOrDataSet() {
        List<DataSetRow> dataSet = new ArrayList<>(4);

        dataSet.add(new DataSetRow(
                new ArrayList<>(Arrays.asList(0.0, 0.0)),
                Collections.singletonList(0.0)
        ));

        dataSet.add(new DataSetRow(
                new ArrayList<>(Arrays.asList(1.0, 0.0)),
                Collections.singletonList(1.0)
        ));

        dataSet.add(new DataSetRow(
                new ArrayList<>(Arrays.asList(0.0, 1.0)),
                Collections.singletonList(1.0)
        ));

        dataSet.add(new DataSetRow(
                new ArrayList<>(Arrays.asList(1.0, 1.0)),
                Collections.singletonList(1.0)
        ));

        return dataSet;
    }

    private static List<DataSetRow> createXorDataSet() {
        List<DataSetRow> dataSet = new ArrayList<>(4);

        dataSet.add(new DataSetRow(
                new ArrayList<>(Arrays.asList(0.0, 0.0)),
                Collections.singletonList(0.0)
        ));

        dataSet.add(new DataSetRow(
                new ArrayList<>(Arrays.asList(1.0, 0.0)),
                Collections.singletonList(1.0)
        ));

        dataSet.add(new DataSetRow(
                new ArrayList<>(Arrays.asList(0.0, 1.0)),
                Collections.singletonList(1.0)
        ));

        dataSet.add(new DataSetRow(
                new ArrayList<>(Arrays.asList(1.0, 1.0)),
                Collections.singletonList(0.0)
        ));

        return dataSet;
    }
}
