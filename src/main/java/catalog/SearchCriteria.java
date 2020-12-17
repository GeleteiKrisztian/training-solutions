package catalog;

public class SearchCriteria {

    public String title;
    public String contributor;


    private SearchCriteria(String title, String contributor) {
        if (Validators.isBlank(contributor) || Validators.isBlank(title)) {
            throw new IllegalArgumentException("");
        }
        this.title = title;
        this.contributor = contributor;

    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        return new SearchCriteria(title,contributor);
    }

    public static SearchCriteria createByContributor(String contributor) {
        return new SearchCriteria("-1", contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        return new SearchCriteria(title, "-1");
    }

    public boolean hasContributor() {
        if (!contributor.equals("-1")) {
            return true;
        }
        return false;
    }

    public boolean hasTitle() {
        if (!title.equals("-1")) {
            return true;
        }
        return false;
    }

}


