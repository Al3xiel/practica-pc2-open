package pe.medelect.platform.u202220033.work.application;

import org.springframework.stereotype.Service;
import pe.medelect.platform.u202220033.work.domain.model.aggregates.WorkOrder;
import pe.medelect.platform.u202220033.work.domain.model.commands.CreateWorkOrderCommand;
import pe.medelect.platform.u202220033.work.domain.services.WorkOrderCommandService;
import pe.medelect.platform.u202220033.work.infrastructure.persistence.jpa.repositories.WorkOrderRepository;

import java.util.Optional;

@Service
public class WorkOrderCommandServiceImpl implements WorkOrderCommandService {
    private final WorkOrderRepository workOrderRepository;

    public WorkOrderCommandServiceImpl(WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
    }

    @Override
    public Optional<WorkOrder> handle(CreateWorkOrderCommand command) {
        var workOrder = new WorkOrder(command);
        var createdWorkOrder = workOrderRepository.save(workOrder);
        return Optional.of(createdWorkOrder);
    }
}
