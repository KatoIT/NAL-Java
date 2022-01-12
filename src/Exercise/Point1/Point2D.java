package Exercise.Point1;

import java.sql.Array;
import java.util.Arrays;

public class Point2D {
    private float x;
    private float y;

    public Point2D() {
        this.x = 1.0f;
        this.y = 1.0f;
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] val = {x, y};
        return val;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return '(' + x + ", " + y + ')';
    }
}
