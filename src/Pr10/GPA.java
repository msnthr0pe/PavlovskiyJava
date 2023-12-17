package Pr10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GPA implements Comparator<Student> {
    public ArrayList<Student> iDNumber = new ArrayList<>();
    public void setArray(){
        Random rand = new Random();
        for(int i = 0; i < Math.abs(rand.nextInt()%10 + 20); i++){
            double r = Math.abs(rand.nextInt()%30)+20;
            this.iDNumber.add(new Student(Integer.toString(i), "Student", "coder", 2, "Group1", r/10));
        }
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGPA().compareTo(o2.getGPA());
    }

    public  void quickSort(int low, int high) {
        if (this.iDNumber.isEmpty())
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Student opora = this.iDNumber.get(middle);

        int i = low, j = high;
        while (i <= j) {
            while (compare(opora, this.iDNumber.get(i)) < 0) {
                i++;
            }

            while (compare(this.iDNumber.get(j), opora) < 0) {
                j--;
            }

            if (i <= j) {
                Student temp = this.iDNumber.get(i);
                this.iDNumber.set(i, this.iDNumber.get(j));
                this.iDNumber.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(low, j);

        if (high > i)
            quickSort(i, high);
    }
    public void outArray(){
        for (Student curr : iDNumber) {
            System.out.println(curr.getName() + " " + curr.getSurname() + " " + curr.getSpeciality() + " " + curr.getGroup() + " " + curr.getCourse() + " " + curr.getGPA());
        }
    }
    public void mergeSort(ArrayList<Student> arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        ArrayList<Student> l = new ArrayList<Student>();
        for (int i = 0; i < mid; i++) {
            l.add(new Student());
        }
        ArrayList<Student> r = new ArrayList<Student>();
        for (int i = 0; i < n-mid; i++) {
            r.add(new Student());
        }

        for (int i = 0; i < mid; i++) {
            l.set(i, arr.get(i));
        }
        for (int i = mid; i < n; i++) {
            r.set(i-mid, arr.get(i));
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(arr, l, r, mid, n - mid);
    }

    public void merge(
            ArrayList<Student> a, ArrayList<Student> l, ArrayList<Student> r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (compare(r.get(j), l.get(i))<=0) {
                a.set(k++, l.get(i++));
            }
            else {
                a.set(k++, r.get(j++));
            }
        }
        while (i < left) {
            a.set(k++, l.get(i++));
        }
        while (j < right) {
            a.set(k++, r.get(j++));
        }
    }

    public static void main(String[] args) {
        GPA sort = new GPA();
        sort.setArray();
        sort.outArray();
        System.out.println("------------");
        sort.mergeSort(sort.iDNumber, sort.iDNumber.size());
        sort.outArray();
    }
}