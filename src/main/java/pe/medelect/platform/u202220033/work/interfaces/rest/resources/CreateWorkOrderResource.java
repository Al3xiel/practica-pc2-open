package pe.medelect.platform.u202220033.work.interfaces.rest.resources;

import java.util.Date;

public record CreateWorkOrderResource(
        String workType,
        Long staffId,
        Long healthInstitutionId,
        String description,
        Integer priority,
        Float amount,
        Date plannedAt
) {
}
