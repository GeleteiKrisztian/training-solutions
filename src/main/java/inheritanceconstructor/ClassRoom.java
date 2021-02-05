package inheritanceconstructor;

public class ClassRoom extends Room {

    private Facility facility;

    public ClassRoom(String location, int capacity, Facility facility) {
        super(location, capacity);
        this.facility = facility;
    }

    public boolean isSuitable(Course course) {
        if (course.getParticipants() <= getCapacity() && course.getFacilityNeeded() == facility) {
            return true;
        }
        return false;
    }

    public Facility getFacility() {
        return facility;
    }
}
