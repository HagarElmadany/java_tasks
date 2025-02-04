import java.util.Arrays;

class ArrayAlgorthms{
    public int max(int[]arr1){
        long startTime = System.nanoTime();
        int max=arr1[0];
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]>max)
            {
                max=arr1[i];
            }
        }
        long endTime =  System.nanoTime();
        long fullTime = endTime-startTime;
        System.out.println("Max search time: " +fullTime);
        return max;
    }
    public int min(int[]arr1){
        long startTime = System.nanoTime();
        int min=arr1[0];
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]<min)
            {
                min=arr1[i];
            }
        }
        long endTime = System.nanoTime();
        long fullTime = endTime-startTime;
        System.out.println("Min search time: " +fullTime);
        return min;
    }

    public int binarySearch(int[] arr1, int value) {
        long startTime = System.nanoTime();
        Arrays.sort(arr1);
        int low =0;
        int high =arr1.length -1;
        int mid;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(value == arr1[mid])
            {
                System.out.println("found"+value);
                return mid;
            }
            else if (value > arr1[mid])
                low = mid + 1;
            else
                high= mid - 1;
        }
        long endTime = System.nanoTime();
        long fullTime = endTime-startTime;
        System.out.println("Binary search time: " +fullTime);
        System.out.println("not found");
        return -1;
    }
}

public class Task3 {
    public static void main(String[] args){
        int arr[] = {23,92,93,50,123,152,70,90,60,33};
       ArrayAlgorthms obj =new ArrayAlgorthms();
       int minValue = obj.min(arr);
       int maxValue = obj.max(arr);
       int binarySearchValue = obj.binarySearch(arr,60);
        System.out.println("Minimum value is: " +minValue);
        System.out.println("Maximum value is: " +maxValue);
        System.out.println("Binary search index is:"+ binarySearchValue);
    }
    
}
