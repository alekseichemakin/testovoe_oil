package ru.lexa.service;

import ru.lexa.dao.WellDAO;
import ru.lexa.entity.Well;
import ru.lexa.util.SessionUtil;

import javax.persistence.NoResultException;
import java.util.List;

public class WellService extends SessionUtil implements WellDAO {

	@Override
	public void add(Well well) {
		openTransactionSession();
		getSession().save(well);
		closeTransactionSession();
	}

	@Override
	public List<Well> getAll() {
		openTransactionSession();

		List<Well> wellList = getSession()
				.createNativeQuery("SELECT * FROM well")
				.addEntity(Well.class)
				.list();

		closeTransactionSession();

		return wellList;
	}

	@Override
	public Well getById(long id) {
		openTransactionSession();

		Well well = (Well) getSession()
				.createNativeQuery("SELECT * FROM well WHERE id = :id")
				.addEntity(Well.class)
				.setParameter("id", id)
				.getSingleResult();

		closeTransactionSession();

		return well;
	}

	@Override
	public Well getByName(String name) {
		openTransactionSession();

		Well well;
		try {
			well = (Well) getSession()
					.createNativeQuery("SELECT * FROM well WHERE name = :name")
					.addEntity(Well.class)
					.setParameter("name", name)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			closeTransactionSession();
		}

		return well;
	}

	@Override
	public void update(Well well) {
		openTransactionSession();
		getSession().update(well);
		closeTransactionSession();
	}

	@Override
	public void remove(Well well) {
		openTransactionSession();
		getSession().remove(well);
		closeTransactionSession();
	}
}
