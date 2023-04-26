/* Dr. Becnel
This program implements a gradient descent like algorithm
using iterative improvement to find the vertex of a
parabola.
The coefficients of the parabola are read from the console
and an approximation to the vertex is displayed to the console.
 */

import java.util.Scanner;

public class Quad {
    //===================MAIN===================
    // Here we read in the coefficients for the quadratic function.
    // We then find an approximation to the vertex and display the result
    // to the console.
    public static void main(String[] args) {
        // read in the coefficients for the quadratic function
        System.out.println("Enter the coefficients for the quadratic function y = ax^2+bx+c: ");
        Scanner console = new Scanner(System.in);
        float a = console.nextFloat();
        float b = console.nextFloat();
        float c = console.nextFloat();

        // find the x coordinate of the vertex of the parabola
        float x = findVertex(a,b);

        // display the vertex approximation
        System.out.println("The vertex of hte parabola is approximately:");
        System.out.println("(" + x +", " + a*x*x+b*x+c + ")");
    }

    //------------------findVertex--------------------
    //
    public static float findVertex(float a, float b) {
        double x = Math.random()*20+-10;
        double stepSize = 1;
        while (stepSize > 0.1) {
            double der = fprime(a,b,x);
            double newX = x;
            if (der == 0) {
                stepSize = 0;
            } else if (der > 0) {
                newX = x - stepSize;
            }
            else
                newX = x + stepSize;

            if (der * fprime(a,b,newX) < 0)
                stepSize = stepSize / 2.0;

            x= newX;
        }

        return (float) x;
    }

    //---------------fprime----------------------
    // This function returns the derivative of the quadratic
    // function at x.
    public static double fprime(float a, float b, double x) {
        return 2*a*x+b;
    }
}