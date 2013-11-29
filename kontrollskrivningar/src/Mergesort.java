import java.util.Arrays;

/**
 * Uppgift 1
 * Från kontrollskrivning 2012-11-19
 *
 * Allt utom merge() är extra
 */

public class Mergesort {

    public static void main(String[] args) {
        int[] a = sort(new int[] {2, 3, 5, 1, 3, 6, 1});
        for( int n : a ) {
            System.out.print(n + " ");
        }

        System.out.println("");
        int[] b = merge(new int[] {2, 3, 5, 7},  new int[] {3, 6, 9});
        for( int n : b ) {
            System.out.print(n + " ");
        }
    }

    public static int[] sort(int[] a) {
        if (a.length > 2) {
            int[] a1 = sort(Arrays.copyOfRange(a, 0, a.length/2));
            int[] a2 = sort(Arrays.copyOfRange(a, a.length/2, a.length-1));
            return merge(a1, a2);
        } else if (a.length == 2) {
            if (a[0] > a[1]) return new int[] {a[1], a[0]};
            else return a;
        } else {
            return a;
        }
    }

    public static int[] merge(int[] v1, int[] v2) {
        int i = 0, j = 0;
        int k = 0;
        int[] a = new int[v1.length+v2.length];

        while (i < v1.length && j < v2.length) {
            if (v1[i] < v2[j]) {
                a[k] = v1[i];
                i++;
            } else {
                a[k] = v2[j];
                j++;
            }
            k++;
        }

        while (i < v1.length) {
            a[k] = v1[i];
            i++;
            k++;
        }

        while (j < v2.length) {
            a[k] = v2[j];
            j++;
            k++;
        }

        return a;
    }
}
