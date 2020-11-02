package classsctructureintegrate;
import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product name: ");
        String nameInput = scanner.nextLine();
        System.out.println("Product price (HUF): ");
        int priceInput = scanner.nextInt();

        Product product = new Product(nameInput,priceInput);
        System.out.println("Your product: " + product.getName() + ". Price: " + product.getPrice() + " HUF");

        product.decrasePrice(100);
        System.out.println("Your product: " + product.getName() + ". New price after decrase: " + product.getPrice() + " HUF");

        product.incrasePrice(300);
        System.out.println("Your product: " + product.getName() + ". New price after incrase: " + product.getPrice() + " HUF");

    }
}
