package senac.feednac.domain;

public class AnswerOption {

    private Long id;

    private String option;

    public AnswerOption(
            Long id,
            String option
    ) {
        this.id = id;
        this.option = option;
    }

    public Long getId() {
        return id;
    }

    public String getOption() {
        return option;
    }
}
