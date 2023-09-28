import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestAVLTree {

    private String inTreeArray(AVLTree tree, String[] strList) {
        boolean result = true;
        try {
            for (String str: strList) {
                result = result && tree.inTree(str);
            }
            return Boolean.toString(result);
        } catch (Exception e){
            return "ERROR";
        }
    }

    private void insertArray(AVLTree tree, String[] strList) {
        try {
            for (String str: strList) {
                tree.insert(str);
            }
        } catch (Exception e){
            System.out.println("ERROR INSERTING");
            System.out.println(e.toString());
        }
    }

    private String processPrintTree(AVLTree tree) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;

        System.setOut(ps);
        tree.print();

        System.out.flush();
        System.setOut(old);
        return baos.toString();
    }

    private String removeSpacesTabsNewLines(String str) {

        //return str.replaceAll("[\\n\\t ]", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' ||
                    str.charAt(i) == '3' || str.charAt(i) == '4' || str.charAt(i) == '5' ||
                    str.charAt(i) == '6' || str.charAt(i) == '7' || str.charAt(i) == '8' ||
                    str.charAt(i) == '9') {
                sb.append(str.charAt(i));
            }
            }

        return sb.toString();
    }

    private boolean comparePrintTrees(String truePrint, String testPrint) {
        return truePrint.compareTo(testPrint) == 0;
    }

    private void printTreeTest(AVLTree tree, String truePrintPre, String truePrintIn, String truePrintPost) {
        String testPrint = removeSpacesTabsNewLines(processPrintTree(tree));

        if (truePrintPre.compareTo("") == 0 && testPrint.compareTo("null") == 0) {
            System.out.println("Passed");
        } else if (comparePrintTrees(removeSpacesTabsNewLines(truePrintPre), testPrint) ||
                comparePrintTrees(removeSpacesTabsNewLines(truePrintIn), testPrint) ||
                comparePrintTrees(removeSpacesTabsNewLines(truePrintPost), testPrint)
        ) {
            System.out.println("Passed");
        } else {
            System.out.println("!FAILED!");
            System.out.println("-- True (Pre):");
            System.out.println(truePrintPre);
            System.out.println("-- Got :");
            tree.print();

        }
    }

    private void inTreeTest(AVLTree tree, String[] elementsToTest, boolean trueResult) {
        String result = inTreeArray(tree, elementsToTest);
        String trueResultStr = Boolean.toString(trueResult);
        if (result.compareTo("ERROR") == 0) {
            System.out.println("!FAILED! ERROR");
        }
        else if (result.compareTo(trueResultStr) == 0) {
            System.out.println("Passed");
        } else {
            System.out.println("!FAILED!");
        }
    }

    private void Test1() {
        System.out.println("###### Test 01 - Print empty Tree");
        AVLTree tree = new AVLTree();
        String truePrint = "";
        printTreeTest(tree, truePrint, truePrint, truePrint);
    }

    private void Test2() {
        System.out.println("###### Test 02 - Print test Tree");
        AVLTree tree = new AVLTree();
        tree.createTestTree();
        String truePrintPre = "4\n  2\n    1\n    3\n  6\n    5\n    7";
        String truePrintIn = "    1\n  2\n    3\n4\n    5\n  6\n    7";
        String truePrintPost = "    1\n    3\n  2\n    5\n    7\n  6\n4";

        printTreeTest(tree, truePrintPre, truePrintIn, truePrintPost);
    }

    private void Test3() {
        System.out.println("###### Test 03 - inTree empty tree");
        AVLTree tree = new AVLTree();
        String[] testArray = {"1", "5", "6"};

        inTreeTest(tree, testArray, false);
    }

    private void Test4() {
        System.out.println("###### Test 04 - inTree all elements of test tree");
        AVLTree tree = new AVLTree();
        tree.createTestTree();
        String[] testArray = {"1", "2", "3", "4", "5", "6", "7"};

        inTreeTest(tree, testArray, true);
    }

    private void Test5() {
        System.out.println("###### Test 05 - inTree elements not in test tree");
        AVLTree tree = new AVLTree();
        tree.createTestTree();
        String[] testArray = {"7", "0", "9"};

        inTreeTest(tree, testArray, false);
    }

    private void Test6() {
        System.out.println("###### Test 06 - insert one element in empty tree and print Tree");
        AVLTree tree = new AVLTree();
        insertArray(tree, new String[]{"5"});
        String truePrint = "5";

        printTreeTest(tree, truePrint, truePrint, truePrint);
    }

    private void Test7() {
        System.out.println("###### Test 07 - insert one element in empty tree and inTree it");
        AVLTree tree = new AVLTree();
        insertArray(tree, new String[]{"5"});
        String[] testArray = {"5"};

        inTreeTest(tree, testArray, true);
    }

    private void Test8() {
        System.out.println("###### Test 08 - insert several elements in empty tree (no bad balance) and inTree them");
        AVLTree tree = new AVLTree();
        insertArray(tree, new String[]{"4", "3", "5", "2", "1", "6", "7"});
        String[] testArray = {"1", "2", "3", "4", "5", "6", "7"};

        inTreeTest(tree, testArray, true);
    }

    private void Test9() {
        System.out.println("###### Test 09 - insert several elements in empty tree (no bad balance) and printTree");
        AVLTree tree = new AVLTree();
        insertArray(tree, new String[]{"4", "2", "6", "3", "5", "1", "7"});
        String truePrintPre = "4\n  2\n    1\n    3\n  6\n    5\n    7";
        String truePrintIn = "    1\n  2\n    3\n4\n    5\n  6\n    7";
        String truePrintPost = "    1\n    3\n  2\n    5\n    7\n  6\n4";

        printTreeTest(tree, truePrintPre, truePrintIn, truePrintPost);
    }

    private void Test10() {
        System.out.println("###### Test 10 - insert element that's already there and inTree them");
        AVLTree tree = new AVLTree();
        tree.createTestTree();
        insertArray(tree, new String[]{"6"});
        String[] testArray = {"1", "2", "3", "4", "5", "6", "7"};

        inTreeTest(tree, testArray, true);
    }
    private void Test11() {
        System.out.println("###### Test 11 - insert element that's already there and printTree");
        AVLTree tree = new AVLTree();
        tree.createTestTree();
        insertArray(tree, new String[]{"6"});
        String truePrintPre = "4\n  2\n    1\n    3\n  6\n    5\n    7";
        String truePrintIn = "    1\n  2\n    3\n4\n    5\n  6\n    7";
        String truePrintPost = "    1\n    3\n  2\n    5\n    7\n  6\n4";

        printTreeTest(tree, truePrintPre, truePrintIn, truePrintPost);
    }


    private void Test12() {
        System.out.println("###### Test 12 - insert elements in test tree (no bad balance) and inTree them");
        AVLTree tree = new AVLTree();
        tree.createTestTree();
        insertArray(tree, new String[]{"0", "9"});
        String[] testArray = {"1", "2", "3", "4", "5", "6", "7", "0", "9"};

        inTreeTest(tree, testArray, true);
    }

    private void Test13() {
        System.out.println("###### Test 13 - insert elements in test tree (no bad balance) and printTree");
        AVLTree tree = new AVLTree();
        tree.createTestTree();
        insertArray(tree, new String[]{"0", "9"});
        String truePrintPre = "4\n  2\n    1\n      0\n    3\n  6\n    5\n    7\n      9";
        String truePrintIn = "      0\n    1\n  2\n    3\n4\n    5\n  6\n    7\n      9";
        String truePrintPost = "      0\n    1\n    3\n  2\n    5\n      9\n    7\n  6\n4";

        printTreeTest(tree, truePrintPre, truePrintIn, truePrintPost);
    }

    private void Test14() {
        System.out.println("###### Test 14 - Balancing LL");
        AVLTree tree = new AVLTree();
        insertArray(tree, new String[]{"4", "5", "6"});
        String truePrintPre = "5\n  4\n  6";
        String truePrintIn = "  4\n5\n  6";
        String truePrintPost = "  4\n  6\n5";

        printTreeTest(tree, truePrintPre, truePrintIn, truePrintPost);
    }

    private void Test15() {
        System.out.println("###### Test 15 - Balancing RR");
        AVLTree tree = new AVLTree();
        insertArray(tree, new String[]{"4", "3", "2"});
        String truePrintPre = "3\n  2\n  4";
        String truePrintIn = "  2\n3\n  4";
        String truePrintPost = "  2\n  4\n3";

        printTreeTest(tree, truePrintPre, truePrintIn, truePrintPost);
    }

    private void Test16() {
        System.out.println("###### Test 16 - insert elements of testTree (with bad balances) and printTree");
        AVLTree tree = new AVLTree();
        insertArray(tree, new String[]{"1", "2", "3", "4", "5", "6", "7"});
        String truePrintPre = "4\n  2\n    1\n    3\n  6\n    5\n    7";
        String truePrintIn = "    1\n  2\n    3\n4\n    5\n  6\n    7";
        String truePrintPost = "    1\n    3\n  2\n    5\n    7\n  6\n4";

        printTreeTest(tree, truePrintPre, truePrintIn, truePrintPost);
    }

    private void Test17() {
        System.out.println("###### Test 17 - Balancing RL");
        AVLTree tree = new AVLTree();
        insertArray(tree, new String[]{"6", "7", "8"});
        String truePrintPre = "7\n  6\n  8";
        String truePrintIn = "  6\n7\n  8";
        String truePrintPost = "  6\n  8\n7";

        printTreeTest(tree, truePrintPre, truePrintIn, truePrintPost);
    }

    private void Test18() {
        System.out.println("###### Test 18 - Balancing LR");
        AVLTree tree = new AVLTree();
        insertArray(tree, new String[]{"6", "4", "5"});
        String truePrintPre = "5\n  4\n  6";
        String truePrintIn = "  4\n5\n  6";
        String truePrintPost = "  4\n  6\n5";

        printTreeTest(tree, truePrintPre, truePrintIn, truePrintPost);
    }

    private void Test19() {
        System.out.println("###### Test 19 - Balancing General");
        AVLTree tree = new AVLTree();
        insertArray(tree, new String[]{"4", "6", "5", "2", "3", "8", "7", "1", "0", "9"});
        String truePrintPre = "5\n  3\n    1\n      0\n      2\n    4\n  7\n    6\n    8\n      9";
        String truePrintIn = "      0\n    1\n      2\n  3\n    4\n5\n    6\n  7\n    8\n      9";
        String truePrintPost = "      0\n      2\n    1\n    4\n  3\n    6\n      9\n    8\n  7\n5";

        printTreeTest(tree, truePrintPre, truePrintIn, truePrintPost);
    }

    private void TestTest(){
        System.out.println("###### TEST TEST");
        AVLTree tree = new AVLTree();
        tree.createTestTree();
        tree.print();
    }


    public static void main(String[] args) {
        TestAVLTree test = new TestAVLTree();
        //test.Test1();
        test.Test2();
        test.Test3();
        test.Test4();
        test.Test5();
        test.Test6();
        test.Test7();
        test.Test8();
        test.Test9();
        //test.Test10();
        //test.Test11();
        test.Test12();
        test.Test13();
        test.Test14();
        test.Test15();
        test.Test16();
        test.Test17();
        test.Test18();
        test.Test19();
    }
}