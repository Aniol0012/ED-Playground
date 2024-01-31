import java.awt.*;

public class T2E17 {
    public class Point {
        protected int x;
        protected int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }

        // Interoperable
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Point point) {
                return (x == point.x) && (y == point.y);
            }
            return false;
        }

        // Not interoperable
        public boolean equals_2(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            Point point = (Point) obj;
            return (x == point.x) && (y == point.y);
        }
    }
    public class ColoredPoint extends Point {
        private Color color;
        public ColoredPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }
}
