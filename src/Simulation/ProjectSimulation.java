package Simulation;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjectSimulation {

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
                // All states
                for (MyState myState : myStateArrayList) {
                    // If a state has any workEnergy – and any output states
                    if (myState.getWorkEnergy() > 0 && myState.getOutputs().size() > 0) {
                        // It figures out how to distribute its workEnergy equally between all its outputs
                        double distributedWorkEnergy = myState.getWorkEnergy() / myState.getOutputs().size();
                        // Then distributes workEnergy
                        for (MyState output : myState.getOutputs()){
                            output.setWorkEnergy(output.getWorkEnergy() + distributedWorkEnergy);
                            // And subtracts from its own
                            myState.setWorkEnergy(myState.getWorkEnergy() - distributedWorkEnergy);
                        }
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
