public class TestGorilla {
  public static void main(String[] args) {
    Gorilla gorilla= new Gorilla();

    gorilla.throwSomething(); //95
    gorilla.throwSomething();//90
    gorilla.throwSomething();//85

    gorilla.eatBananas(); //95
    gorilla.eatBananas();//105


    gorilla.climb(); //95

    gorilla.displayEnergy(); //95
  }
}
