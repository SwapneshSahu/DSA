package JavaFeatures;

public class B implements A {


	@Override
	public void m1(int a, int b) {
		System.out.println("From Normal Implementation : " + (a + b));
	}

}
