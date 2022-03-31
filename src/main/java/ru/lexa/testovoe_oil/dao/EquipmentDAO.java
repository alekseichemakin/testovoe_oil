package ru.lexa.testovoe_oil.dao;

import ru.lexa.testovoe_oil.entity.Equipment;

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
