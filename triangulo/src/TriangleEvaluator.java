import javax.swing.*;

public class TriangleEvaluator {

    public static void main(String[] args){
        int A, B, C;

        // DATA ENTRY
        do {
            A =  Integer.parseInt(JOptionPane.showInputDialog("enter first side length [cm]"));
            if(A<=0){ // invalid input
                JOptionPane.showMessageDialog(null,"Please insert a Valid length number in centimeters");
            }
        }while (A <= 0);
        do {
            B =  Integer.parseInt(JOptionPane.showInputDialog("enter second side length [cm]"));
            if(B<=0){ // invalid input
                JOptionPane.showMessageDialog(null,"Please insert a Valid length number in centimeters");
            }
        }while (B <= 0);
        do {
            C =  Integer.parseInt(JOptionPane.showInputDialog("enter third side length [cm]"));
            if(C<=0){ // invalid input
                JOptionPane.showMessageDialog(null,"Please insert a Valid length number in centimeters");
            }
        }while (C <= 0);

        //TRIANGLE CLASSIFICATION
        if( A == B && B==C){ //there sides are equal
            JOptionPane.showMessageDialog(null,"Equilateral Triangle");
        } else if (A==B || B==C || A == C) { //At least two sides are equal
            JOptionPane.showMessageDialog(null,"Isosceles Triangle");
        } else { //else every side length is unique
            JOptionPane.showMessageDialog(null,"Scalene Triangle");
        }
    }
}
