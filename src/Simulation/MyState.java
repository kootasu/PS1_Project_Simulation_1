package Simulation;

import java.util.ArrayList;

public class MyState {

    private String name;
    private int timeFrame;
    private int localTimeFrame;
    private double workEnergy;
    private ArrayList<MyState> inputs;
    private ArrayList<MyState> outputs;

    public MyState(String name, int timeFrame) {
        this.name = name;
        this.timeFrame = timeFrame;
        localTimeFrame = 0;
        workEnergy = 0;
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTimeFrame() {
        return timeFrame;
    }

    public int getLocalTimeFrame() {
        return localTimeFrame;
    }

    public void setLocalTimeFrame(int localTimeFrame) {
        this.localTimeFrame = localTimeFrame;
    }

    public double getWorkEnergy() {
        return workEnergy;
    }

    public void setWorkEnergy(double workEnergy) {
        this.workEnergy = workEnergy;
    }

    public ArrayList<MyState> getInputs() {
        return inputs;
    }

    public ArrayList<MyState> getOutputs() {
        return outputs;
    }

}
