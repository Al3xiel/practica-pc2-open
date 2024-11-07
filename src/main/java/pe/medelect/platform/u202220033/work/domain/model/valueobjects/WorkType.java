package pe.medelect.platform.u202220033.work.domain.model.valueobjects;

/**
 * WorkType value object enum
 * @summary
 * This enum represents the type of work that can be done on a medical equipment.
 * @since 1.0
 */
public enum WorkType {
    PREVENTIVE_MAINTENANCE(1, "PREVENTIVE_MAINTENANCE"),
    CORRECTIVE_MAINTENANCE(2, "CORRECTIVE_MAINTENANCE"),
    PARAMETER_VERIFICATION(3, "PARAMETER_VERIFICATION"),
    REPOWERING(4, "REPOWERING");

    private final int id;
    private final String description;

    WorkType(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
