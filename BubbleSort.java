public class BubbleSort {


    public static void main(String[] args) {
        int arr[]={8,5,7,8,34,78,45,67,89,23,89,999,789};
        int a ,b;

       //bubbleSort(arr);
        selectionSort(arr);
        for (int x:arr) {
            System.out.print(x+" ");
        }
        System.out.println(" ");
        System.out.println("=============");
    }

    public static int[] selectionSort(int[] arr){
        int minIndex = 0,temp=0;//minIndex 最小下标
        for(int i=0;i<arr.length-1;i++){ //i下标必须从0开始，否则第一个数就没有进行判断。
            minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
        return arr;
    }
      public static int[] bubbleSort(int [] arr){
        //冒泡
        for(int i=1;i<arr.length;i++){ //循环的次数，当还剩1个数的时候就不用循环了，所以i=1;
            for(int j=0;j<arr.length-i;j++){//-i是最后面已经排好序的几个
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
