public class Body{
    public static final double G=6.67e-11; //gravitational constant G

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }

    //???????????
    public Body(Body b){
        xxPos=b.xxPos;
        yyPos=b.yyPos;
        xxVel=b.xxVel;
        yyVel=b.yyVel;
        mass=b.mass;
        imgFileName=b.imgFileName;
    }

    public double calcDistance(Body b){
        double dx=b.xxPos-this.xxPos;
        double dy=b.yyPos-this.yyPos;
        double distance=Math.sqrt(dx*dx+dy*dy);
        return distance;
    }

    public double calcForceExertedBy(Body b){
        double distance=this.calcDistance(b);
        double force=G*this.mass*b.mass/Math.pow(distance,2);
        return force;
    }

    public double calcForceExertedByX(Body b){
        double distance=this.calcDistance(b);
        double dx=b.xxPos-this.xxPos;
        double forceX=this.calcForceExertedBy(b)*dx/distance;
        return forceX;
    }

    public double calcForceExertedByY(Body b){
        double distance=this.calcDistance(b);
        double dy=b.yyPos-this.yyPos;
        double forceY=this.calcForceExertedBy(b)*dy/distance;
        return forceY;
    }

    public double calcNetForceExertedByX(Body[] allBodys){
        double netForceX=0;
        for (Body b : allBodys)
        {
            if(this.equals(b)){
                continue;
            }else{
                netForceX+=this.calcForceExertedByX(b);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Body[] allBodys){
        double netForceY=0;
        for (Body b : allBodys)
        {
            if(this.equals(b)){
                continue;
            }else{
                netForceY+=this.calcForceExertedByY(b);
            }
        }
        return netForceY;
    }

}