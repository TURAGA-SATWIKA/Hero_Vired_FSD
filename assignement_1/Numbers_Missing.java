import java.util.*;
class Numbers_Missing
{
    public static void main(String args[])
    {
        // int[] arr = {1, 2, 4, 5, 7, 8};
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        int n = arr.length;
        int max = arr[n-1];
        int[] temp = new int[max];
        
        // Mark all the numbers in the array as present
        for (int i = 0; i < n; i++) {
            temp[arr[i]-1] = 1;
        }
        
        // Find the missing numbers
        for (int i = 0; i < max; i++) {
            if (temp[i] == 0) {
                System.out.print((i+1) + " ");
            }
        }
    }
}