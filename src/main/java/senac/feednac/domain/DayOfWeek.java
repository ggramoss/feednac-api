package senac.feednac.domain;

import java.util.Arrays;

public enum DayOfWeek {
    MONDAY(0, "Segunda-feira"),
    TUESDAY(1, "Terca-feira"),
    WEDNESDAY(2, "Quarta-feira"),
    THURSDAY(3, "Quinta-feira"),
    FRIDAY(4, "Sexta-feira"),
    SATURDAY(5, "Sabado"),
    SUNDAY(6, "Domingo");

    private int id;
    private String name;

    DayOfWeek(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static DayOfWeek getDayOfWeekById(Long id) {
        return Arrays.stream(values()).filter(cc -> cc.getId() == id).findFirst().orElseThrow();
    }
}
