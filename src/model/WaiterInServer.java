package model;

import static java.lang.Integer.parseInt;

public class WaiterInServer extends Person {
    public int age;
    public int  workexperiencelength;
    public WaiterInServer(String id, String name, int age, int workexperiencelength ) {
        super(id, name);
        this.age = age;
        this.workexperiencelength = workexperiencelength;
    }

    public WaiterInServer(String name) {
        super(String.valueOf(0), name);
    }



    public String getNameWaiter() {
        return name;
    }

    public void setNameWaiter(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Model.WaiterInServer{" +
                "nameWaiter='" + name + '\'' +
                '}';
    }
}