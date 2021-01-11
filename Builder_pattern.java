
// POJO

// Mutable and Immutable

// Builder Pattern (i. Immutable Objects)

// Do we have default or optional parameters in Java? No
/*
class PersonBuilder {
    private int age;
    private String name;
    private String address;
    private long phoneno;
    
    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }
    
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;        
    }
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;        
    }
    public PersonBuilder setPhone(long phoneno) {
        this.phoneno = phoneno;
        return this;
    }
    
    public Person build() {
        return new Person(age, name, address, phoneno);
    }
    
}
*/
class Person {
    private int age;
    private String name;
    private String address;
    private long phoneno;
    
    public static class Builder {
        
        private int age;
        private String name;
        private String address;
        private long phoneno;
        
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        
        public Builder setAddress(String address) {
            this.address = address;
            return this;        
        }
        public Builder setName(String name) {
            this.name = name;
            return this;        
        }
        public Builder setPhone(long phoneno) {
            this.phoneno = phoneno;
            return this;
        }
        
        public Person build() {
            return new Person(age, name, address, phoneno);
        }
    
    }
    
    public String toString() {
        return "[Name="+name+",Age="+age+",Address="+address+",Phone="+phoneno+"]";
    }
    
    private Person(int age, String name, String address, long phoneno) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
    }
    
    // Getter or Accessors
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public long getPhone() {
        return phoneno;
    }

/*    
    public Person(String name) {
        
    }
    
    public Person(String name, int age) {
        
    }
    
    public Person(String name, long phoneno) {
        
    }

    public Person(String name, int age, long phoneno) {
        
    }

    public Person(String name, String address) {
        
    }

    public Person(String name, int age, String address) {
        
    }

    public Person(String name, long phoneno, String address) {
        
    }
*/
    
    /*
    
    // Setters or Mutators
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(long phoneno) {
        this.phoneno = phoneno;
    }
    */

}

public class Builder_pattern
{
	public static void main(String[] args) {
	    Person p = new Person.Builder().setName("Victor").setAge(23).setAddress("London").build();
	    System.out.println(p);
	    
	}
}

