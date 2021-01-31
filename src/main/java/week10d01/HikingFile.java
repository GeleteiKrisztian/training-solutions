package week10d01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HikingFile {

    public Result getPlusElevation(InputStream is) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            List<Double> datas = new ArrayList<>();
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                datas.add(Double.parseDouble(split[2]));
            }
            Result res = new Result();
            Double last = datas.get(0);
            for (int i = 1; i < datas.size(); i++) {
                if (last < datas.get(i)) {
                    res.setRaisingSum(res.getRaisingSum() + (datas.get(i) - last));
                } else {
                    res.setDecreaseSum(res.getDecreaseSum() + (last - datas.get(i)));
                }
                last = datas.get(i);
            }
            return res;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("", ioe);
        }
    }

}
