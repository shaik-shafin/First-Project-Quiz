package com.first.quiz.service;

import com.first.quiz.dao.QuestionDao;
import com.first.quiz.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final static String SUCCESS_MESSAGE = "success";

    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }

    public List<Question> getAllQuestionsByCategory(String category){
        return questionDao.findByCategory(category);
    }

    public List<Question> getAllQuestionsByCategoryInNativeQuery(String category){
        return questionDao.findByCategoryInNativeQuery(category);
    }


    public String saveQuestion(Question question) {
        questionDao.save(question);
        return SUCCESS_MESSAGE;
    }

    public String updateQuestion(Question question) {
        questionDao.save(question);
        return SUCCESS_MESSAGE;
    }

    public String deleteQuestion(Integer id) {
        questionDao.deleteById(id);
        return SUCCESS_MESSAGE;
    }
}
