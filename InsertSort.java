public class InsertSort {
    public static void main(String[] args) {
        int arr[]={8,9,6,54,6,3,5,6,7,8,23,4,56,78,45,34,89,678,4564,999,9,10};
        insertSort(arr);
        for (int x:arr) {
            System.out.print(x+" ");
        }
    }
    public static int[] insertSort(int[] arr){
        int preIndex=0,current=0; //preIndex 前一个元素的下标  current当前元素
        for(int i=1;i<arr.length;i++){ //循环长度-1次
            preIndex=i-1;//下标从0开始
            current=arr[i];//当前元素
            while(preIndex>=0 && arr[preIndex]>current){//如果前一个元素大于当前元素
                arr[preIndex+1]=arr[preIndex]; // 让前一个元素往后移动一个位置
                preIndex--;
            }
            arr[preIndex+1]=current;
        }
        return arr;
    }
}
