package controladvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HasznaltAutoCvs {

    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line: lines) {
            String[] parts = line.split(";");
            if(parts.length != 4) {
//Innen kezdve hiányzik jópár sor
            continue;
            }
            if (parts[0].length() != 7 || (!parts[0].contains("-")) && (Integer.parseInt(parts[1]) < 1970) || Integer.parseInt(parts[1]) > 2019) {
             continue;
            }
            validLines.add(line);
        }
        return validLines;
    }

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>(Arrays.asList("ABC-123;2019;Volvo;red","CBA-321;2009;Ford;blue"));
        HasznaltAutoCvs hasznaltAutoCvs = new HasznaltAutoCvs();
        System.out.println(hasznaltAutoCvs.filterLines(lines));
    }

}
