public class NBody{
    public static double readRadius(String stream){
        In ss = new In(stream);
        double n = ss.readDouble();
        double rr = ss.readDouble();
        return rr;

    }
    public static Planet[] readPlanets(String stream){
        In ss = new In(stream);
        int num = ss.readInt();
        ss.readDouble();
        Planet[] rr=new Planet[num];

        for(int i = 0;i<num;i++){
            double px = ss.readDouble();
            double py = ss.readDouble();
            double vx = ss.readDouble();
            double vy = ss.readDouble();
            double ma = ss.readDouble();
            String img = ss.readString();
            rr[i] = new Planet(px,py,vx,vy,ma,img);

        }
        return rr;


    }
    public static void main(String args[]){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double Radius = readRadius(filename);
        Planet[] Planets = readPlanets(filename);
        StdDraw.setScale(-Radius,Radius);
        StdDraw.picture(0,0,"/images/starfield.jpg",2*Radius,2*Radius);

        for(int i = 0;i<Planets.length;i++){
            Planets[i].draw();
        }
        StdAudio.loop("audio/2001.mid");
        double time = 0;
        while(time<T){

            double[] xForces = new double[Planets.length];
            double[] yForces = new double[Planets.length];
            for (int i = 0; i<Planets.length;i++){
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
            }
            for (int i = 0; i<Planets.length;i++){
                Planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,"/images/starfield.jpg",2*Radius,2*Radius);
            for(int i = 0;i<Planets.length;i++){
                Planets[i].draw();
            }
            StdDraw.show(10);
            time = time + dt;

        }
        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel, Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }

    }
}