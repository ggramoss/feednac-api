package senac.feednac.domain;

import java.util.List;

public class Question {

    private Long id;

    private List<AnswerOption> options;

    private String value;

    public Question(
            Long id,
            List<AnswerOption> options,
            String value
    ) {
        this.id = id;
        this.options = options;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public List<AnswerOption> getOptions() {
        return options;
    }

    public String getValue() {
        return value;
    }
}
