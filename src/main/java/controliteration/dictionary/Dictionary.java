package controliteration.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {

    private List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem (String word,List<String> translations) {
        for (String item : translations) {
            for(DictionaryItem item2 : dictionaryItems) {
                if (item2.getWord().equals(word)) {
                return;
                }
            }
        }
        DictionaryItem item = new DictionaryItem(word,translations);
        dictionaryItems.add(item);
    }

    public List<String> findTranslations(String word) {
        List<String> translations = new ArrayList<>();
        for (DictionaryItem item : dictionaryItems) {
            if(item.getWord().toLowerCase().equals(word.toLowerCase())) {
                return item.getTranslations();
            }
        }
        return translations;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("Alma", Arrays.asList("Apple","apple2","apple3"));
        dictionary.addItem("Narancs", Arrays.asList("Orange","Orange","Orange","Orange","orange","orange2"));
        System.out.println(dictionary.findTranslations("alma"));
        System.out.println(dictionary.findTranslations("narancs"));
        System.out.println(dictionary.findTranslations("aaa"));

    }

}
