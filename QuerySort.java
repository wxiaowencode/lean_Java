public class QuerySort {

    public static void main(String[] args) {
        int arr[]={8,9,6,54,6,3,5,6,7,8,23,4,56,78,45,34,89,678,4564,999,9,10};
        qS(arr,0,arr.length-1);
        for (int x:arr) {
            System.out.print(x+" ");
        }
    }

    //分而治之 挖坑法 找基准
    public static int part(int[] arr,int l,int r){
        int te=arr[l];
        while(l<r){
            //必须先从右边开始找
         while(l<r && arr[r]>=te){
             r--;
         }
         arr[l]=arr[r];
         while(l<r && arr[l]<=te){
             l++;
         }
         arr[r]=arr[l];
        }
       arr[l]=te;
      return l;
    }
    public static void qS(int[] arr,int s,int e){
        if(s>=e){
            return;
        }
        int p=part(arr,s,e);
        qS(arr,s,p-1);
        qS(arr,p+1,e);
    }
}
