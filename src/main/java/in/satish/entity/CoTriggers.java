package in.satish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CO_TRIGGERS")
@Data
public class CoTriggers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TRIGGER_ID")
	private Integer triggerId;
	
	@Column(name="CASE_NUMBER")
	private Long caseNumber;
	
	@Column(name="CO_PDF")
	private byte[] coPdf;
	
	@Column(name="TRIG_STATUS")
	private String trigStatus;
}
