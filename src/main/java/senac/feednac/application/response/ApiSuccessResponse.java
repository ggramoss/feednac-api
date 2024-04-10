package senac.feednac.application.response;

public class ApiSuccessResponse extends ApiResponse{

    private Object body;

    public ApiSuccessResponse(int statusCode, Object body) {
        super(statusCode);
        this.body = body;
    }

    public Object getBody() {
        return body;
    }
}
