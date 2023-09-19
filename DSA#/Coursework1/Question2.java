public class Question2 {
    public static void main(String[] args) {
        //TODO implement this
        int[] numbers = {1,100,1000,10000};
        double Time1;
        double Time2;
        StringRepeater s = new StringRepeater();

        for(int i:numbers){
            Time1 = System.nanoTime();
            s.repeatString("hello", i);
            Time2 = System.nanoTime();
            System.out.println("T(" + i + ") = " + (Time2 - Time1) / 1000000000 + " seconds");
        }

        for(int d:numbers) {
            Time1=0;
            Time2=0;
            for(int x = 0;x<100;++x){
                Time1 = Time1 + System.nanoTime();
                s.repeatString("hello", d);
                Time2 = Time2 + System.nanoTime();
            }
            System.out.println("T(" + d + ") = " + (Time2 - Time1)/100 /1000000000 + " seconds");
        }



    }
}