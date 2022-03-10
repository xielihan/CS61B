import static java.lang.Math.sqrt;

public class Planet {
    static double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img)
    {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p)
    {
         this.xxPos = p.xxPos;
         this.yyPos = p.yyPos;
         this.xxVel = p.xxVel;
         this.yyVel = p.yyVel;
         this.mass = p.mass;
         this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet other)
    {
        double x = other.xxPos - this.xxPos;
        double y = other.yyPos - this.yyPos;
        double distance = sqrt(x*x+y*y );
        return distance;
    }

    public double calcForceExertedBy(Planet other)
    {
        double distance = this.calcDistance(other);
        double force = (G*this.mass* other.mass)/(distance*distance);
        return force;
    }

    public double calcForceExertedByX(Planet other)
    {
        double force = this.calcForceExertedBy(other);
        double x = other.xxPos - this.xxPos;
        double distance = this.calcDistance(other);
        double forceX = force*x/distance;
        return forceX;
    }

    public double calcForceExertedByY(Planet other)
    {
        double force = this.calcForceExertedBy(other);
        double x = other.yyPos - this.yyPos;
        double distance = this.calcDistance(other);
        double forceY = force*x/distance;
        return forceY;
    }



    public double calcNetForceExertedByX(Planet[] array)
    {
        double Fnet = 0;
        for(Planet s : array)
        {
            if(this.equals(s)) continue;
            Fnet += this.calcForceExertedByX(s);
        }
        return Fnet;
    }

    public double calcNetForceExertedByY(Planet[] array)
    {
        double Fnet = 0;
        for(Planet s : array)
        {
            if(this.equals(s)) continue;
            Fnet += this.calcForceExertedByY(s);
        }
        return Fnet;
    }

    public void update(double t, double fx, double fy)
    {
        double ax = fx/mass;
        double ay = fy/mass;
        xxVel += t*ax;
        yyVel += t*ay;
        xxPos += t*xxVel;
        yyPos += t*yyVel;
    }

    public void draw()
    {
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);

    }



}
