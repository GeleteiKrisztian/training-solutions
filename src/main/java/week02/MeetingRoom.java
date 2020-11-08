package week02;

public class MeetingRoom {

    private String name;
    private int length;
    private int width;

    public MeetingRoom(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return width * length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "A tárgyaló neve: " + name + ". A tárgyaló szélessége: " + width + ". A tárgyaló hosszúsága: " +
                length + ". A tárgyaló területe: " + getArea() + ".";
    }

}
