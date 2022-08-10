package org.example.lesson4;

public class TriangleArea {

    public static double heronsFormula(double a, int b, int c) throws SideOfTriangleIsZero {
        if(a <= 0 || b <= 0 || c <= 0){
            throw new SideOfTriangleIsZero();
        }
        double p = (a + b + c)/2;
        double result = Math.sqrt(p*(p - a)*(p - b)*(p - c));
        System.out.println(result);
        return result;

    }

}
