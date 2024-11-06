package pe.medelect.platform.u202220033.work.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StaffId(Long staffId) {
    public StaffId {
        if (staffId == null) {
            throw new IllegalArgumentException("Staff id cannot be null");
        }
        if(staffId < 0) {
            throw new IllegalArgumentException("Staff id cannot be negative");
        }
    }

    public StaffId() {
        this(0L);
    }
}
