import java.awt.*;

public class T2E18 {
    static class Rectangle {
        final int width;
        final int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Rectangle rect) {
                return (width == rect.width) && (height == rect.height);
            }
            return false;
        }

        public boolean equals_v2(Object obj, Color color) {
            if (obj instanceof ColoredRectangle colRect) {
                return (width == colRect.width) && (height == colRect.height) && (color.equals(colRect.color));
            } else if (obj instanceof Rectangle rect) {
                return rect.equals(this);
            }
            return false;
        }

        // Mes restrictius
        public boolean equals_v3(Object obj, Color color) {
            if (obj.getClass() == this.getClass()) {
                ColoredRectangle colRect = (ColoredRectangle) obj;
                // ((Rectangle) this).equals() -> Donaria error pq entrem en un bulce infinit ja que this no canvia
                // i estem apuntant al objecte en comptes de la referencia
                return (width == colRect.width) && (height == colRect.height) && (color.equals(colRect.color));
            } else if (obj instanceof Rectangle rect) {
                return rect.equals(this);
            }
            return false;
        }

        public boolean equals_v4(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            Rectangle rect = (Rectangle) obj;
            return (width == rect.width) && (height == rect.height);
        }

    }

    public static class ColoredRectangle extends Rectangle {
        private Color color;

        public ColoredRectangle(int width, int height, Color color) {
            super(width, height);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }

    public static void main(String[] args) {
        var r1 = new Rectangle(10, 20);
        var cr1 = new ColoredRectangle(10, 20, Color.cyan);
        if (r1.equals(cr1)) {
            System.out.println("Interoperable");
        }
    }
}
