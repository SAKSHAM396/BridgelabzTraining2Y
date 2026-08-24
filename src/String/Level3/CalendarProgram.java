package String.Level3;
import java.util.Scanner;
class CalendarProgram{
    public static String getMonthName(int month){
        String[] months={
                "January","February","March","April","May","June",
                "July","August","September","October","November","December"
        };

        return months[month-1];
    }

    public static boolean isLeapYear(int year){
        return year%400==0||(year%4==0&&year%100!=0);
    }

    public static int getDays(int month,int year){
        int[] days={
                31,28,31,30,31,30,
                31,31,30,31,30,31
        };

        if(month==2&&isLeapYear(year)){
            return 29;
        }

        return days[month-1];
    }

    public static int getFirstDay(int month,int year){
        int day=1;

        int y0=year-(14-month)/12;
        int x=y0+y0/4-y0/100+y0/400;
        int m0=month+12*((14-month)/12)-2;
        int d0=(day+x+31*m0/12)%7;

        return d0;
    }

    public static void displayCalendar(int month,int year){
        int firstDay=getFirstDay(month,year);
        int days=getDays(month,year);

        System.out.println("\n     "+getMonthName(month)+" "+year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for(int i=0;i<firstDay;i++){
            System.out.print("    ");
        }

        for(int day=1;day<=days;day++){
            System.out.printf("%3d ",day);

            if((firstDay+day)%7==0){
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter month: ");
        int month=input.nextInt();

        System.out.print("Enter year: ");
        int year=input.nextInt();

        if(month<1||month>12||year<1){
            System.out.println("Invalid input");
            input.close();
            return;
        }

        displayCalendar(month,year);

        input.close();
    }
}