import java.util.Scanner;

class Cumulative_Sum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int prefix_arr[] = new int[n];
        prefix_arr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix_arr[i] = prefix_arr[i - 1] + arr[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(prefix_arr[i] + " ");
        }
    }
}
