package senac.feednac.domain;

import java.util.Arrays;

public enum CourseCategory {
    TECNOLOGY(0, "Tecnologia"),
    ADMINISTRATION(1, "Administracao"),
    FASHION(2, "Moda");

    private int id;
    private String name;

    CourseCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //TODO: lancar uma custom exception e tratar ela
    public static CourseCategory getCourseCategoryById(int id) {
        return Arrays.stream(values()).filter(cc -> cc.getId() == id).findFirst().orElseThrow();
    }
}
