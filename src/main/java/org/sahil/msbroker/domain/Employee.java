package org.sahil.msbroker.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import lombok.Data;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id",
        scope = Employee.class)
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = -9000625899788348926L;

    private String empName;
    private String empId;

}
