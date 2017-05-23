
public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xPos,double yPos,double xVel,double yVel,double mm,String img){
        this.xxPos = xPos;
        this.yyPos = yPos;
        this.xxVel = xVel;
        this.yyVel = yVel;
        this.mass = mm;
        this.imgFileName = img;
    }                           //initial

    public Planet(Planet P){
        this.xxPos = P.xxPos;
        this.yyPos = P.yyPos;
        this.xxVel = P.xxVel;
        this.yyVel = P.yyVel;
        this.mass = P.mass;
        this.imgFileName = P.imgFileName;


    }
    public double calcDistance(Planet m){
        double xs = Math.pow((this.xxPos-m.xxPos),2);
        double ys = Math.pow((this.yyPos-m.yyPos),2);
        double distance = Math.pow(xs+ys,0.5);
        return distance;

    }

    public double calcForceExertedBy(Planet m){
        double G = 6.67E-11;
        double force = G*this.mass*m.mass/Math.pow(this.calcDistance(m),2);
        return force;
    }

    public double calcForceExertedByX(Planet m){
        double sx = this.xxPos-m.xxPos;
        double forcex = calcForceExertedBy(m)*sx/calcDistance(m);
        return -forcex;
    }


    public double calcForceExertedByY(Planet m){
        double sy = this.yyPos-m.yyPos;
        double forcey = calcForceExertedBy(m)*sy/calcDistance(m);
        return -forcey;
    }
    public double calcNetForceExertedByX(Planet[]listOfPlanets){
        double x = 0;
        for(int i = 0; i<listOfPlanets.length;i++){
            if(this != listOfPlanets[i]) {
                x = x + calcForceExertedByX(listOfPlanets[i]);
            }
        }
        return x;
    }
    public double calcNetForceExertedByY(Planet[]listOfPlanets){
        double y = 0;
        for(int i = 0; i<listOfPlanets.length;i++){
            if(this != listOfPlanets[i]) {
                y = y + calcForceExertedByY(listOfPlanets[i]);
            }
        }
        return y;
    }

    public void update(double time,double fx,double fy){
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel = this.xxVel + ax * time;
        this.yyVel = this.yyVel + ay * time;
        this.xxPos = this.xxPos + this.xxVel * time;
        this.yyPos = this.yyPos + this.yyVel * time;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"/images/"+imgFileName);

    }

}