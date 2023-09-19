

public class Sorter {
    public static void selectionSort(Contact[] contacts) {
        // TODO Q2

            for (int i = 0; i < contacts.length; i++)
            {
                int minIndex = i;
                for (int j = i+1; j < contacts.length; j++)
                {
                    if (contacts[j].compareTo(contacts[minIndex]) < 0) {
                        minIndex = j;
                    }
                }
                Contact temp = contacts[i];
                contacts[i] = contacts[minIndex];
                contacts[minIndex] = temp;
            }

    }

    public static void insertionSort(Contact[] contacts) {
        // TODO Q3
        for(int s = 2; s <= contacts.length; s++)
        {
            Contact sortMe = contacts[s - 1];
            int i = s - 2;
            while (i >= 0 && sortMe.compareTo(contacts[i])<0)
            {
                contacts[i+1] = contacts[i];
                i--;
            }
            contacts[i+1] = sortMe;
        }
    }

    public static void quickSort(Contact[] contacts) {
        // TODO Q4
        quickSortlist(contacts,0,contacts.length-1);
    }
    private static void quickSortlist(Contact[] array, int first, int last)
    {
        if (last - first >= 1)
        {
            int pivotIndex;
            pivotIndex = partition(array,first,last);
            quickSortlist(array,first,pivotIndex-1); // left
            quickSortlist(array,pivotIndex+1,last); // right
        }
    }
    private static int partition(Contact a[], int low, int high)
    {
        int pi = low;
        Contact temp;
        Contact pivot = a[low];
        do
        {
            while ( low <= high && a[low].compareTo(pivot) <= 0 ){
                low++;}
            while ( a[high].compareTo(pivot) > 0 ){
                high--;}
            if ( low < high ) {
                temp = a[low];
                a[low] = a[high];
                a[high]=temp;
            }
        } while ( low < high );

        temp = a[pi];
        a[pi] = a[high];
        a[high]=temp;
        pi = high;
        return pi;
    }


    public static void mergeSort(Contact[] contacts) {
        // TODO Q5
        merge(contacts,0,contacts.length -1);
    }
    private static void merge(Contact[] a, int low, int high) {
        int middle = (low + high) / 2;
        if (high - low > 0) {
            merge(a, low, middle);
            merge(a, middle + 1, high);
            Contact[] temp = new Contact[high + 1]; // put in class
            for (int i = low; i <= high; i++)
                temp[i] = a[i];
            int i = low;
            int j = middle + 1;
            int k = low;
            while (i <= middle && j <= high) {
                if (temp[i].compareTo(temp[j]) <= 0) {
                    a[k] = temp[i];
                    i++;
                } else {
                    a[k] = temp[j];
                    j++;
                }
                k++;
            }
            while (i <= middle) {
                a[k] = temp[i];
                k++;
                i++;
            }
        }
    }
}
