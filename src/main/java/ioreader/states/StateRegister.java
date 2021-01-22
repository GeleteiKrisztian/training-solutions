package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    private List<State> states = new ArrayList<>();

    public List<State> getStates() {
        return new ArrayList<>(states);
    }

    public void readStatesFromFile(String file) {
        try(BufferedReader br = Files.newBufferedReader(Path.of(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("-");
                states.add(new State(split[0], split[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public String findCapitalByStateName(String s) {
        for (State item : states) {
            if (item.getStateName().equals(s)) {
                return item.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }

}
