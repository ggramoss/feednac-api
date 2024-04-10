package senac.feednac.application.response;

public abstract class ApiResponse {
    private int statusCode;

    public ApiResponse(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
