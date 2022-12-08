package units;

import supportingFiles.Coordinates;

public class FieldObject {
    protected Coordinates coordinates;
    protected String name;
    protected String picture;
    protected int longOfMove;
    protected int maxLongOfAttack;

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }


    public Coordinates getCoordinates() { return coordinates; }

    public void setCoordinates(Coordinates coordinates) {

        if (coordinates.col < 0 || coordinates.row < 0) {
            System.out.println("Длина или ширина меньше нуля, невозможно обновить значения");
        } else {
            Coordinates newCoordinates = new Coordinates(coordinates.row, coordinates.col);
            this.coordinates = newCoordinates;
        }

    }
}