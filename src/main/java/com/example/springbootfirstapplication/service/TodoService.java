package com.example.springbootfirstapplication.service;

import com.example.springbootfirstapplication.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

    @Service
    public class TodoService {
        private static List<Todo> todos = new ArrayList<Todo>();
        private static int todoCount = 3;

        static {
            todos.add(new Todo(1, "pulkit", "Learn Spring MVC", new Date(),
                    false));
            todos.add(new Todo(2, "pulkit", "Learn Struts", new Date(), false));
            todos.add(new Todo(3, "pulkit", "Learn Hibernate", new Date(),
                    false));
        }

        public List<Todo> retrieveTodos(String user) {
            List<Todo> filteredTodos = new ArrayList<Todo>();
            for (Todo todo : todos) {
                if (todo.getName().equals(user)) {
                    filteredTodos.add(todo);
                }
            }
            return filteredTodos;
        }

        public Todo retrieveTodos(int id) {
            List<Todo> filteredTodos = new ArrayList<Todo>();
            for (Todo todo : todos) {
                if (todo.getId() == (id)) {
                    return todo;
                }
            }
            return null;
        }

        public void addTodo(String name, String desc, Date targetDate,
                            boolean isDone) {
            todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
        }

        public void deleteTodo(int id) {
            Iterator<Todo> iterator = todos.iterator();
            while (iterator.hasNext()) {
                Todo todo = iterator.next();
                if (todo.getId() == id) {
                    iterator.remove();
                }
            }
        }

        public void updateTodo(Todo todo)
        {
            todos.remove(todo);
            todos.add(todo);
        }
    }
