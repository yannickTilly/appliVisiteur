package LPY.appliVisiteur.CodeGen.Builder;

import LPY.appliVisiteur.CodeGen.Model.ClientError;
import LPY.appliVisiteur.CodeGen.Model.RouteModel;
import LPY.appliVisiteur.CodeGen.Model.ServerError;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParseStart;
import com.github.javaparser.Providers;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiCliBuilder{

    public static void main(String[] args)
    {
        RouteModel routeModel = new RouteModel();
        routeModel.setLink("/report");
        routeModel.setMethod("POST");
        routeModel.setName("postReport");
        routeModel.setResponseBody("Report");
        routeModel.setRequestBody("ReportBody");
        ApiCliBuilder apiCliBuilder = new ApiCliBuilder("testname");
        apiCliBuilder.addRoute(routeModel);
        apiCliBuilder.getApiClassStr();
    }

    private static final int POST = 417;
    private static final int PATCH = 416;
    private static final int GET = 346;
    private static final int DELETE = 39;
    private CompilationUnit compilationUnit;
    private ClassOrInterfaceDeclaration apiClass;

    public ApiCliBuilder(String apiName)
    {
        compilationUnit = new CompilationUnit();
        apiClass = compilationUnit.addClass( apiName + "ApiCli");
    }
    public String getApiClassStr()
    {
        return compilationUnit.toString();
    }


    public void addRoute(RouteModel routeModel)
    {
        MethodDeclaration routeFunction = apiClass.addMethod(routeModel.getName());
        routeFunction.setType(routeModel.getResponseBody());
        routeFunction.addThrownException(ServerError.class);
        routeFunction.addThrownException(ClientError.class);
        BlockStmt block = new BlockStmt();
        routeFunction.setBody(block);
        if(routeModel.getMethod().equals("POST") || routeModel.getMethod().equals("PATCH"))
        {
            routeFunction.addAndGetParameter(routeModel.getRequestBody(), lowerFirstCase(routeModel.getRequestBody()));
        }
        for(String pathVariable : routeModel.getPathVariables())
        {
            routeFunction.addAndGetParameter("long", String.valueOf(pathVariable));
        }
        routeFunction.addAndGetParameter(String.class, "token");
        block.addStatement(getClientString());
        block.addStatement(getRequestString(routeModel));
        addSetRequestToBlock(routeModel, block);
    }
    public String getClientString()
    {
        return "CloseableHttpClient client = HttpClients.createDefault();";
    }
    public String getRequestString(RouteModel routeModel)
    {
        switch (routeModel.getMethod())
        {
            case "GET":

                return ("HttpGet http = new HttpGet(baseEndpoint + \"" + routeModel.getLink()+ "\");");
            case "POST":
                return ("HttpPost http = new HttpPost(baseEndpoint + \"" + routeModel.getLink()+ "\");");
            case "PATCH":
                return ("HttpPatch http = new HttpPatch(baseEndpoint + \"" + routeModel.getLink()+ "\");");
            case "DELETE":
                return ("HttpDelete http = new HttpDelete(baseEndpoint + \"" + routeModel.getLink()+ "\");");
            default:
                return "";
        }
    }
    public void addSetRequestToBlock(RouteModel routeModel, BlockStmt blockStmt)
    {
        JavaParser parser= new JavaParser();
        ParseResult<Expression> expression = parser.parse(ParseStart.EXPRESSION,
                Providers.provider("http.setHeader(\"Accept\", \"application/json\")"));
        expression.ifSuccessful(blockStmt::addStatement);
        expression = parser.parse(ParseStart.EXPRESSION,
                Providers.provider("http.setHeader(\"Authorization\", token)"));
        expression.ifSuccessful(blockStmt::addStatement);
        expression = parser.parse(ParseStart.EXPRESSION,
                Providers.provider("http.setHeader(\"Content-type\", \"application/json\")"));
        expression.ifSuccessful(blockStmt::addStatement);
        switch (routeModel.getMethod())
        {
            case "GET":
                break;
            case "POST":
            case "PATCH":
                String objectMapper = "objectMapper.writeValueAsString({body})".replace("{body}", routeModel.getResponseBody());
                blockStmt.addStatement("StringEntity entity = new StringEntity({body});".replace("{body}", objectMapper));
//                        +
//                        "    httpPost.setEntity(entity)\n"
//                                .replace("{body}", objectMapper));
            default:
        }
    }

//    public void executeRequest(RouteModel routeModel, BlockStmt blockStmt)
//    {
//        ParseResult<Expression> expression = parser.parse(ParseStart.EXPRESSION,
//                Providers.provider("http.setHeader(\"Accept\", \"application/json\")"));
//        expression.ifSuccessful(blockStmt::addStatement);
//        response1 = httpclient.execute(httpGet);
//        String response = EntityUtils.toString(response1.getEntity());
//    }

    private ReturnStmt getReturn(RouteModel routeModel)
    {
        ReturnStmt returnStmt = new ReturnStmt();
        NameExpr returnNameExpr = new NameExpr();
        Pattern pattern = Pattern.compile("<.*>");
        Matcher matcher = pattern.matcher(routeModel.getResponseBody());
        String objectMapperClassParam = routeModel.getResponseBody();
        while(matcher.find()) {
            objectMapperClassParam = matcher.group()
                    .replace("<","")
                    .replace(">","")
                    + "[]";
        }
        String returnStr = "objectMapper.readValue(response.body(), {className}.class)";
        returnNameExpr.setName(returnStr.replace("{className}", objectMapperClassParam));
        returnStmt.setExpression(returnNameExpr);
        return returnStmt;
    }

    private String lowerFirstCase(String name)
    {
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }


    public void addRoutes(List<RouteModel> routeModels) {
        for (RouteModel routeModel: routeModels)
        {
            addRoute(routeModel);
        }
    }
}