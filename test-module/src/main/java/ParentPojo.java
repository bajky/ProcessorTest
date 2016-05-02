/**
 * Created by David on 01/05/2016.
 */
public class ParentPojo {
    private String name;
    private String lastName;
    private int age;
    private ChildPojo childPojo;
    private int something;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ChildPojo getChildPojo() {
        return childPojo;
    }

    public void setChildPojo(ChildPojo childPojo) {
        this.childPojo = childPojo;
    }

    public int getSomething() {
        return something;
    }

    public void setSomething(int something) {
        this.something = something;
    }
}
