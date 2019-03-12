public class Quick{
public static int quickSelect(int[] data, int k){
  int random = (int)(Math.random() * (end - start) + start);
  int temp = data[random];
  data[random] = data[end];
  data[end] = temp;
  int pivot = temp;
  int up = end;
  int low = start-1;

  for (int i =start; i < up; i++){
    if (data[i] <= pivot){
      low++;
      int temp1 = data[low];
      data[low] = data[i];
      data[i] = temp1;
    }
  }
  int temp2 = data[low+1];
  data[low+1] = 
  return end;
}
