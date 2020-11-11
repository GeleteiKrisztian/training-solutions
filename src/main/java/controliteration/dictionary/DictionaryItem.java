package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {

    private String word;
    private List<String> translations = new ArrayList<>();

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        addTranslations(translations);
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void addTranslations(List<String> translations){
        for (String item : translations) {
            if (!this.translations.contains(item)) {
                this.translations.add(item);
            }
        }
    }

}
