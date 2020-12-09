package virtualmethod;

public class Vehicle {

        public static final int PERSON_AVERAGE_WEIGHT = 75;
        protected int vehicleWeight;

        public Vehicle(int vehicleWeight) {
            this.vehicleWeight = vehicleWeight;
        }

        public int getGrossLoad() {
            return PERSON_AVERAGE_WEIGHT + vehicleWeight;
        }

    public int getVehicleWeight() {
        return vehicleWeight;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleWeight=" + vehicleWeight +
                '}';
    }

}

