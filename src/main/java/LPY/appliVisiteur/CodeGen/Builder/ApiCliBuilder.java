package LPY.appliVisiteur.CodeGen.Builder;

import LPY.appliVisiteur.CodeGen.Model.RestController;
import LPY.appliVisiteur.CodeGen.Model.RouteModel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import java.util.List;

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
        BlockStmt block = new BlockStmt();
        routeFunction.setBody(block);
        // add a statement do the method body
        NameExpr clazz = new NameExpr("System");
        FieldAccessExpr field = new FieldAccessExpr(clazz, "out");
        MethodCallExpr call = new MethodCallExpr(field, "println");
        call.addArgument(new StringLiteralExpr("Hello World!"));
        if(routeModel.getMethod().equals("POST"))
        {
            routeFunction.addAndGetParameter(routeModel.getRequestBody(), lowerFirstCase(routeModel.getRequestBody()));
        }
        block.addStatement(getHttpRequestDeclaration(routeModel));
        block.addStatement(getHttpResponseDeclaration(routeModel));
        block.addStatement(getReturn(routeModel));
    }

    private String getHttpRequestInitializer(RouteModel routeModel)
    {
        String initializer =
                "HttpRequest.newBuilder()\n" +
                "                .header(\"Content-Type\", \"application/json\")\n" +
                "                .header(\"Authorization\", token)\n" +
                "                .{verb}({body})\n" +
                "                .uri(URI.create(endPointUrl + \"{link}\"))\n" +
                "                .build()";
        initializer = initializer.replace("{link}", routeModel.getLink());
        initializer = initializer.replace("{verb}", routeModel.getMethod());
        if (routeModel.getMethod().equals("POST") || routeModel.getMethod().equals("PATCH"))
        {
            initializer = initializer
                    .replace("{body}",
                            "HttpRequest.BodyPublishers.ofString(" +
                                    lowerFirstCase(routeModel.getRequestBody()) + ")");
        }
        return initializer;
    }

    private ExpressionStmt getHttpRequestDeclaration(RouteModel routeModel)
    {
        ExpressionStmt httpRequestExpression = new ExpressionStmt();
        VariableDeclarationExpr httpRequestDeclarationExpr = new VariableDeclarationExpr();
        VariableDeclarator httpRequestDeclarator = new VariableDeclarator();
        httpRequestDeclarator.setName("request");
        ClassOrInterfaceType httpCliClass = new ClassOrInterfaceType("HttpRequest");
        httpRequestDeclarator.setType(httpCliClass);
        httpRequestDeclarator.setInitializer(getHttpRequestInitializer(routeModel));
        NodeList<VariableDeclarator> variableDeclarators = new NodeList<>();
        variableDeclarators.add(httpRequestDeclarator);
        httpRequestDeclarationExpr.setVariables(variableDeclarators);
        httpRequestExpression.setExpression(httpRequestDeclarationExpr);
        return httpRequestExpression;
    }

    private ExpressionStmt getHttpResponseDeclaration(RouteModel routeModel)
    {
        ExpressionStmt httpRequestExpression = new ExpressionStmt();
        VariableDeclarationExpr httpRequestDeclarationExpr = new VariableDeclarationExpr();
        VariableDeclarator httpRequestDeclarator = new VariableDeclarator();
        httpRequestDeclarator.setName("response");
        ClassOrInterfaceType httpCliClass = new ClassOrInterfaceType("HttpResponse<String>");
        httpRequestDeclarator.setType(httpCliClass);
        httpRequestDeclarator.setInitializer("httpClient.send(request, HttpResponse.BodyHandlers.ofString())");
        NodeList<VariableDeclarator> variableDeclarators = new NodeList<>();
        variableDeclarators.add(httpRequestDeclarator);
        httpRequestDeclarationExpr.setVariables(variableDeclarators);
        httpRequestExpression.setExpression(httpRequestDeclarationExpr);
        return httpRequestExpression;
    }

    private ReturnStmt getReturn(RouteModel routeModel)
    {
        ReturnStmt returnStmt = new ReturnStmt();
        NameExpr returnNameExpr = new NameExpr();
        String returnStr = "objectMapper.readValue(response.body(), {className}.class)";
        returnNameExpr.setName(returnStr.replace("{className}", routeModel.getResponseBody()));
        returnStmt.setExpression(returnNameExpr);
        return returnStmt;
    }

    private String lowerFirstCase(String name)
    {
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }


}