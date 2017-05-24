
public class Ship{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Ship(double xPos,double yPos,double xVel,double yVel,double mm,String img){
        this.xxPos = xPos;
        this.yyPos = yPos;
        this.xxVel = xVel;
        this.yyVel = yVel;
        this.mass = mm;
        this.imgFileName = "star_destroyer.gif";
    }                           //initial

    public Ship(Planet P){
        this.xxPos = P.xxPos*2;
        this.yyPos = P.yyPos*2;
        this.xxVel = P.xxVel/100;
        this.yyVel = P.yyVel/100;
        this.mass = P.mass;
        this.imgFileName = "star_destroyer.gif" ;


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

            if(this.xxPos != listOfPlanets[i].xxPos) {
                x = x + calcForceExertedByX(listOfPlanets[i]);
            }

        }
        return x;
    }
    public double calcNetForceExertedByY(Planet[]listOfPlanets){
        double y = 0;
        for(int i = 0; i<listOfPlanets.length;i++){

            if(this.xxPos != listOfPlanets[i].xxPos) {
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
        double mouseX = StdDraw.mouseX();
        double mouseY = StdDraw.mouseY();
        double vecX = mouseX-this.xxPos;
        double vecY = mouseY-this.yyPos;
        double vec = Math.pow((Math.pow(vecX,2)+Math.pow(vecY,2)),0.5);
        double sq_v = Math.pow(this.xxVel,2)+Math.pow(this.yyVel,2);
        double ac_v = Math.pow(sq_v,0.5);
        if(StdDraw.mousePressed()){
            this.xxVel = ac_v*vecX/vec;
            this.yyVel = ac_v*vecY/vec;
        }
        /*double angle = Math.toRadians(0.5);
        if(this.xxVel == 0){
            if ((this.xxPos-mouseX)*this.yyVel<0){
                angle = -angle;
            }}
        else{
            if ((this.yyPos+this.yyVel/this.xxVel*this.xxPos-mouseY)*this.xxVel>0)
                angle = -angle;
            }
        double sq_v = Math.pow(this.xxVel,2)+Math.pow(this.yyVel,2);
        double ac_v = Math.pow(sq_v,0.5);
        double sin_v = this.yyVel/ac_v;
        double cos_v = this.xxVel/ac_v;
        double new_sin_v = sin_v * Math.cos(angle) + cos_v * Math.sin(angle);
        double new_cos_v = cos_v * Math.cos(angle) - sin_v * Math.sin(angle);
        this.xxVel = ac_v*new_cos_v;
        this.yyVel = ac_v*new_sin_v;*/
        this.xxPos = xxPos + this.xxVel * time;
        this.yyPos = yyPos + this.yyVel * time;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"/images/"+imgFileName);

    }

}