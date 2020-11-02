package localvariables;

public class DistanceMain {

    public static void main(String[] args) {
        Distance distance = new Distance(14,true);
        System.out.println("A távolság: " + distance.getDistanceInKm() + " KM. (Pontos az érték? " + distance.isExact() + ")" );

        int i = (int) distance.getDistanceInKm();
        System.out.println(i);
    }
}
