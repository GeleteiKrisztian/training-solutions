package classsctructuremethods;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();
        client.setName("John Doe");
        client.setYear(1995);
        client.setAddress("Budapest");

        System.out.println("Üdv " + client.getName() + "!" + client.getAddress() + " egy nagyon szép város.");
        System.out.println("Szerencsés vagy,hogy " + client.getYear() + "-ban/ben születtél!");

        client.migrate("Debrecen");
        System.out.println("Üdvözöllek!Ez itt " + client.getAddress() + ".");
        //Ezt itt egy megjegyzés!
    }
}
