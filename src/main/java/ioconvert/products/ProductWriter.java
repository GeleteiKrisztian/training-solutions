package ioconvert.products;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

public class ProductWriter {

    public void saveProduct(OutputStream os, List<Product> products) {
        try(PrintWriter printWriter = new PrintWriter(os)) {
            for (Product item : products) {
                printWriter.print(item.getName());
                printWriter.print(";");
                printWriter.print(item.getPrice());
                printWriter.println();
            }
        }
    }

}
