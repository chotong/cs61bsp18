import static java.lang.Math.*;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double g = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b) {
        return sqrt((this.xxPos - b.xxPos)*(this.xxPos - b.xxPos) + (this.yyPos - b.yyPos)*(this.yyPos - b.yyPos));
    }

    public double calcForceExertedBy(Planet b) {
        return (g * mass * b.mass) / (calcDistance(b)*calcDistance(b));
    }
    
    public double calcForceExertedByX(Planet b) {
        double pos = b.xxPos - this.xxPos;
        return calcForceExertedBy(b) * (pos/calcDistance(b));
    }

    public double calcForceExertedByY(Planet b) {
        double pos = b.yyPos - this.yyPos;
        return calcForceExertedBy(b) * (pos / calcDistance(b));
    }
    
	public double calcNetForceExertedByX(Planet[] bodies) {
		double fX = 0;
		for (Planet b: bodies) {
			if (!this.equals(b)) {
				fX += calcForceExertedByX(b);
			}
		}
		return fX;
	}

	public double calcNetForceExertedByY(Planet[] bodies) {
		double fY = 0;
		for (Planet b: bodies) {
			if (!this.equals(b)) {
				fY += calcForceExertedByY(b);
			}
		}
		return fY;
	}

    
    public void update(double s, double nX, double nY) {
        double aX = nX / this.mass;
        double aY = nY / this.mass;
        this.xxVel = this.xxVel + aX * s;
        this.yyVel = this.yyVel + aY * s;
        this.xxPos = this.xxVel * s + this.xxPos;
        this.yyPos = this.yyVel * s + this.yyPos;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}