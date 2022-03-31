package ru.lexa.testovoe_oil.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "well")
@XmlRootElement(name = "well")
@XmlType(propOrder = {"name", "id", "equipment"})
public class Well {


	@Column(name = "name", length = 32)
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "well_id")
	private List<Equipment> equipment;

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	@XmlAttribute(name = "id")
	public Long getId() {
		return id;
	}

	public List<Equipment> getEquipment() {
		return equipment;
	}
}
