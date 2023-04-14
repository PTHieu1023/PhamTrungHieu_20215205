import java.util.*;
import java.lang.Math;

public class SolveEquation{
    private static Scanner sc = new Scanner(System.in);
    
    public static void solveFDE(){
        double a,b,x;
        
        System.out.println("Solve first degree equation (ax + b = 0):\nPlease enter");
        System.out.print("a = ");
        a = sc.nextDouble();
        System.out.print("b = ");
        b = sc.nextDouble();

        if (a == 0 && b == 0){
            System.out.println("The real number!");
        }else if (a == 0){
            System.out.println("No solution");
        }else{
            x = -b/a;
            System.out.println("Equation has one solution x = " + x);
        }
    }

    public static void solveSDE(){
        double a,b,c;
        
        System.out.println("Solve first degree equation (ax2 + bx + c = 0):\nPlease enter");
        System.out.print("a = ");
        a = sc.nextDouble();
        System.out.print("b = ");
        b = sc.nextDouble();
        System.out.print("c = ");
        c = sc.nextDouble();
        
        if (a == 0 && b == 0 && c == 0){
            System.out.println("Real number");
            System.exit(0);
        }else if(b == 0 && c != 0){
            System.out.println("No solution");
            System.exit(0);
        }else{
            double x = -c/b;
            System.out.println("Equation has one solution x = " + x);
            System.exit(0);

        }
        
        double delta = b*b - 4*a*c;
        if (delta < 0){
            System.out.println("No solution");
        }else if(delta == 0){
            double x = -b/(2*a);
            System.out.println("Equation has one solution x = " + x);
        }else{
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2+a);
            System.out.println("Equation has two solutions x1 = " + x1 + " and x2 = " + x2);
        }
    }
    
    public static void solveFDES(){
        double a1,a2,b1,b2,c1,c2;

        //Input 
        System.out.println("First degree equation system [a1*x + b1*y = c1 | a2*x + b2*y = c2 ]\n");
        System.out.println("Input a1, b1, c1, a2, b2, c2 (respectively):");
        a1 = sc.nextDouble();
        b1= sc.nextDouble();
        c1 = sc.nextDouble();
        a2 = sc.nextDouble();
        b2 = sc.nextDouble();
        c2 = sc.nextDouble();

        //Calculate
        double D = a1*b2 - a2*b1;
        double Dx = c1*b2 - b1*c2;
        double Dy = a1*c2 - c1*a2;
        if (D == 0 && Dx == 0){
            System.out.println("Every real number");
            System.exit(0);
        }
        if (D == 0 && Dx != 0){
            System.out.println("No solution!");
            System.exit(0);
        }
        System.out.println("x = " + Dx/D);
        System.out.println("y = " + Dy/D);
    }

    public static void main(String[] args){
        System.out.print("Enter operation: ");
        int mode = sc.nextInt();
        switch(mode){
            case 1:
                solveFDE();
                break;
            case 2:
                solveSDE();
                break;
            case 3:
                solveFDES();
                break;
            default:
                System.exit(0);
        }
    }

}

