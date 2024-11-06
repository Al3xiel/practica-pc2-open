package pe.medelect.platform.u202220033.work.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record HealthInstitutionId(Long healthInstitutionId) {
    public HealthInstitutionId {
        if (healthInstitutionId == null) {
            throw new IllegalArgumentException("Health institution id cannot be null");
        }
        if(healthInstitutionId < 0) {
            throw new IllegalArgumentException("Health institution id cannot be negative");
        }
    }
    public HealthInstitutionId() {
        this(0L);
    }
}
