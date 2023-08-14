public class NationalForest {
    public String name;
    public String location;
    public int acres;

    //class-level variables, also called Fields.
    //Fields do not require an assignment before they can be used.
    //Constructors - Method-like code that initializes an individual object.

    //NEW CODE: constructor
    public NationalForest(){
        this("Unknown", "Unknown", -1);
    }

    public NationalForest(String name, String location, int acres) {
        this.name = name;
        this.location = location;
        this.acres = acres;
    }

    public NationalForest(String name, int acres) {
        this(name, "Unknown", acres);
    }


}
