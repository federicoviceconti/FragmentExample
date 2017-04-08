package com.example.personale.fragmentexample.model;

/**
 * Created by personale on 05/04/2017.
 */

public class Position {
    private double x, y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Position(PositionBuilder positionBuilder) {
        this.x = positionBuilder._x;
        this.y = positionBuilder._y;
    }

    public static class PositionBuilder{
        double _x, _y;

        public double get_x() {
            return _x;
        }

        public PositionBuilder set_x(double _x) {
            this._x = _x;
            return this;
        }

        public double get_y() {
            return _y;
        }

        public PositionBuilder set_y(double _y) {
            this._y = _y;
            return this;
        }

        public Position build(){
            return new Position(this);
        }
    }
}
