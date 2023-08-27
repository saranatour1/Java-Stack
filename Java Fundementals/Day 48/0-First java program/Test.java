// My name is Coding Dojo
// I am 100 years old
// My hometown is Burbank, CA

public class Test {
	public static void main(String[] args) {
		String name ="Sara";
		int age =23;
		String homeTown="Tulkarem";
		String formattedString = String.format("My name is: %s, I am %d years old. My hometown is %s", name, age, homeTown);
    System.out.println(formattedString);
	}
}
