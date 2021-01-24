package week04d02;

import java.util.ArrayList;
import java.util.List;

public class Search {

   public List<Integer> getIndexesOfChar(String str, char c) {
       List<Integer> indexes = new ArrayList<>();
       for (int i = 0; i < str.length(); i++) {
           if (str.charAt(i) == c) {
               indexes.add(i);
           }
       }
       return indexes;
   }

}
