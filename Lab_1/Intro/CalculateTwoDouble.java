import javax.swing.JOptionPane;

public class CalculateTwoDouble{
    public static void main(String[] args){
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        String showSum = "Sum of " + num1 + " and " + num2 + " is: " + sum;
        
        double dif = num1 - num2;
        String showDif = "Difference of " + num1 + " and " + num2 + " is: " + dif;
        
        double pro = num1 * num2;
        String showPro = "Product of " + num1 + " and " + num2 + " is: " + pro;
        
        double quo = num1 / num2;
        String showQuo = "Quotient of " + num1 + " and " + num2 + " is: " + quo;
        
        JOptionPane.showMessageDialog(null, showSum + "\n" + showDif + "\n" + showPro + "\n" + showQuo,"Show result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}