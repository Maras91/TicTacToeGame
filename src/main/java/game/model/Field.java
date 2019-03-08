package game.model;

import java.util.Objects;

public class Field {
    private final int xAxis;
    private final int yAxis;

    public Field(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
    public Field(int move) {
        xAxis = move % 10;
        yAxis = move / 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Field)) return false;
        Field field = (Field) o;
        return xAxis == field.xAxis &&
                yAxis == field.yAxis;
    }

    @Override
    public int hashCode() {

        return Objects.hash(xAxis, yAxis);
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }
}
