package LPY.appliVisiteur.CodeGen.Model;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;

import java.util.List;

public class RequestMappingFunction{

    private MethodDeclaration methodDeclaration;

    public RequestMappingFunction(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
    }

    public RequestMappingFunction() {
    }

    public static boolean isRequestFunction(MethodDeclaration methodDeclaration) {
        List<NormalAnnotationExpr> markerAnnotationExprs = methodDeclaration.findAll(NormalAnnotationExpr.class);
            for (NormalAnnotationExpr markerAnnotationExpr: markerAnnotationExprs)
            {
                if(markerAnnotationExpr.getName().getIdentifier().equals("RequestMapping"))
                {
                    return true;
                }
            }
            return false;
    }

    public MethodDeclaration getMethodDeclaration() {
        return methodDeclaration;
    }

    public RequestMappingFunction setMethodDeclaration(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
        return this;
    }

    private RequestMappingAnnotation getRequestMappingAnnotation()
    {
        List<NormalAnnotationExpr> annotations = methodDeclaration.findAll(NormalAnnotationExpr.class);
            for (NormalAnnotationExpr markerAnnotationExpr: annotations)
            {
                if(markerAnnotationExpr.getName().getIdentifier().equals("RequestMapping"))
                {
                    return new RequestMappingAnnotation(markerAnnotationExpr);
                }
            }
            return null;
    }

    public RequestBody getRequestBody()
    {
        methodDeclaration.getChildNodes();
        List<Parameter> parameters = methodDeclaration.findAll(Parameter.class);
        for (Parameter parameter: parameters)
        {
            if (RequestBody.is(parameter))
            {
                return new RequestBody(parameter);
            }
        }
        return null;
    }

    public ResponseBody getResponseBody()
    {
        return new ResponseBody(methodDeclaration.getType().asClassOrInterfaceType().getName().getIdentifier());
    }

    public String getLink()
    {
        return getRequestMappingAnnotation().getLink();
    }

    public String getMethod()
    {
        return getRequestMappingAnnotation().getMethod();
    }

    public String getName()
    {
        return methodDeclaration.getName().getIdentifier();
    }

    public String upperCaseFirstLetter(String str)
    {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
