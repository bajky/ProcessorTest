/**
 * Created by David on 01/05/2016.
 */
public class Main {

    public static void main(String[] args) {
        ToyPojo toyPojo = new ToyPojo();
        toyPojo.setTitle("car toy");
        toyPojo.setAmount(1);
        ChildPojo childPojo = new ChildPojo();
        childPojo.setChildLastName("Hrasko");
        childPojo.setChildName("Janko");
        childPojo.setKindAge(10);
        childPojo.setToyPojo(toyPojo);
        ParentPojo pojoTestObject = new ParentPojo();
        pojoTestObject.setAge(35);
        pojoTestObject.setSomething(5);
        pojoTestObject.setLastName("Bajko");
        pojoTestObject.setName("Davidko");
        pojoTestObject.setChildPojo(childPojo);
        PojoToJson pojoToJson = new PojoToJson("test.json");
        pojoToJson.createJsonFile(pojoTestObject);
    }
}
