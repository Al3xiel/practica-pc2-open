package pe.medelect.platform.u202220033.work.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.medelect.platform.u202220033.work.domain.model.aggregates.WorkOrder;


@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
}
