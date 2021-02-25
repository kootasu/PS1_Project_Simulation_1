package Simulation;

import java.lang.management.MemoryUsage;
import java.util.ArrayList;

public class MyStateCreator {

    // TODO: Make more generic. Should be easy to use different states to simulate different projects

    public static ArrayList<MyState> createMyStateArrayList() {
        ArrayList<MyState> myStateArrayList = new ArrayList<>();

        // Make all states
        myStateArrayList.add(new MyState("Communication", 1));
        myStateArrayList.add(new MyState("Planning", 2));
        myStateArrayList.add(new MyState("Modelling", 2));
        myStateArrayList.add(new MyState("Construction", 4));
        myStateArrayList.add(new MyState("Deployment", 1));

        // Inputs and outputs for Communication
        myStateArrayList.get(0).getInputs().add(myStateArrayList.get(1));
        myStateArrayList.get(0).getInputs().add(myStateArrayList.get(3));
        myStateArrayList.get(0).getOutputs().add(myStateArrayList.get(1));

        // Inputs and outputs for Planning
        myStateArrayList.get(1).getInputs().add(myStateArrayList.get(0));
        myStateArrayList.get(1).getOutputs().add(myStateArrayList.get(0));
        myStateArrayList.get(1).getOutputs().add(myStateArrayList.get(2));

        // Inputs and outputs for Modelling
        myStateArrayList.get(2).getInputs().add(myStateArrayList.get(1));
        myStateArrayList.get(2).getInputs().add(myStateArrayList.get(2));
        myStateArrayList.get(2).getOutputs().add(myStateArrayList.get(3));

        // Inputs and outputs for Construction
        myStateArrayList.get(3).getInputs().add(myStateArrayList.get(2));
        myStateArrayList.get(3).getOutputs().add(myStateArrayList.get(0));
        myStateArrayList.get(3).getOutputs().add(myStateArrayList.get(4));

        return myStateArrayList;
    }

    public void showMyStateInfo() {
        ArrayList<MyState> myStateArrayList = createMyStateArrayList();
        for (MyState myState : myStateArrayList) {
            System.out.println("State: " + myState.getName() + "\n" +
                    "Timeframe: " + myState.getTimeFrame());
            for (MyState input : myState.getInputs()) {
                System.out.print("Input: " + input.getName() + "\n");
            }
            for (MyState output : myState.getOutputs()) {
                System.out.print("Output: " + output.getName() + "\n");
            }
            System.out.println();
        }
    }
}
