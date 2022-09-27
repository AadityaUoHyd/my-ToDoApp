package pack;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int save(Todos t) {
		Integer i= (Integer) this.hibernateTemplate.save(t);
		return i;
	}
	
	public List<Todos> getAll(){
		List<Todos> todos = this.hibernateTemplate.loadAll(Todos.class);
		return todos;
	}

}
