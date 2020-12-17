package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private List<Feature> features = new ArrayList<>();
    private int price;
    private String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... feature) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        for (Feature item : feature) {
            features.add(item);
        }
    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public List<String> getContributors() {
        List<String> contr = new ArrayList<>();
        for (Feature item : features) {
            for (String item2 : item.getContributors()) {
                contr.add(item2);
            }
        }
        return contr;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for(Feature item : features) {
            titles.add(item.getTitle());
        }
        return titles;
    }

    public int fullLengthAtOneItem() {
        int total = 0;
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                total += ((AudioFeatures) item).getLength();
            }
        }
        return total;
    }

    public boolean hasAudioFeature() {
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public int numberOfPagesAtOneItem() {
        int total = 0;
        for (Feature item : features) {
           if (item instanceof PrintedFeatures) {
               total += ((PrintedFeatures) item).getNumberOfPages();
           }
        }
        return total;
      }

}
