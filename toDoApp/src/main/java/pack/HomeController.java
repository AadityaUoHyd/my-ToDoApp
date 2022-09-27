package pack;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	TodoDao todoDao;
	
	@RequestMapping("/home")
	public String home(Model m) {
		String str="home";
		m.addAttribute("page",str);
		
		List<Todos> list = this.todoDao.getAll();
		m.addAttribute("todos",list);
		return "home";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model m) {		
		Todos t = new Todos();
		m.addAttribute("page","add");
		m.addAttribute("todos",t);
		return "home";
	}
	
	@RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
	public String savaTodo(@ModelAttribute("todo") Todos t, Model m) {
		t.setTodoDate(new Date());
		System.out.println(t);
		
		this.todoDao.save(t);
		m.addAttribute("msg","successfully added");
		
		return "home";
	}

}

/*
 To Run this program : Right click on toDOApp -> Run As -> Run on Server.
 
 Then go to browser and hit URL to add ToDos : http://localhost:9494/toDoApp/add
 Now, Hit this URL to view your listed ToDos : http://localhost:9494/toDoApp/home  
 */