package senac.feednac.domain;

import java.util.List;

public class Schedule {
    private DayOfWeek dayOfWeek;
    private List<Class> classes;

    public Schedule(DayOfWeek dayOfWeek, List<Class> classes) {
        this.dayOfWeek = dayOfWeek;
        this.classes = classes;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public List<Class> getClasses() {
        return classes;
    }
}
