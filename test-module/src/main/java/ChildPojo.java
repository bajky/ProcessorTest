/**
 * Created by David on 01/05/2016.
 */
public class ChildPojo {

    private String childName;
    private String childLastName;
    private int kindAge;
    private ToyPojo toyPojo;

    public ToyPojo getToyPojo() {
        return toyPojo;
    }

    public void setToyPojo(ToyPojo toyPojo) {
        this.toyPojo = toyPojo;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildLastName() {
        return childLastName;
    }

    public void setChildLastName(String childLastName) {
        this.childLastName = childLastName;
    }

    public int getKindAge() {
        return kindAge;
    }

    public void setKindAge(int kindAge) {
        this.kindAge = kindAge;
    }
}

