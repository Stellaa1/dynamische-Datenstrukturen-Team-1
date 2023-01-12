package de.hebk;

import de.hebk.model.list.List;

public class Question {
    private String question;
    private Byte difficulty;
    private List<String> options; // Answer = options.get(0)

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Byte getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Byte difficulty) {
        this.difficulty = difficulty;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
    public void tostring(){
        System.out.println("Question " + question + "; difficulty" + difficulty);
    }
}