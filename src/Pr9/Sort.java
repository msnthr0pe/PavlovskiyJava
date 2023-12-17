package Pr9;

public class Sort {
    public static void insertionSort(Student[] input) {
        for (int i = 1; i < input.length; i++) {
            Student key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j].IDNumber > key.IDNumber) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
    }



    public static void quickSort(Student[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        Student opora = array[middle];


        int i = low, j = high;
        while (i <= j) {
            while (opora.compareTo(array[i]) > 0) {
                i++;
            }

            while (array[j].compareTo(opora) > 0) {
                j--;
            }

            if (i <= j) {
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void mergeSort(Student[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Student[] l = new Student[mid];
        Student[] r = new Student[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(arr, l, r, mid, n - mid);
    }

    public static void merge(
            Student[] a, Student[] l, Student[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (r[j].compareTo(l[i])>=0) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
        Student[] arr = Student.generate();
        Student.printer(arr);
        System.out.println("----------");
        Sort.mergeSort(arr, arr.length);
        Student.printer(arr);
    }
}