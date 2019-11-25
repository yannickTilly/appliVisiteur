package LPY.appliVisiteur.CodeGen.Model;

public class RouteModel {
    private String method;
    private String requestBody;
    private String responseBody;
    private String name;
    private String link;

    public String getName() {
        return name;
    }

    public RouteModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getLink() {
        return link;
    }

    public RouteModel setLink(String link) {
        this.link = link;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public RouteModel setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public RouteModel setRequestBody(String requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public RouteModel setResponseBody(String responseBody) {
        this.responseBody = responseBody;
        return this;
    }
}
