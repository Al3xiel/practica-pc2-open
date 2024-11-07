package pe.medelect.platform.u202220033.work.domain.model.commands;

import java.util.Date;

public record CreateWorkOrderCommand(String workType,
                                     String medicalEquipmentId,
                                     Long staffId,
                                     Long healthInstitutionId,
                                     String description,
                                     Integer priority,
                                     Float amount,
                                     Date plannedAt) {
}
