package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    protected List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    // Itt nem mentettem el szándékosan a CatalogItem-eket egy listába csak azért,hogy majd lekérjem a méretét.
    // Inkább létrehoztam egy számlálót,amit növelek,ha találat van.
    public double averagePageNumberOver(int page) {
        if (page == 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        int itemCounter = 0;
        int total = 0;
        for (CatalogItem item : catalogItems) {
            if (item.numberOfPagesAtOneItem() >= page) {
                total += item.numberOfPagesAtOneItem();
                ++itemCounter;
            }
        }
        if (itemCounter == 0) {
            throw new IllegalArgumentException("No page");
        }
        double averagePage = (double) total / itemCounter;
        return averagePage;
    }

    public void deleteItemByRegistrationNumber(String num) {
        for (int i = 0; i < catalogItems.size(); i++) {
            if (catalogItems.get(i).getRegistrationNumber().equals(num)) {
                catalogItems.remove(i);
                return;
            }
        }
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> catalogItemsResult = new ArrayList<>();
        if (searchCriteria.hasContributor() && searchCriteria.hasTitle()) {
            for (CatalogItem item : catalogItems) {
                List<String> contributors = item.getContributors();
                List<String> titles = item.getTitles();
                for (int i = 0; i < contributors.size(); i++) {
                    if (contributors.get(i).equals(searchCriteria.contributor) && titles.get(i).equals(searchCriteria.title)) {
                        catalogItemsResult.add(item);
                    }
                }
            }
            return catalogItemsResult;
        }

        if (!searchCriteria.hasTitle()) {
            for (CatalogItem item : catalogItems) {
                List<String> contributors = item.getContributors();
                for (int i = 0; i < contributors.size(); i++) {
                    if (contributors.get(i).equals(searchCriteria.contributor)) {
                        catalogItemsResult.add(item);
                    }
                }
            }
            return catalogItemsResult;
        }

        if (!searchCriteria.hasContributor()) {
            for (CatalogItem item : catalogItems) {
                List<String> titles = item.getTitles();
                for (int i = 0; i < titles.size(); i++) {
                    if (titles.get(i).equals(searchCriteria.title)) {
                        catalogItemsResult.add(item);
                    }
                }
            }
            return catalogItemsResult;
        }
        return catalogItemsResult;
    }

    public int getAllPageNumber() {
        int total = 0;
        for (CatalogItem item : catalogItems) {
            total += item.numberOfPagesAtOneItem();
        }
        return total;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> resItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                resItems.add(item);
            }
        }
        return resItems;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> resItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                resItems.add(item);
            }
        }
        return resItems;
    }

    public int getFullLength() {
        int totalLength = 0;
        for (CatalogItem item : catalogItems) {
           totalLength += item.fullLengthAtOneItem();
        }
        return totalLength;
    }

}
