package pe.medelect.platform.u202220033.work.domain.services;

import pe.medelect.platform.u202220033.work.domain.model.aggregates.WorkOrder;
import pe.medelect.platform.u202220033.work.domain.model.commands.CreateWorkOrderCommand;

import java.util.Optional;

public interface WorkOrderCommandService {
    Optional<WorkOrder> handle(CreateWorkOrderCommand command);
}
