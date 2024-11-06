package pe.medelect.platform.u202220033.work.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import pe.medelect.platform.u202220033.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.medelect.platform.u202220033.work.domain.model.valueobjects.HealthInstitutionId;
import pe.medelect.platform.u202220033.work.domain.model.valueobjects.MedicalEquipmentId;
import pe.medelect.platform.u202220033.work.domain.model.valueobjects.StaffId;

import javax.xml.crypto.Data;
import java.util.Date;

@Getter
@Entity
public class WorkOrder extends AuditableAbstractAggregateRoot {
    private String workType;
    @Embedded
    private MedicalEquipmentId medicalEquipmentId;
    @Embedded
    private StaffId staffId;
    @Embedded
    private HealthInstitutionId healthInstitutionId;
    private String description;
    private Integer priority;
    private Float amount;
    private Date plannedAt;

    public WorkOrder() {
        // Required by JPA
    }

    public WorkOrder(String workType, MedicalEquipmentId medicalEquipmentId, StaffId staffId, HealthInstitutionId healthInstitutionId, String description, Integer priority, Float amount, Date plannedAt) {
        this();
        this.workType = workType;
        this.medicalEquipmentId = medicalEquipmentId;
        this.staffId = staffId;
        this.healthInstitutionId = healthInstitutionId;
        this.description = description;
        this.priority = priority;
        this.amount = amount;
        this.plannedAt = plannedAt;
    }
}
