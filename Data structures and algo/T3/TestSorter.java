import java.util.List;
public class TestSorter {
    private String printArray(Contact[] arr) {
        StringBuilder s = new StringBuilder();
        for (Contact contact : arr) {
            s.append(contact.toString()).append(" || ");
        }
        return s.toString();
    }

    private boolean compareArrays(Contact[] true_arr, Contact[] test_arr) {
        return printArray(true_arr).compareTo(printArray(test_arr)) == 0;
    }

    private void testMethod(Contact[] true_arr, Contact[] test_arr, String method) {
        if (compareArrays(true_arr, test_arr)) {
            System.out.println(method + " - passed");
        } else {
            System.out.println(method + " - !FAILED!");
            System.out.println("True:  " + printArray(true_arr));
            System.out.println("Got:   " + printArray(test_arr));
        }
    }

    private void testGeneral(Contact[] unsorted, Contact[] sorted) {
        Contact[] test_arr;
        Contact[] errorArr = new Contact[1];
        Contact[] stackOverflow = new Contact[1];
        errorArr[0] = new Contact("ERROR", "ERROR");
        stackOverflow[0] = new Contact("STACK", "OVERFLOW");
        test_arr = unsorted.clone();

        try {
            Sorter.selectionSort(test_arr);
            testMethod(sorted, test_arr, "selectionSort");
        } catch (Exception e) {
            testMethod(sorted, errorArr, "selectionSort");
        } catch (StackOverflowError e){
            testMethod(sorted, stackOverflow, "selectionSort");
        }


        test_arr = unsorted.clone();
        try {
            Sorter.insertionSort(test_arr);
            testMethod(sorted, test_arr, "insertionSort");
        } catch (Exception e) {
            testMethod(sorted, errorArr, "insertionSort");
        } catch (StackOverflowError e){
            testMethod(sorted, stackOverflow, "insertionSort");
        }

    test_arr = unsorted.clone();
        try {
            Sorter.quickSort(test_arr);
            testMethod(sorted, test_arr, "quickSort    ");
        } catch (Exception e) {
            System.out.println(e.toString());
            testMethod(sorted, errorArr, "quickSort    ");
        } catch (StackOverflowError e){
            testMethod(sorted, stackOverflow, "quickSort    ");
        }

    test_arr = unsorted.clone();
        try {
            Sorter.mergeSort(test_arr);
            testMethod(sorted, test_arr, "mergeSort    ");
        } catch (Exception e) {
            testMethod(sorted, errorArr, "mergeSort    ");
        } catch (StackOverflowError e){
            testMethod(sorted, stackOverflow, "mergeSort    ");
        }
}

    private void Test1() {
        // One element array
        Contact[] unsorted = new Contact[1];
        Contact[] sorted;
        unsorted[0] = new Contact("David", "Fernandes");
        sorted = unsorted.clone();

        System.out.println("###### Test 01 - One element array");
        testGeneral(unsorted, sorted);
        System.out.println();

    }

    private void Test2() {
        // Sorted two element array
        Contact[] unsorted = new Contact[2];
        Contact[] sorted;
        unsorted[0] = new Contact("David", "Fernandes");
        unsorted[1] = new Contact("Jack", "Saunders");
        sorted = unsorted.clone();

        System.out.println("###### Test 02 - Sorted two element array");
        testGeneral(unsorted, sorted);
        System.out.println();
    }

    private void Test3() {
        // Unsorted two element array
        Contact[] unsorted = new Contact[2];
        Contact[] sorted = new Contact[2];
        unsorted[0] = new Contact("Jack", "Saunders");
        unsorted[1] = new Contact("David", "Fernandes");

        sorted[0] = new Contact("David", "Fernandes");
        sorted[1] = new Contact("Jack", "Saunders");

        System.out.println("###### Test 03 - Unsorted two element array");
        testGeneral(unsorted, sorted);
        System.out.println();
    }

