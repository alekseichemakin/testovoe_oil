package ru.lexa.dao;

import ru.lexa.entity.Equipment;

import java.util.List;

public interface EquipmentDAO {
	//create
	void add(Equipment equipment);

	//read
	List<Equipment> getAll();
	Equipment getById(long id);

	//update
	void update(Equipment equipment);

	//delete
	void remove(Equipment equipment);
}
