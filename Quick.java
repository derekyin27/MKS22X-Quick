public class Quick{
public static int quickSelect(int[] data, int k){
  int random = (int)(Math.random() * (end - start) + start);
  int temp = data[random];
  data[random] = data[end];
  data[end] = temp;
  int pivot = temp;
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
