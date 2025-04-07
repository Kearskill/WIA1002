package week4;

public class GroupAssignment {
    public static void main(String[] args) {
        Sphere sphere = new Sphere(5.0);
        Cylinder cylinder = new Cylinder(5.0,10.0);
        Cone cone = new Cone(5.0,10.0);

        System.out.printf("Sphere Volume: %.4f\n" +"Sphere Surface Area: %.4f\n",sphere.calculateVolume(),sphere.calculateSurfaceArea());
        System.out.printf("Cylinder Volume: %.4f\n" +"Cylinder Surface Area: %.4f\n",cylinder.calculateVolume(),cylinder.calculateSurfaceArea());
        System.out.printf("Cone Volume: %.4f\n" +"Cone Surface Area: %.4f\n",cone.calculateVolume(),cone.calculateSurfaceArea());
    }
}

class Sphere{
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateVolume(){
        return (4.0/3.0) * Math.PI * Math.pow(radius,3);
    }

    public double calculateSurfaceArea(){
        return 4.0 * Math.PI * Math.pow(radius,2);
    }
}

class Cylinder extends Sphere{
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double calculateVolume(){
        return Math.PI * Math.pow(getRadius(),2) * height;
    }

    @Override
    public double calculateSurfaceArea(){
        return (2.0 * Math.PI * Math.pow(getRadius(), 2)) + (2.0 * Math.PI * getRadius() * height);
    }
}

class Cone extends Sphere{
    private double height;

    public Cone(double radius, double height) {
        super(radius);
        this.height = height;
    }
    @Override
    public double calculateVolume(){
        return (1.0/3.0) * Math.PI * Math.pow(getRadius(), 2) * height;
    }

    @Override
    public double calculateSurfaceArea(){
        return Math.PI * getRadius() * (getRadius() + Math.sqrt(Math.pow(getRadius(),2) + Math.pow(height,2)));
    }
}
