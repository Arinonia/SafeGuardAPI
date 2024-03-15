package fr.arinonia.safeguardapi.dto;

public class OrderInfoDto {

    private Long id;
    private String type;
    private boolean isFullyPaid;

    public OrderInfoDto(final Long id, final String type, final boolean isFullyPaid) {
        this.id = id;
        this.type = type;
        this.isFullyPaid = isFullyPaid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public boolean isFullyPaid() {
        return this.isFullyPaid;
    }

    public void setFullyPaid(final boolean fullyPaid) {
        this.isFullyPaid = fullyPaid;
    }
}
