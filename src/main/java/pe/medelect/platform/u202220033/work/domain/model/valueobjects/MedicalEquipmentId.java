package pe.medelect.platform.u202220033.work.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record MedicalEquipmentId(String medicalEquipmentId) {
    public MedicalEquipmentId {
        if (medicalEquipmentId == null) {
            throw new IllegalArgumentException("Medical equipment id cannot be null");
        }
        if(medicalEquipmentId.length() > 100){
            throw new IllegalArgumentException("Medical equipment id cannot be longer than 100 characters");
        }
    }

    public MedicalEquipmentId() {
        this(null);
    }
}
