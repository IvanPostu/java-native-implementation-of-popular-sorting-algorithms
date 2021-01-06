public class SortCNativeImpl implements Sort {

  static {
    System.loadLibrary("sort_c");
  }

  private native void selectionSort(int[] arr, int size);

  @Override
  public void sort(int[] arr, int size, SortType sortType) {
    if(SortType.INSERTION.equals(sortType)){
      selectionSort(arr, size);
    }
  }
  
}
