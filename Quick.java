public class Quick{
  public static int partition(int[] data, int start, int end){
    if (start<0 || start>= data.length || end < 0 || end >= data.length){
      throw new IndexOutOfBoundsException();
    }

  int random = (int)(Math.random() * (end - start) + start);
  int pivot = data[random];
  System.out.println(pivot);
  while (start <end){
  while (data[start] < pivot){
    start++;
  }
  while (data[end] > pivot){
    end--;
  }
  if (start < end){
    int temp = data[start];
    data[start] = data[end];
    data[end] = temp;
  }
  }
  return end;
  }

  public static int quickselect(int[] data, int k){
    int comp = partition(data, 0, data.length-1);
    if (comp == k){
      return data[comp];
    }
    while (comp < k){
      comp = partition(data, comp+1, data.length-1);
      comp++;
    }
    while (comp > k){
      comp = partition(data, 0, comp-1);
      comp--;
    }
    return data[comp];
  }
  public static void main(String[] args) {
    int[] data = {4, 5, 9, 1, 2, 3};
    System.out.println(quickselect(data, 2));
  }
}
