package pe.medelect.platform.u202220033.work.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.medelect.platform.u202220033.work.domain.model.commands.CreateWorkOrderCommand;
import pe.medelect.platform.u202220033.work.domain.services.WorkOrderCommandService;
import pe.medelect.platform.u202220033.work.interfaces.rest.resources.CreateWorkOrderResource;
import pe.medelect.platform.u202220033.work.interfaces.rest.resources.WorkOrderResource;
import pe.medelect.platform.u202220033.work.interfaces.rest.transform.CreateWorkOrderCommandFromResourceAssembler;
import pe.medelect.platform.u202220033.work.interfaces.rest.transform.WorkOrderResourceFromEntityAssembler;

@RestController
@RequestMapping(value = "api/v1/medical-equipments/{medicalEquipmentId}/work-orders")
@Tag(name = "Work Order" , description = "Work Order Endpoints")
public class WorkOrderController {
    private final WorkOrderCommandService workOrderCommandService;

    public WorkOrderController(WorkOrderCommandService workOrderCommandService) {
        this.workOrderCommandService = workOrderCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a Work Order" , description = "Create a Work Order")
    public ResponseEntity<WorkOrderResource> createWorkOrder(@PathVariable String medicalEquipmentId, @RequestBody CreateWorkOrderResource resource) {
        var createWorkOrderCommand = CreateWorkOrderCommandFromResourceAssembler.toCommandFromResource(resource, medicalEquipmentId);
        var workOrder = workOrderCommandService.handle(createWorkOrderCommand);

        if(workOrder.isEmpty()) return ResponseEntity.badRequest().build();

        var workOrderResource = WorkOrderResourceFromEntityAssembler.toResourceFromEntity(workOrder.get());

        return new ResponseEntity<>(workOrderResource, HttpStatus.valueOf(201));
    }
}
