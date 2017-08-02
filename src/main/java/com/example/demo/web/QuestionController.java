package com.example.demo.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.web.qnadata.Data;

@Controller
public class QuestionController {
	//ArrayList<Integer> questions = new ArrayList<>();
	ArrayList<Data> question = new ArrayList<>();
	
	@GetMapping("/qna/form")
	public ModelAndView Question() {
		ModelAndView mav = new ModelAndView("qna/form");
		return mav;
	}
	
	@PostMapping("/question")
	public ModelAndView PostQuestion(Data data) {
		question.add(data);
		return new ModelAndView("redirect:/question");
	}
	
	@GetMapping("/question")
	public ModelAndView Show() {
		ModelAndView mav = new ModelAndView("qna/show");
		mav.addObject("data", question);
		return mav;
	}
}