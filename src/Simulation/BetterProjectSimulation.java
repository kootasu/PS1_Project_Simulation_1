package Simulation;

import java.util.ArrayList;
import java.util.Scanner;

public class BetterProjectSimulation {

    public void simulateProject(){
        ArrayList<MyState> myStateArrayList = MyStateCreator.createMyStateArrayList();
        Scanner scanner = new Scanner(System.in);
        int iteration = 0;

        // Time moves, things happen
        while (true) {

            System.out.println("Iteration: " + iteration);
            for (MyState myState : myStateArrayList){
                System.out.println(myState.getName() + ": " + myState.getWorkEnergy());
            }

            // If we're at iteration 0
            if (iteration == 0) {
                // All 1.0 workEnergy goes into Communication
                myStateArrayList.get(0).setWorkEnergy(1);
            }

            // If we're later than iteration 0
            else if (iteration > 0){
                // All states – starting from the last state
                for (int i = myStateArrayList.size() - 1; i >= 0; i--) {
                    MyState myState = myStateArrayList.get(i);
                    // If a state has any workEnergy – and any output states – and its localTimeFrame equals its timeFrame
                    if (myState.getWorkEnergy() > 0 &&
                            myState.getOutputs().size() > 0 &&
                            myState.getLocalTimeFrame() == myState.getTimeFrame()) {
                        // It figures out how to distribute its workEnergy equally between all its outputs
                        double distributedWorkEnergy = myState.getWorkEnergy() / myState.getOutputs().size();
                        // Then distributes workEnergy
                        for (MyState output : myState.getOutputs()){
                            output.setWorkEnergy(output.getWorkEnergy() + distributedWorkEnergy);
                            // And subtracts from its own
                            myState.setWorkEnergy(myState.getWorkEnergy() - distributedWorkEnergy);
                        }
                        myState.setLocalTimeFrame(0);
                    }
                    // Otherwise, states that have any energy, but have not yet reached their frame, increment their localTimeFrame
                    else if (myState.getWorkEnergy() > 0){
                        myState.setLocalTimeFrame(myState.getLocalTimeFrame() + 1);
                    }
                }
            }

            // Time moves – hit enter
            iteration++;
            System.out.println("\nPress enter to continue");
            String input = scanner.nextLine();
        }
    }
}
