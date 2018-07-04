package ch.zhaw.sml.iwi.pmis.meng.simplebackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Consinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean chosen;

    private String doctorDefinition;

    private String patientDefinition;

    private String teamDefinition;


}
