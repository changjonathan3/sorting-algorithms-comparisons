/**
 * @author Jonathan Chang
 * Assig 4 Main
 * Sherif Khattab
 * CS 445 Fall 17
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Assig4{
    public static void main (String [] args){
        //SETTING UP THIS TRIAL RUN
        Scanner s=new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size=s.nextInt();
        System.out.print("Enter number of trials: ");
        int trials=s.nextInt();
        s.nextLine();
        System.out.print("Enter file name: ");
        String file = s.nextLine();
        System.out.println();

        //18 Times, 3 for each algorithm
        long oneR = 0; long oneS=0; long oneV=0;
        long twoR = 0; long twoS=0; long twoV=0;
        long threeR = 0; long threeS=0; long threeV=0;
        long fourR=0; long fourS=0; long fourV=0;
        long fiveR=0; long fiveS=0; long fiveV=0;
        long sixR=0; long sixS=0; long sixV=0;

        //REPEAT TEST FOR NUMBER OF TRIALS
        for(int t=0;t<trials;t++){
            //CREATE THREE ARRAYS USED
            int [] randA = new int[size];
            int [] sortA = new int[size];
            int [] revA = new int [size];
            //1) RANDOM
            for(int i=0;i<size;i++){
                randA[i] = ThreadLocalRandom.current().nextInt(1, size + 1);
            }
            //2) SORTED
            for(int i=0;i<size;i++){
                sortA[i]=i+1;
            }

            //3) REVERSE
            for(int i=0; i<size; i++)
            {
                revA[i]=revA.length-i;
            }

            //REPEAT 3 TIMES (random, sort, reverse arrays)
            int dataType = 0;
            for(;dataType<3;dataType++){
                int [] arr=null;
                long start=0; long finish=0; long delta=0;
                //1) Random
                if(dataType==0){
                    arr=randA;
                }
                //2) Sort
                if(dataType==1){
                    arr=sortA;
                }
                //3) Rev
                if(dataType==2){
                    arr=revA;
                }

                //Test the 6 algorithm cases here
                //Deep copy for each array
                //Time each one (separate time per data configuration)
                //Trace Output Mode if Needed (<=20 array size)

                //1) Simple QuickSort (only for smaller arrays)
                if(size<=100000){
                    Integer [] qs = new Integer[arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        qs[i] = arr[i];
                    }
                    //TIME HERE
                    Quick quick=new Quick();
                    start = System.nanoTime();
                    quick.quickSort(qs,qs.length);
                    finish = System.nanoTime();
                    delta=finish-start;
                    if(dataType==0){
                        oneR=delta+oneR;
                    }
                    if(dataType==1){
                        oneS=delta+oneS;
                    }
                    if(dataType==2){
                        oneV=delta+oneV;
                    }
                    if(size<=20){ //TRACE OUTPUT MODE
                        System.out.println("Algorithm: SimpleQuickSort");
                        System.out.println("Array Size: "+size);
                        if(dataType==0)
                            System.out.println("Data Configuration: Random");
                        if(dataType==1)
                            System.out.println("Data Configuration: Sorted");
                        if(dataType==2)
                            System.out.println("Data Configuration: Reversed");
                        System.out.println("Initial Data: " + Arrays.toString(arr));
                        System.out.println("Sorted Data: "+ Arrays.toString(qs));
                        System.out.println();
                    }
                }

                //2) Median of Three (5)
                Integer [] mtF = new Integer[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    mtF[i] = arr[i];
                }
                TextMergeQuick mtFive=new TextMergeQuick();
                start = System.nanoTime();
                mtFive.quickSort(mtF,mtF.length,5);
                finish = System.nanoTime();
                delta=finish-start;
                if(dataType==0){
                    twoR=delta+twoR;
                }
                if(dataType==1){
                    twoS=delta+twoS;
                }
                if(dataType==2){
                    twoV=delta+twoV;
                }
                if(size<=20){
                    System.out.println("Algorithm: Median of Three (5)");
                    System.out.println("Array Size: "+size);
                    if(dataType==0)
                        System.out.println("Data Configuration: Random");
                    if(dataType==1)
                        System.out.println("Data Configuration: Sorted");
                    if(dataType==2)
                        System.out.println("Data Configuration: Reversed");
                    System.out.println("Initial Data: " + Arrays.toString(arr));
                    System.out.println("Sorted Data: "+ Arrays.toString(mtF));
                    System.out.println();
                }

                //3) Median of Three (20)
                Integer [] mtT = new Integer[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    mtT[i] = arr[i];
                }
                TextMergeQuick mtTwen=new TextMergeQuick();
                start = System.nanoTime();
                mtTwen.quickSort(mtT,mtT.length,20);
                finish = System.nanoTime();
                delta=finish-start;
                if(dataType==0){
                    threeR=delta+threeR;
                }
                if(dataType==1){
                    threeS=delta+threeS;
                }
                if(dataType==2){
                    threeV=delta+threeV;
                }
                if(size<=20){
                    System.out.println("Algorithm: Median of Three (20)");
                    System.out.println("Array Size: "+size);
                    if(dataType==0)
                        System.out.println("Data Configuration: Random");
                    if(dataType==1)
                        System.out.println("Data Configuration: Sorted");
                    if(dataType==2)
                        System.out.println("Data Configuration: Reversed");
                    System.out.println("Initial Data: " + Arrays.toString(arr));
                    System.out.println("Sorted Data: "+ Arrays.toString(mtT));
                    System.out.println();
                }

                //4) Median of Three (100)
                Integer [] mtH = new Integer[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    mtH[i] = arr[i];
                }
                TextMergeQuick mtHun=new TextMergeQuick();
                start = System.nanoTime();
                mtHun.quickSort(mtH,mtH.length,100);
                finish = System.nanoTime();
                delta=finish-start;
                if(dataType==0){
                    fourR=delta+fourR;
                }
                if(dataType==1){
                    fourS=delta+fourS;
                }
                if(dataType==2){
                    fourV=delta+fourV;
                }
                if(size<=20){
                    System.out.println("Algorithm: Median of Three (100)");
                    System.out.println("Array Size: "+size);
                    if(dataType==0)
                        System.out.println("Data Configuration: Random");
                    if(dataType==1)
                        System.out.println("Data Configuration: Sorted");
                    if(dataType==2)
                        System.out.println("Data Configuration: Reversed");
                    System.out.println("Initial Data: " + Arrays.toString(arr));
                    System.out.println("Sorted Data: "+ Arrays.toString(mtH));
                    System.out.println();
                }

                //5) Random Pivot (5)
                Integer [] rP = new Integer[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    rP[i] = arr[i];
                }
                RandQuick rPiv=new RandQuick();
                start = System.nanoTime();
                rPiv.quickSort(rP,rP.length);
                finish = System.nanoTime();
                delta=finish-start;
                if(dataType==0){
                    fiveR=delta+fiveR;
                }
                if(dataType==1){
                    fiveS=delta+fiveS;
                }
                if(dataType==2){
                    fiveV=delta+fiveV;
                }
                if(size<=20){
                    System.out.println("Algorithm: Random Pivot");
                    System.out.println("Array Size: "+size);
                    if(dataType==0)
                        System.out.println("Data Configuration: Random");
                    if(dataType==1)
                        System.out.println("Data Configuration: Sorted");
                    if(dataType==2)
                        System.out.println("Data Configuration: Reversed");
                    System.out.println("Initial Data: " + Arrays.toString(arr));
                    System.out.println("Sorted Data: "+ Arrays.toString(rP));
                    System.out.println();
                }

                //6) MergeSort
                Integer [] mS = new Integer[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    mS[i] = arr[i];
                }
                TextMergeQuick merge=new TextMergeQuick();
                start = System.nanoTime();
                merge.mergeSort(mS,mS.length);
                finish = System.nanoTime();
                delta=finish-start;
                if(dataType==0){
                    sixR=delta+sixR;
                }
                if(dataType==1){
                    sixS=delta+sixS;
                }
                if(dataType==2){
                    sixV=delta+sixV;
                }
                if(size<=20){
                    System.out.println("Algorithm: MergeSort");
                    System.out.println("Array Size: "+size);
                    if(dataType==0)
                        System.out.println("Data Configuration: Random");
                    if(dataType==1)
                        System.out.println("Data Configuration: Sorted");
                    if(dataType==2)
                        System.out.println("Data Configuration: Reversed");
                    System.out.println("Initial Data: " + Arrays.toString(arr));
                    System.out.println("Sorted Data: "+ Arrays.toString(mS));
                    System.out.println();
                }
            }
        }

        //FINAL AVG TIMES
        double rOne=((double) oneR/(trials*1000000000));
        double rTwo=((double) twoR/(trials*1000000000));
        double rThree=((double) threeR/(trials*1000000000));
        double rFour=((double) fourR/(trials*1000000000));
        double rFive=((double) fiveR/(trials*1000000000));
        double rSix=((double) sixR/(trials*1000000000));

        double sOne=((double) oneS/(trials*1000000000));
        double sTwo=((double) twoS/(trials*1000000000));
        double sThree=((double) threeS/(trials*1000000000));
        double sFour=((double) fourS/(trials*1000000000));
        double sFive=((double) fiveS/(trials*1000000000));
        double sSix=((double) sixS/(trials*1000000000));

        double vOne=((double) oneV/(trials*1000000000));
        double vTwo=((double) twoV/(trials*1000000000));
        double vThree=((double) threeV/(trials*1000000000));
        double vFour=((double) fourV/(trials*1000000000));
        double vFive=((double) fiveV/(trials*1000000000));
        double vSix=((double) sixV/(trials*1000000000));

        //EXPORT txt
        try{
         PrintWriter writer = new PrintWriter(file, "UTF-8");
         // 1) The Random ones
            if(size<=100000){
                writer.println("Algorithm: Simple QuickSort");
                writer.println("Array Size: "+ size);
                writer.println("Order: Random");
                writer.println("Number of trials: " + trials);
                writer.println("Average Time: " + rOne + " sec.");
                writer.println();
            }

            writer.println("Algorithm: Median of Three (5)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Random");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + rTwo + " sec.");
            writer.println();
            writer.println("Algorithm: Median of Three (20)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Random");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + rThree + " sec.");
            writer.println();
            writer.println("Algorithm: Median of Three (100)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Random");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + rFour + " sec.");
            writer.println();
            writer.println("Algorithm: Random Pivot (5)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Random");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + rFive + " sec.");
            writer.println();
            writer.println("Algorithm: MergeSort");
            writer.println("Array Size: "+ size);
            writer.println("Order: Random");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + rSix + " sec.");
            writer.println();
         // 2) The sorted ones
            if(size<=100000){
                writer.println("Algorithm: Simple QuickSort");
                writer.println("Array Size: "+ size);
                writer.println("Order: Sorted");
                writer.println("Number of trials: " + trials);
                writer.println("Average Time: " + sOne + " sec.");
                writer.println();
            }

            writer.println("Algorithm: Median of Three (5)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Sorted");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + sTwo + " sec.");
            writer.println();
            writer.println("Algorithm: Median of Three (20)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Sorted");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + sThree + " sec.");
            writer.println();
            writer.println("Algorithm: Median of Three (100)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Sorted");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + sFour + " sec.");
            writer.println();
            writer.println("Algorithm: Random Pivot (5)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Sorted");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + sFive + " sec.");
            writer.println();
            writer.println("Algorithm: MergeSort");
            writer.println("Array Size: "+ size);
            writer.println("Order: Sorted");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + sSix + " sec.");
            writer.println();

            //3) The Reversed ones
            if(size<=100000){
                writer.println("Algorithm: Simple QuickSort");
                writer.println("Array Size: "+ size);
                writer.println("Order: Reverse");
                writer.println("Number of trials: " + trials);
                writer.println("Average Time: " + vOne + " sec.");
                writer.println();
            }

            writer.println("Algorithm: Median of Three (5)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Reverse");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + vTwo + " sec.");
            writer.println();
            writer.println("Algorithm: Median of Three (20)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Reverse");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + vThree + " sec.");
            writer.println();
            writer.println("Algorithm: Median of Three (100)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Reverse");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + vFour + " sec.");
            writer.println();
            writer.println("Algorithm: Random Pivot (5)");
            writer.println("Array Size: "+ size);
            writer.println("Order: Reverse");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + vFive + " sec.");
            writer.println();
            writer.println("Algorithm: MergeSort");
            writer.println("Array Size: "+ size);
            writer.println("Order: Reverse");
            writer.println("Number of trials: " + trials);
            writer.println("Average Time: " + vSix + " sec.");
            writer.println();
         writer.close();
        }
        catch(IOException e){
        }

    }
}