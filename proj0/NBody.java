public class NBody {
    public static double readRadius (String file)
    {
        In in = new In(file);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets (String file)
    {
        In in = new In(file);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] array = new Planet[number];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
                       in.readDouble(), in.readDouble(), in.readString());

        }
        return array;
    }

    public static void main(String[] args)
    {
        StdDraw.enableDoubleBuffering();
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] array = readPlanets(filename);
        String imageToDraw = "images/starfield.jpg";
        double time = 0.0;
        while(time < T)
        {
            double[] xForces =new double[array.length];
            double[] yForces =new double[array.length];
            for(int i = 0; i<array.length; i++)
            {
                xForces[i] = array[i].calcNetForceExertedByX(array);
                yForces[i] = array[i].calcNetForceExertedByY(array);
            }
            for(int i =0; i < array.length; i++)
            {
                array[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.setScale(-radius, radius);
            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);
            for (Planet s : array) {
                s.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", array.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < array.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    array[i].xxPos, array[i].yyPos, array[i].xxVel,
                    array[i].yyVel, array[i].mass, array[i].imgFileName);
        }
    }

}
