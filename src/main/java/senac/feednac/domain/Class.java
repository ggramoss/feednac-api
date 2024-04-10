package senac.feednac.domain;

public class Class {
    private String name;
    private String startTime;
    private String endTime;
    private String room;
    private String instructor;

    public Class(String name, String startTime, String endTime, String room, String instructor) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getRoom() {
        return room;
    }

    public String getInstructor() {
        return instructor;
    }
}
