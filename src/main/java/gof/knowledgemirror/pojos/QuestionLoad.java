package gof.knowledgemirror.pojos;

import java.io.Serializable;

public class QuestionLoad implements Serializable{

    private Integer question_id;
    private String question_quest;//存放问题
    private Object question_answer;//答案
    private Integer question_multiple;//用来标识该道题是不是多选这里要改js


    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_quest() {
        return question_quest;
    }

    public void setQuestion_quest(String question_quest) {
        this.question_quest = question_quest;
    }

    public Object getQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(Object question_answer) {
        this.question_answer = question_answer;
    }

    public Integer getQuestion_multiple() {
        return question_multiple;
    }

    public void setQuestion_multiple(Integer question_multiple) {
        this.question_multiple = question_multiple;
    }



    @Override
    public String toString() {
        return
                "{" +
                        "question_id:"+this.getQuestion_id()+"," +
                        "question_quest:"+this.getQuestion_quest()+"," +
                        "question_answer:"+this.getQuestion_answer()+"," +
                        "question_multiple:"+this.getQuestion_multiple()+""+
                        "}";
    }
}
