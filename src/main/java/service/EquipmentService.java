package service;

import dao.EquipmentDAO;
import entity.Equipment;
import util.SessionUtil;

import java.util.List;

public class EquipmentService  extends SessionUtil implements EquipmentDAO {
	@Override
	public void add(Equipment equipment) {
		openTransactionSession();
		getSession().save(equipment);
		closeTransactionSession();
	}

	@Override
	public void update(Equipment equipment) {
		openTransactionSession();
		getSession().update(equipment);
		closeTransactionSession();
	}

	@Override
	public void remove(Equipment equipment) {
		openTransactionSession();
		getSession().remove(equipment);
		closeTransactionSession();
	}

	@Override
	public List<Equipment> getAll() {
		openTransactionSession();

		List<Equipment> equipmentList = getSession()
				.createNativeQuery("SELECT * FROM equipment")
				.addEntity(Equipment.class)
				.list();

		closeTransactionSession();

		return equipmentList;
	}

	@Override
	public Equipment getById(long id) {
		openTransactionSession();

		Equipment equipment = (Equipment) getSession()
				.createNativeQuery("SELECT * FROM equipment WHERE id = :id")
				.addEntity(Equipment.class)
				.setParameter("id", id)
				.getSingleResult();

		closeTransactionSession();

		return equipment;
	}

	@Override
	public Equipment getByName(String name) {
		openTransactionSession();

		Equipment equipment = (Equipment) getSession()
				.createNativeQuery("SELECT * FROM equipment WHERE name = :name")
				.addEntity(Equipment.class)
				.setParameter("name", name)
				.getSingleResult();

		closeTransactionSession();

		return equipment;
	}
}
