public class Quick{
  public static int partition(int[] data, int start, int end){
    if (start<0 || start>= data.length || end < 0 || end >= data.length){
      throw new IndexOutOfBoundsException();
    }

  int random = (int)(Math.random() * (end - start) + start+1);
  int pivot = data[random];
  int upper = end;
  int lower = start;
  while (lower < upper){
    while (lower <=upper && data[lower] < pivot){//while elements in array are lower than the pivot, start working with smaller part of array
      lower++;
    }
    while (upper>= lower && data[upper] > pivot){
      upper--;
    }
    if (upper>lower){//once gone through all values except last 3, swap the 2 ends
      int temp = data[upper];
      data[upper] = data[lower];
      data[lower] = temp;
    }
  }
  return lower;//return last position of hte pivot
  }

  public static int quickselect(int[] data, int k){
    return quickselectH(data, k, 0, data.length-1);
  }
  private static int quickselectH(int[] data, int k, int start, int end){
    int pivot = partition(data, start, end);
    if (pivot == k){
      return data[k];
    }
    else if (k > pivot){
      return quickselectH(data, k, pivot+1, end);//if index greater than pivot, only return partition from pivot+ 1 to the end;
    }
    else if (k < pivot){
      return quickselectH(data, k, start, pivot);
    }
    else return data[pivot];
  }

  public static void quickSort(int[] data){
    quickSortH(data, 0, data.length-1);
    }
    private static void quickSortH(int[] data, int start, int end){
      if (start>=end) return;
      int pivot = partition(data, start, end);
      quickSortH(data, start, pivot-1);// sort the array by halves.
      quickSortH(data, pivot+1, end);
    }
  
  public static void main(String[] args) {
    int[] data = {4, 5, 9, 1, 2, 3};
    System.out.println(quickselect(data, 2));
  }
}
