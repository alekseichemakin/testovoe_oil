package dao;

import entity.Equipment;

import java.util.List;

public interface EquipmentDAO {
	//create
	void add(Equipment equipment);

	//read
	List<Equipment> getAll();
	Equipment getById(long id);
	Equipment getByName(String name);

	//update
	void update(Equipment equipment);

	//delete
	void remove(Equipment equipment);
}
