import java.util.Arrays;
public class Quick{

  private static void switchPlace(int[] data, int first, int second){
    int temp = data[first];
    data[first] = data[second];
    data[second] = temp;
  }
  public static int median(int x, int y, int z){
    if ((x > y && x < z ) || (x < y && x > z )) return 0;
    if ((x > y && y > z ) || (x < y && y < z )) return 1;
    return 2;
  }
  public static int partition(int[] data, int start, int end){
    if (start<0 || start>= data.length || end < 0 || end >= data.length){
      throw new IndexOutOfBoundsException();
    }
    int mid = ((end-start) / 2) + start;
  int med = median(data[start], data[mid], data[end]);//whichever value is the median value is switched with the end value, and becomes the pivot

  if (med == 0){
    switchPlace(data, start, end);
  }
  else if (med == 1){
    switchPlace(data, mid, end);
  }
else{
   switchPlace(data, end, end);
 }

int pivot = data[end];//swapped value become pivot
  int upper = end;
  int lower = start-1;//
  for (int i = start; i < upper; i++){
    if (data[i] < pivot){
      lower++;
      switchPlace(data, lower, i);//swap places every time a value smaller than pivot
    }
  }
  switchPlace(data, lower+1, end);//swap last 2 values

  return lower+1;//returns index of pivot
  }

  public static int quickselect(int[] data, int k){
    return quickselectH(data, k, 0, data.length-1);
  }
  private static int quickselectH(int[] data, int k, int start, int end){
    int pivot = partition(data, start, end);
    if (pivot == k){//if pivot = index then quickselect is done
      return data[k];
    }

    else if (k > pivot){//recursively solve
      return quickselectH(data, k, pivot+1, end);//if index greater than pivot, only return partition from pivot+ 1 to the end;
    }
    else if (k < pivot){
      return quickselectH(data, k, start, pivot-1);
    }
    else return data[pivot];
  }

  public static void quicksort(int[] data){
    quickSortH(data, 0, data.length-1);
    }
    private static void quickSortH(int[] data, int start, int end){
      if (start>=end) return;
      else{
      int pivot = partition(data, start, end);
      quickSortH(data, start, pivot-1);// sort the array by halves.
      quickSortH(data, pivot+1, end);// stack overflow when driver runs for too long???
    }
    }

    public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}
