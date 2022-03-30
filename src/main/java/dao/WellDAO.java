package dao;

import entity.Equipment;
import entity.Well;

import java.util.List;

public interface WellDAO {
	//create
	void add(Well well);

	//read
	List<Well> getAll();
	Well getById(long id);
	Well getByName(String name);
	//update
	void update(Well well);

	//delete
	void remove(Well well);
}
