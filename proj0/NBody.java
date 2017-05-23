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
}