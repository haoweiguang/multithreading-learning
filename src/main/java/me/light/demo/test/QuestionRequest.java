package me.light.demo.test;

import java.util.List;

/**
 * @author light.hao
 * @date 2020/11/29 3:32 下午
 */
public class QuestionRequest {

    /**
     * 题目id列表
     */
    private List<String> questionIdList;

    public QuestionRequest(List<String> questionIdList) {
        this.questionIdList = questionIdList;
    }

    public QuestionRequest() {
    }

    public List<String> getQuestionIdList() {
        return questionIdList;
    }

    public void setQuestionIdList(List<String> questionIdList) {
        this.questionIdList = questionIdList;
    }

    @Override
    public String toString() {
        return "QuestionRequest{" +
                "questionIdList=" + questionIdList +
                '}';
    }
}
