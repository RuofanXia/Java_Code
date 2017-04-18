
public class RecursiveSelectionSorting {
	public static int[] recursiveSelectionSort(int[] list, int n) {
        if (n == list.length - 1) {
            return list;
        }
        int temp, lowestIndex = n;
        for (int i = n + 1; i < list.length; i++) {
            if (list[i] < list[lowestIndex]) {
                lowestIndex = i;
            }
        }
        temp = list[n];
        list[n] = list[lowestIndex];
        list[lowestIndex] = temp;
        return recursiveSelectionSort(list, n+1);
    }
	public static void main(String[] args)
	{
		int[] a = {1,6,2,3,5,4};
		recursiveSelectionSort(a, 0);
		for (int i=0; i<a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
}
