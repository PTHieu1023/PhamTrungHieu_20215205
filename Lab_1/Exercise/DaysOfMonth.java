import java.util.*;
public class DaysOfMonth {
    static Scanner sc = new Scanner(System.in);
    
    static int isLeapYear(int year){
        if (year % 4 != 0){
            return 0;
        }
        if (year % 100 != 0){
            return 1;
        }
        if (year % 400 == 0){
            return 1;
        }
        return 0;
    }
    
    static int getIntMonth(String month){
        String[][] nameMonths = {
            {"January", "Jan.", "Jan", "1"},
            {"Febuary", "Feb.", "Feb", "2"},
            {"March", "Mar.", "Mar", "3"},
            {"April", "Apr.", "Apr", "4"},
            {"May", "May.", "May", "5"},
            {"June", "Jun.", "Jun", "6"},
            {"July", "Jul.", "Jul", "7"},
            {"August", "Aug.", "Aug", "8"},
            {"September", "Sep.", "Sep", "9"},
            {"October", "Oct.", "Oct", "10"},
            {"November", "Nov.", "Nov", "11"},
            {"December", "Dec.", "Dec", "12"}
        };

        for (int i = 0; i < 12; i++){
            if (Arrays.asList(nameMonths[i]).contains(month))
                return i+1;
        }  
        return 0;  
    }

    public static void main(String[] args) {
        //Input month and year
        System.out.print("Enter a month: ");
        String strMonth = sc.nextLine();
        int iMonth = getIntMonth(strMonth);
        System.out.println("Enter a year");
        int iYear = sc.nextInt();
        
        int[] dayInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (iMonth == 0){
            System.out.println("Invalid input of month");
        } else{
            if (isLeapYear(iYear) == 1){
                dayInMonth[1] = 29;
            }else{
                dayInMonth[1] = 28;
            }
            System.out.println(iMonth + "/" + iYear + " has " + dayInMonth[iMonth-1] + " days");
        }
    }
}       