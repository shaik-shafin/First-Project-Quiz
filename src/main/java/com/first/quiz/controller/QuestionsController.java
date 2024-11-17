package com.first.quiz.controller;

import com.first.quiz.domain.Question;
import com.first.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionsController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("all-questions")
    public List<Question> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getAllQuestionsByCategory(@PathVariable String category){

        //return questionService.getAllQuestionsByCategory(category);
        return questionService.getAllQuestionsByCategoryInNativeQuery(category);
    }

    @PostMapping("add")
    public String saveQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }

    @PutMapping("update")
    public String updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }
}
