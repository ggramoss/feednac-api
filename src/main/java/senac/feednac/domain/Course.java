package senac.feednac.domain;

public class Course {
    private long id;
    private String name;
    private CourseCategory category;

    public Course(long id, String name, int category) {
        this.id = id;
        this.name = name;
        this.category = CourseCategory.getCourseCategoryById(category);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CourseCategory getCategory() {
        return category;
    }
}
