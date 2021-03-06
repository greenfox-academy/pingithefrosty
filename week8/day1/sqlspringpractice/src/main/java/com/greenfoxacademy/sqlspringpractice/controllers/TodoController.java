package com.greenfoxacademy.sqlspringpractice.controllers;

import com.greenfoxacademy.sqlspringpractice.collections.Types;
import com.greenfoxacademy.sqlspringpractice.factories.TodoFactory;
import com.greenfoxacademy.sqlspringpractice.models.Todo;
import com.greenfoxacademy.sqlspringpractice.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TodoController {

  @Autowired
  TodoService todoService;
  @Autowired
  TodoFactory todoFactory;
  @Autowired
  Types types;

  @GetMapping("/list")
  public String showList(Model model) {
    List<Todo> todos = todoService.getAllTodos();
    model.addAttribute("todos", todos);
    model.addAttribute("todoTypes", types.getTodoTypes());
    return "list";
  }

  @PostMapping("/list/add")
  public ModelAndView addTodo(@ModelAttribute Todo todo) {
    todoService.addTodo(todo);
    return new ModelAndView("redirect:/list");
  }

  @GetMapping("/list/add")
  public String showAddTodo(Model model) {
    List<Todo> todos = todoService.getAllTodos();
    model.addAttribute("todos", todos);
    model.addAttribute("todoTypes", types.getTodoTypes());
    model.addAttribute("newTodo",todoFactory.getEmptyTodo());
    return "add";
  }

  @PostMapping("/list/delete/{todoId}")
  public String deleteTodo (@PathVariable int todoId) {
    todoService.deleteTodo(todoId);
    return "redirect:/list";
  }

  @GetMapping("/list/edit/{todoId}")
  public String showEdit(@PathVariable int todoId, Model model) {
    Todo todo = todoService.getTodoById(todoId);
    model.addAttribute("todo", todo);
    model.addAttribute("todoTypes", types.getTodoTypes());
    return "edit";
  }

  @PostMapping("/list/edit/{todoId}")
  public String editTodo(@PathVariable int todoId, @ModelAttribute Todo todo) {
    todo.setId(todoId);
    todoService.modifyTodo(todo);
    return "redirect:/list";
  }
}