package fr.arinonia.safeguardapi.service.response;

public abstract class AbstractResponse {
    private boolean success;
    private String errorMessage;

    public AbstractResponse() {}

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
