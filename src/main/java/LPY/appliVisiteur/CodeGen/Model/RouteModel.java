package LPY.appliVisiteur.CodeGen.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public List<String> getIdNames()
    {
        Pattern pattern;
        pattern = Pattern.compile("\\{.*\\}");
        Matcher matcher = pattern.matcher(link);
        List<String> idNames = new ArrayList<>();
        while (matcher.find())
        {
            idNames.add(matcher.group().replace("{","").replace("}",""));
        }
        return idNames;
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

    public List<String> getPathVariables()
    {
        List<String> pathVariables = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{.*}");
        Matcher matcher = pattern.matcher(getLink());
        while(matcher.find()) {
            pathVariables.add(matcher.group()
                    .replace("{","")
                    .replace("}", ""));
        }
        return pathVariables;
    }
}
