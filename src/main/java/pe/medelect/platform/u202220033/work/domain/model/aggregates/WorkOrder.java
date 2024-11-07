package pe.medelect.platform.u202220033.work.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import pe.medelect.platform.u202220033.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.medelect.platform.u202220033.work.domain.model.commands.CreateWorkOrderCommand;
import pe.medelect.platform.u202220033.work.domain.model.valueobjects.HealthInstitutionId;
import pe.medelect.platform.u202220033.work.domain.model.valueobjects.MedicalEquipmentId;
import pe.medelect.platform.u202220033.work.domain.model.valueobjects.StaffId;
import pe.medelect.platform.u202220033.work.domain.model.valueobjects.WorkType;

import javax.xml.crypto.Data;
import java.util.Date;

@Getter
@Entity
public class WorkOrder extends AuditableAbstractAggregateRoot<WorkOrder> {
    @NonNull
    private WorkType workType;
    @Embedded
    @NonNull
    private MedicalEquipmentId medicalEquipmentId;
    @Embedded
    @NonNull
    private StaffId staffId;
    @Embedded
    @NonNull
    private HealthInstitutionId healthInstitutionId;
    @Size(max = 200)
    @NonNull
    private String description;
    @Min(1) @Max(3)
    @NonNull
    private Integer priority;
    @Min(1)
    @NonNull
    private Float amount;
    @NonNull
    private Date plannedAt;

    public WorkOrder() {
        // Required by JPA
    }

    public WorkOrder(@NonNull WorkType workType,
                     @NonNull MedicalEquipmentId medicalEquipmentId,
                     @NonNull StaffId staffId,
                     @NonNull HealthInstitutionId healthInstitutionId,
                     @NonNull @Size(max = 200) String description,
                     @NonNull @Min(1) @Max(3) Integer priority,
                     @NonNull @Min(1) Float amount,
                     @NonNull Date plannedAt) {
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

    public WorkOrder(CreateWorkOrderCommand command) {
        this.workType = WorkType.valueOf(command.workType().toUpperCase());
        this.medicalEquipmentId = new MedicalEquipmentId(command.medicalEquipmentId());
        this.staffId = new StaffId(command.staffId());
        this.healthInstitutionId = new HealthInstitutionId(command.healthInstitutionId());
        this.description = command.description();
        this.priority = command.priority();
        this.amount = command.amount();
        this.plannedAt = command.plannedAt();
    }
}
