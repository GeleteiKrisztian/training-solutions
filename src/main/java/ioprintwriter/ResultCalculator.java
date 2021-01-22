package ioprintwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }

    public void readTalents(Path file) {
        try(BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                productions.add(new Production(Integer.parseInt(split[0]), split[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("");
        }
    }

    public void calculateVotes(Path votesFile) {
        try(BufferedReader br = Files.newBufferedReader(votesFile)) {
            String line;
            while((line = br.readLine()) != null) {
                int index = voteIdIndex(line);
                if (index > -1) {
                    votes.get(index).incNum();
                } else {
                    votes.add(new Vote(Integer.parseInt(line), 1));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("");
        }
    }

    public void writeResultToFile(Path resultFile) {
        try(BufferedWriter bw = Files.newBufferedWriter(resultFile)) {
            for (Vote item : votes) {
                int id = item.getId();
                bw.write(item.getId() + getNameById(id) + item.getNumber());
                bw.newLine();
            }
            bw.write("Winner: " + winnerFinder());
            System.out.println("Winner: " + winnerFinder());
        } catch (IOException ioe) {
            throw new IllegalStateException("");
        }
    }

    // tartalmazza-e a votes lista,ha igen,visszaadja az indexét
    private int voteIdIndex(String id) {
        for (int i = 0; i < votes.size(); i++) {
            if (votes.get(i).getId() == Integer.parseInt(id)) {
                return i;
            }
        }
        return -1;
    }

    private String getNameById(int i) {
        for (Production item : productions) {
            if (item.getId() == i) {
                return item.getName();
            }
        }
        throw new IllegalArgumentException("");
    }

    private String winnerFinder() {
        Vote winner = votes.get(0);
        for (Vote item : votes) {
            if (item.getNumber() > winner.getNumber()) {
                winner = item;
            }
        }
        return getNameById(winner.getId());
    }
}
