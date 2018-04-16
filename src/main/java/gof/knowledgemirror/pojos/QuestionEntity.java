package gof.knowledgemirror.pojos;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class QuestionEntity implements Serializable {
    private Integer id;
    private Integer second_id;
    private String question_quest;//存放问题
    private String question_answer;//答案  格式如下
    //{
    // "A":"一个框架实际上是由一个HTML文档构成",
    // "B":"在每个框架中，都有一个蓝色的区块，这个区块是主框架的位置",
    // "C":"当在一个页面插入框架时，原来的页面就自动成了主框架的内容",
    // "D":"一般主框架用来放置网页内容，而其他小框架用来进行导航"
    // }
    private String question_write_anser;//用户的实际答案
    private String question_right_answer;//正确答案
    private Integer question_multiple;//用来标识该道题是不是多选这里要改js

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSecond_id() {
        return second_id;
    }

    public void setSecond_id(int second_id) {
        this.second_id = second_id;
    }

    public String getQuestion_quest() {
        return question_quest;
    }

    public void setQuestion_quest(String question_quest) {
        this.question_quest = question_quest;
    }

    public String getQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(String question_answer) {
        this.question_answer = question_answer;
    }

    public String getQuestion_write_anser() {
        return question_write_anser;
    }

    public void setQuestion_write_anser(String question_write_anser) {
        this.question_write_anser = question_write_anser;
    }

    public String getQuestion_right_answer() {
        return question_right_answer;
    }

    public void setQuestion_right_answer(String question_right_answer) {
        this.question_right_answer = question_right_answer;
    }

    public int getQuestion_multiple() {
        return question_multiple;
    }

    public void setQuestion_multiple(int question_multiple) {
        this.question_multiple = question_multiple;
    }


}
