package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@Data
@NoArgsConstructor
@Entity
@Table(name = "equipment")
@XmlType(propOrder = {"name", "id"})
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name", length = 32)
	private String name;

	@XmlAttribute(name = "id")
	public Long getId() {
		return id;
	}

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}
}
