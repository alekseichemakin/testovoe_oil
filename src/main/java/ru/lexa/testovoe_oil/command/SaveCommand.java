package ru.lexa.testovoe_oil.command;

import ru.lexa.testovoe_oil.dao.WellDAO;
import ru.lexa.testovoe_oil.entity.Well;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lexa.testovoe_oil.service.IOService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

public class SaveCommand implements Command{

	private WellDAO wellDAO;

	public SaveCommand(WellDAO wellDAO) {
		this.wellDAO = wellDAO;
	}


	@Override
	public void execute() {
		System.out.print("Input file name: ");
		String filename = IOService.getScanner().nextLine() + ".xml";
		File file = new File("src/main/resources/saved/" + filename);
		try {
			JAXBContext context = JAXBContext.newInstance(DbInfo.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			marshaller.marshal(new DbInfo(wellDAO.getAll()), file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		System.out.println("File saved to: " + file.getAbsolutePath());
	}

	@XmlRootElement(name = "dbinfo")
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	static class DbInfo {
		List<Well> wellList;
	}
}
