public class NBody{
    public static double readRadius(String filePath){
        In in = new In(filePath);
        in.readInt();
        double radiusOfUniverse = in.readDouble();
        return radiusOfUniverse;
    }
    
    public static Body[] readBodies(String filePath){
        In in = new In(filePath);
        int numOfObjects=in.readInt();
        in.readDouble();
        Body[] bodies=new Body[numOfObjects];
        for(int i=0; i<numOfObjects; i++){
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

    public static void main(String[] args){
        if(args.length<3){
            System.out.println("Please add three parameters (T, dt and filename) as command line argument, seperated with whitespaces.");
        }else{
            double T=Double.parseDouble(args[0]);
            double dt=Double.parseDouble(args[1]);
            String filename=args[2];
            double radiusOfUniverse=readRadius(filename);
            Body[] bodies=readBodies(filename);
            String backgroundImg = "./images/starfield.jpg";
            
            StdDraw.setXscale(-radiusOfUniverse, radiusOfUniverse);
            StdDraw.setYscale(-radiusOfUniverse, radiusOfUniverse);
            StdDraw.enableDoubleBuffering();
            StdDraw.clear();
            //??????Are there any ways to set the background image directly?
            StdDraw.picture(0,0, backgroundImg);
            for(int i=0; i<bodies.length; i++){
                bodies[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(20);
        }
        

    }
}