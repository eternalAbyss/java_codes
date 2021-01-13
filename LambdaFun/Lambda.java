package LambdaFun;
// Interfaces

interface SampleNonFunctionalInterface {
    void abd();
    String pqr();
    void xyz(String a);
}

// Functional Interface
interface iA {
    void message(); // by default public and abstract (can never be static)
}

interface iB {
    String getMessage();
}

interface iC {
    void message(String msg);
}

interface iD {
	String getCustomMessage(String msg);
}

// One way

class A implements iA {
    public void message() {
        System.out.println("Stay home, stay safe.");
    }
}

public class Lambda
{
	public static void main(String[] args) {
	    A ob = new A();
	    ob.message();
	    // Second Way (anonymous class)
	    iA ob1 = new iA() {
	        public void message() {
	            System.out.println("Maintain Social Distancing");
	        }
	    };
	    ob1.message();
	    // Third way (using lambda)
	    iA ob2 = () -> System.out.println("Eat Healthy");
	    ob2.message();
	    
	    iB ob3 = () -> "Wear Mask Always";
	    String s = ob3.getMessage();
	    System.out.println(s);
	    
	    iB ob4 = () -> {String s1 = "Wash your hands regularly."; return s1;};
	    String s1 = ob4.getMessage();
	    System.out.println(s1);
	    
	    iC ob5 = (n) -> System.out.println(n);
		ob5.message("Use hand sanitizer.");
		
		iD ob6 = (msg) -> msg;
		String s2 = ob6.getCustomMessage("Exercise enough to maintain immunity"); 
		System.out.println(s2);
	}
}
