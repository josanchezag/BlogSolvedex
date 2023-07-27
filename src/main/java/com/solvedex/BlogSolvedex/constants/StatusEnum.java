package com.solvedex.BlogSolvedex.constants;

public enum StatusEnum {
    ACTIVE(1, "Active"),
    INACTIVE(2, "Inactive"),
    PENDING(3, "Pending"),
    APPROVED(4, "Approved"),
    REJECTED(5, "Rejected");

    private final Integer id;
    private final String dsStatus;

    StatusEnum(int id, String dsStatus) {
        this.id = id;
        this.dsStatus = dsStatus;
    }

    public int getId() {
        return id;
    }

    public String getDsStatus() {
        return dsStatus;
    }

    public static StatusEnum getById(int id) {
        for (StatusEnum status : values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid CommentStatus id: " + id);
    }
}
