package com.cognizant.academy.bo;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.academy.dao.ObjectiveDao;
import com.cognizant.academy.entity.Objective;
import com.cognizant.academy.model.Objective_model;

public class ObjectiveBo {

	public void addObjective(Objective_model obj, int stack_id) {
		// TODO Auto-generated method stub
         Objective obje = new Objective();
         obje.setDescription(obj.getDescription());
         obje.setLevel(obj.getLevel());
         obje.setName(obj.getName());
         ObjectiveDao db = new ObjectiveDao();
         db.addObjective(obje,stack_id);
	}

	public List<Objective_model> showObjective(int stack_id) {
		// TODO Auto-generated method stub
		 List<Objective_model> obml = new ArrayList<Objective_model>();
		 
		 List<Objective> obel = new ArrayList<Objective>();
		 
		 ObjectiveDao db = new ObjectiveDao();
		 obel = db.showObjective(stack_id); 
		 
		 for(Objective ob:obel)
		 {
			 Objective_model obm = new Objective_model();
			 obm.setDescription(ob.getDescription());
			 obm.setName(ob.getName());
			 obm.setId(ob.getId());
			 obm.setLevel(ob.getLevel());
			 obml.add(obm);
		 }
		 
		return obml;
	}

	public void removeObjective(Objective_model objm) {
		// TODO Auto-generated method stub
		Objective obe = new Objective();
		obe.setId(objm.getId());
		
		ObjectiveDao db = new ObjectiveDao();
		db.removeObjective(obe);
	}

	public void updateObjective(Objective_model obm) {
		// TODO Auto-generated method stub
		Objective obe = new Objective();
		
		obe.setId(obm.getId());
		obe.setDescription(obm.getDescription());
		obe.setName(obm.getName());
		obe.setLevel(obm.getLevel());
		
		ObjectiveDao db = new ObjectiveDao();
		db.updateObjective(obe);
		
	}

	
}