    private void Test4() {
        // Sorted three element array
        Contact[] unsorted = new Contact[3];
        Contact[] sorted = new Contact[3];
        unsorted[0] = new Contact("David", "Fernandes");
        unsorted[1] = new Contact("Christof", "Lutteroth");
        unsorted[2] = new Contact("Jack", "Saunders");

        sorted[0] = new Contact("David", "Fernandes");
        sorted[1] = new Contact("Christof", "Lutteroth");
        sorted[2] = new Contact("Jack", "Saunders");

        System.out.println("###### Test 04  - Sorted three element array");
        testGeneral(unsorted, sorted);
        System.out.println();
    }

    private void Test5() {
        // Unsorted three element array
        Contact[] unsorted = new Contact[3];
        Contact[] sorted = new Contact[3];
        unsorted[0] = new Contact("Christof", "Lutteroth");
        unsorted[1] = new Contact("Jack", "Saunders");
        unsorted[2] = new Contact("David", "Fernandes");

        sorted[0] = new Contact("David", "Fernandes");
        sorted[1] = new Contact("Christof", "Lutteroth");
        sorted[2] = new Contact("Jack", "Saunders");

        System.out.println("###### Test 05 - Unsorted three element array");
        testGeneral(unsorted, sorted);
        System.out.println();
    }

    private void Test6() {
        // Unsorted same last names
        Contact[] unsorted = new Contact[3];
        Contact[] sorted = new Contact[3];
        unsorted[0] = new Contact("Christof", "Lutteroth");
        unsorted[1] = new Contact("Jack", "Lutteroth");
        unsorted[2] = new Contact("David", "Lutteroth");

        sorted[0] = new Contact("Christof", "Lutteroth");
        sorted[1] = new Contact("David", "Lutteroth");
        sorted[2] = new Contact("Jack", "Lutteroth");

        System.out.println("###### Test 06 - Unsorted same last names");
        testGeneral(unsorted, sorted);
        System.out.println();
    }

    private void Test7() {
        // Unsorted same first names
        Contact[] unsorted = new Contact[3];
        Contact[] sorted = new Contact[3];
        unsorted[0] = new Contact("Christof", "Lutteroth");
        unsorted[1] = new Contact("Christof", "Saunders");
        unsorted[2] = new Contact("Christof", "Fernandes");

        sorted[0] = new Contact("Christof", "Fernandes");
        sorted[1] = new Contact("Christof", "Lutteroth");
        sorted[2] = new Contact("Christof", "Saunders");

        System.out.println("###### Test 07 - Unsorted same first names");
        testGeneral(unsorted, sorted);
        System.out.println();
    }

    private void Test8() {
        // Unsorted last names differ in second letter
        Contact[] unsorted = new Contact[3];
        Contact[] sorted = new Contact[3];
        unsorted[0] = new Contact("Christof", "Lutteroth");
        unsorted[1] = new Contact("Christof", "Latteroth");
        unsorted[2] = new Contact("Christof", "Letteroth");

        sorted[0] = new Contact("Christof", "Latteroth");
        sorted[1] = new Contact("Christof", "Letteroth");
        sorted[2] = new Contact("Christof", "Lutteroth");

        System.out.println("###### Test 08 - Unsorted last names differ in second letter");
        testGeneral(unsorted, sorted);
        System.out.println();
    }

    private void Test9() {
        // Unsorted first names differ in second letter
        Contact[] unsorted = new Contact[3];
        Contact[] sorted = new Contact[3];
        unsorted[0] = new Contact("Divid", "Fernandes");
        unsorted[1] = new Contact("Devid", "Fernandes");
        unsorted[2] = new Contact("David", "Fernandes");

        sorted[0] = new Contact("David", "Fernandes");
        sorted[1] = new Contact("Devid", "Fernandes");
        sorted[2] = new Contact("Divid", "Fernandes");

        System.out.println("###### Test 09 - Unsorted first names differ in second letter");
        testGeneral(unsorted, sorted);
        System.out.println();
    }

