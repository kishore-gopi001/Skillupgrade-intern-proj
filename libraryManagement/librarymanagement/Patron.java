package librarymanagement;

import java.io.Serializable;

public class Patron implements Serializable {
    private String name;
    private String patronId;

    public Patron(String name, String patronId) {
        this.name = name;
        this.patronId = patronId;
    }

    public String getName() {
        return name;
    }

    public String getPatronId() {
        return patronId;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", patronId='" + patronId + '\'' +
                '}';
    }
}
