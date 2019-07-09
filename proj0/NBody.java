public class NBody{
    public static double readRadius(String filePath){
        In in = new In(filePath);
        int numberOfPlanets = in.readInt();
        double radiusOfUniverse = in.readDouble();
        return radiusOfUniverse;
    }

    public static Body[] readBodies(String filePath){
        In in = new In(filePath);
        int numOfObject=in.readInt();
        in.readDouble();
        Body[] bodies=new Body[numOfObject];
        for(int i=0; i<numOfObject; i++){
            double xxPos=in.readDouble();
            double yyPos=in.readDouble();
            double xxVel=in.readDouble();
            double yyVel=in.readDouble();
            double mass=in.readDouble();
            String imgFileName=in.readString();
            bodies[i]=new Body(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
            
        }
        return bodies;
    }
}