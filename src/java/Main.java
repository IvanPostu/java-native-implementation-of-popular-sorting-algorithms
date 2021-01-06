
public class Main {

  static {
    System.loadLibrary("sayHello");
  }

  public native void sayHello();

  public static void main(String[] args) {
    Main main = new Main();
    main.sayHello();
    main.sayHello();
  }

}