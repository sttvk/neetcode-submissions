interface Shape {
    Shape clone();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public Shape clone() {
        // Write your code here
        int widthClone = this.width;
        int heightClone = this.height;
        return new Rectangle(widthClone, heightClone);
    }
}

class Square implements Shape {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public Shape clone() {
        // Write your code here
        int lengthClone = this.length;
        return new Square(lengthClone);
    }
}

class Test {
    public List<Shape> cloneShapes(List<Shape> shapes) {
        // Write your code here
        List<Shape> clonedShapes = new ArrayList();
        for (Shape shape : shapes) {
            clonedShapes.add(shape.clone());
        }

        return clonedShapes;
    }
}
