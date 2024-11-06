package pe.medelect.platform.u202220033.work.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record MedicalEquipmentId(Long medicalEquipmentId) {
    public MedicalEquipmentId {
        if (medicalEquipmentId == null) {
            throw new IllegalArgumentException("Medical equipment id cannot be null");
        }
        if(medicalEquipmentId < 0) {
            throw new IllegalArgumentException("Medical equipment id cannot be negative");
        }
    }

    public MedicalEquipmentId() {
        this(0L);
    }
}