    private void Test10() {
        // Unsorted first names differ in second letter
        Contact[] unsorted = new Contact[3];
        Contact[] sorted = new Contact[3];
        unsorted[0] = new Contact("Juck", "Saunders");
        unsorted[1] = new Contact("Juck", "Seunders");
        unsorted[2] = new Contact("Jack", "Saunders");

        sorted[0] = new Contact("Jack", "Saunders");
        sorted[1] = new Contact("Juck", "Saunders");
        sorted[2] = new Contact("Juck", "Seunders");

        System.out.println("###### Test 10 - Unsorted last first and last names differ in second letter");
        testGeneral(unsorted, sorted);
        System.out.println();
    }

    private void Test11() {
        // Combination of first and last names
        Contact[] unsorted = new Contact[9];
        Contact[] sorted = new Contact[9];
        unsorted[0] = new Contact("David", "Lutteroth");
        unsorted[1] = new Contact("Christof", "Fernandes");
        unsorted[2] = new Contact("Jack", "Saunders");
        unsorted[3] = new Contact("Christof", "Saunders");
        unsorted[4] = new Contact("Christof", "Lutteroth");
        unsorted[5] = new Contact("Jack", "Fernandes");
        unsorted[6] = new Contact("David", "Saunders");
        unsorted[7] = new Contact("Jack", "Lutteroth");
        unsorted[8] = new Contact("David", "Fernandes");

        sorted[0] = new Contact("Christof", "Fernandes");
        sorted[1] = new Contact("David", "Fernandes");
        sorted[2] = new Contact("Jack", "Fernandes");
        sorted[3] = new Contact("Christof", "Lutteroth");
        sorted[4] = new Contact("David", "Lutteroth");
        sorted[5] = new Contact("Jack", "Lutteroth");
        sorted[6] = new Contact("Christof", "Saunders");
        sorted[7] = new Contact("David", "Saunders");
        sorted[8] = new Contact("Jack", "Saunders");

        System.out.println("###### Test 11 - Combination of first and last names");
        testGeneral(unsorted, sorted);
        System.out.println();
    }

    private void Test12() {
        // Combination of first and last names with repetitions
        Contact[] unsorted = new Contact[11];
        Contact[] sorted = new Contact[11];
        unsorted[0] = new Contact("David", "Lutteroth");
        unsorted[1] = new Contact("Christof", "Fernandes");
        unsorted[2] = new Contact("Jack", "Saunders");
        unsorted[3] = new Contact("Christof", "Saunders");
        unsorted[4] = new Contact("Christof", "Lutteroth");
        unsorted[5] = new Contact("Jack", "Fernandes");
        unsorted[6] = new Contact("David", "Saunders");
        unsorted[7] = new Contact("Jack", "Lutteroth");
        unsorted[8] = new Contact("David", "Fernandes");
        unsorted[9] = new Contact("Christof", "Lutteroth");
        unsorted[10] = new Contact("Jack", "Fernandes");

        sorted[0] = new Contact("Christof", "Fernandes");
        sorted[1] = new Contact("David", "Fernandes");
        sorted[2] = new Contact("Jack", "Fernandes");
        sorted[3] = new Contact("Jack", "Fernandes");
        sorted[4] = new Contact("Christof", "Lutteroth");
        sorted[5] = new Contact("Christof", "Lutteroth");
        sorted[6] = new Contact("David", "Lutteroth");
        sorted[7] = new Contact("Jack", "Lutteroth");
        sorted[8] = new Contact("Christof", "Saunders");
        sorted[9] = new Contact("David", "Saunders");
        sorted[10] = new Contact("Jack", "Saunders");

        System.out.println("###### Test 12 - Combination of first and last names with repetitions");
        testGeneral(unsorted, sorted);
        System.out.println();
    }
    public static void main(String[] args) {
        TestSorter test = new TestSorter();
        test.Test1();
        test.Test2();
        test.Test3();
        test.Test4();
        test.Test5();
        test.Test6();
        test.Test7();
        test.Test8();
        test.Test9();
        test.Test10();
        test.Test11();
        test.Test12();
    }
}
