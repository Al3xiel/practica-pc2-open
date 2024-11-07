package pe.medelect.platform.u202220033.work.interfaces.rest.transform;

import pe.medelect.platform.u202220033.work.domain.model.aggregates.WorkOrder;
import pe.medelect.platform.u202220033.work.interfaces.rest.resources.WorkOrderResource;

public class WorkOrderResourceFromEntityAssembler {
    public static WorkOrderResource toResourceFromEntity(WorkOrder entity) {
        return new WorkOrderResource(entity.getId(),
                                     entity.getWorkType().name(),
                                     entity.getMedicalEquipmentId().medicalEquipmentId(),
                                     entity.getStaffId().staffId(),
                                     entity.getHealthInstitutionId().healthInstitutionId(),
                                     entity.getDescription(),
                                     entity.getPriority(),
                                     entity.getAmount(),
                                     entity.getPlannedAt());
    }
}
