package pe.medelect.platform.u202220033.work.interfaces.rest.transform;

import pe.medelect.platform.u202220033.work.domain.model.commands.CreateWorkOrderCommand;
import pe.medelect.platform.u202220033.work.interfaces.rest.resources.CreateWorkOrderResource;

public class CreateWorkOrderCommandFromResourceAssembler {
    public static CreateWorkOrderCommand toCommandFromResource(CreateWorkOrderResource resource, String medicalEquipmentId) {
        return new CreateWorkOrderCommand(
                resource.workType(),
                medicalEquipmentId,
                resource.staffId(),
                resource.healthInstitutionId(),
                resource.description(),
                resource.priority(),
                resource.amount(),
                resource.plannedAt()
        );
    }
}
