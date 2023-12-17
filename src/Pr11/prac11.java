package Pr11;
import java.util.*;
import java.text.*;
public class prac11 {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
    public static ArrayList<Integer> getDateInput() {
        System.out.println("Enter year");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        System.out.println("Enter month number");
        int month = scanner.nextInt();

        System.out.println("Enter day");
        int day = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(year);
        arr.add(month);
        arr.add(day);
        return arr;
    }

    public static Calendar setDate() {
        ArrayList<Integer> arr = getDateInput();
        int year = arr.get(0);
        int month = arr.get(1);
        int day = arr.get(2);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal;
    }
    public static void taskTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2005);
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.DAY_OF_MONTH, 5);

        System.out.println("Pavlovskiy " + sdf.format(cal.getTime()));

        Date now = new Date();
        System.out.println("Pavlovskiy " + sdf.format(now));
    }

    public static void timeCheck() {
        Calendar cal = setDate();

        if (cal.getTimeInMillis() > System.currentTimeMillis()) {
            System.out.println("Inputted date is in the future");
        }
        if (cal.getTimeInMillis() == System.currentTimeMillis()) {
            System.out.println("Inputted date is today");
        }
        if (cal.getTimeInMillis() < System.currentTimeMillis()) {
            System.out.println("Inputted date is in the past");
        }
    }

    public static void setUserTime() {
        Calendar cal = setDate();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter hour");
        int hour = scanner.nextInt();

        System.out.println("Enter minute");
        int minute = scanner.nextInt();

        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);

        System.out.println("Inputted time: " + sdf.format(cal.getTime()));

    }

    public static void comparison() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            arr.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        LinkedList<Integer> arr1 = new LinkedList<Integer>();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            arr1.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

    }

    public static void main(String[] args) {
        //taskTime();
        //timeCheck();
        //setUserTime();
        //comparison();
    }
}