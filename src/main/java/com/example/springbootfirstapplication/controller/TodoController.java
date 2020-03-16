package com.example.springbootfirstapplication.controller;

import com.example.springbootfirstapplication.model.Todo;
import com.example.springbootfirstapplication.service.TodoService;
import org.eclipse.jdt.internal.compiler.classfmt.ExternalAnnotationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list-todos")
    public String showTodos(ModelMap map)
    {
            String name = (String)map.get("name");
            map.put("todos",todoService.retrieveTodos(name));
            return "list-todos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add-todo")
    public String ShowAddTodoPage(ModelMap modelMap)
    {
        modelMap.addAttribute("todo", new Todo(0, (String)modelMap.get("name"),"",new Date(),false));
        return "todo";
    }

    /*@RequestMapping(method = RequestMethod.POST, value= "/add-todo")
    public String AddTodo(@RequestParam String desc, ModelMap modelMap)
    {
        todoService.addTodo((String)modelMap.get("name"),desc,new Date(),false);
        return "redirect:/list-todos";
    }*/

    @RequestMapping(method = RequestMethod.POST, value="/add-todo")
    public String AddTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "todo";
        }
        todoService.addTodo((String)modelMap.get("name"), todo.getDesc(), todo.getDesiredDate(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(method = RequestMethod.GET, value ="/delete-todos")
    public String deleteTodos(@RequestParam int id)
    {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(method = RequestMethod.GET, value="/update-todos")
    public String showUpdateTodo(@RequestParam int id, ModelMap modelMap)
    {
        modelMap.put("todo", todoService.retrieveTodos(id));
        return "todo";
    }

    @RequestMapping(method = RequestMethod.POST, value="/update-todos")
    public String UpdateTodo(@RequestParam int id, @Valid Todo todo, BindingResult bindingResult, ModelMap modelMap)
    {
        todo.setName((String)modelMap.get("name"));
        if(bindingResult.hasErrors())
        {
            return "todo";
        }
        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }
}
