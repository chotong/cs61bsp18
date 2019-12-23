import java.io.BufferedReader;
import java.io.IOException;

public class NBody {
    public static double readRadius(String file) {
        In in = new In(file);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }

    public static Body[] readBodies(String file) {
        In in = new In(file);
        int n = in.readInt();
        double radius = in.readDouble();
        Body[] bodies = new Body[n];
        int i = 0;
        for (i = 0; i < n; i++) {
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String name = in.readString();
            bodies[i] = new Body(xPos, yPos, xVel, yVel, mass, name);
        }
        return bodies;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        double time = 0;
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);
        int N = bodies.length;

        StdDraw.setScale(-readRadius(args[2]), readRadius(args[2]));
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Body i : bodies) {
            i.draw();
        }
        StdDraw.enableDoubleBuffering();
        for (time = 0; time < T; time += dt) {
            double[] xForces = new double[N];
            double[] yForces = new double[N];
            for (int i = 0; i < N; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }

            for (int i = 0; i < N; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body b : bodies) {
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                        bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }
	}
}