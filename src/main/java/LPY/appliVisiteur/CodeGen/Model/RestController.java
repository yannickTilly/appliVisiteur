package LPY.appliVisiteur.CodeGen.Model;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;

import java.util.ArrayList;
import java.util.List;

public class RestController {

    private ClassOrInterfaceDeclaration classOrInterfaceDeclaration;

    public RestController(ClassOrInterfaceDeclaration classOrInterfaceDeclaration) {
        this.classOrInterfaceDeclaration = classOrInterfaceDeclaration;
    }

    public RestController() {

    }

    public ClassOrInterfaceDeclaration getClassOrInterfaceDeclaration() {
        return classOrInterfaceDeclaration;
    }

    public RestController setClassOrInterfaceDeclaration(ClassOrInterfaceDeclaration classOrInterfaceDeclaration) {
        this.classOrInterfaceDeclaration = classOrInterfaceDeclaration;
        return this;
    }

    public List<RequestMappingFunction> getRequestMappingFunctions() {
        List<RequestMappingFunction> requestFunctions = new ArrayList<>();
        List<MethodDeclaration> methodDeclarations = classOrInterfaceDeclaration.findAll(MethodDeclaration.class);
        for (MethodDeclaration methodDeclaration : methodDeclarations) {
            if (RequestMappingFunction.isRequestFunction(methodDeclaration)) {
                requestFunctions.add(new RequestMappingFunction(methodDeclaration));
            }
        }
        return requestFunctions;
    }

    public String getSuffixe()
    {
        return getRequestMappingAnnotation().getLink();
    }

    public RestControllerAnnotation getRestControllerAnnotation()
    {
        List<MarkerAnnotationExpr> markerAnnotationExprs = classOrInterfaceDeclaration.findAll(MarkerAnnotationExpr.class);
        for (MarkerAnnotationExpr markerAnnotationExpr : markerAnnotationExprs)
        {
            if (RestControllerAnnotation.isRestControllerAnnotation(markerAnnotationExpr))
            {
                return new RestControllerAnnotation(markerAnnotationExpr);
            }
        }
        return null;
    }

    public ControllerRequestMappingAnnotation getRequestMappingAnnotation()
    {
        List<SingleMemberAnnotationExpr> singleMemberAnnotationExprs = classOrInterfaceDeclaration.findAll(SingleMemberAnnotationExpr.class);
        for(SingleMemberAnnotationExpr singleMemberAnnotationExpr: singleMemberAnnotationExprs)
        {
            if(ControllerRequestMappingAnnotation.isControllerRequestMappingAnnotation(singleMemberAnnotationExpr))
            {
                return new ControllerRequestMappingAnnotation(singleMemberAnnotationExpr);
            }
        }
        return null;
    }

    public String getName() {
        return classOrInterfaceDeclaration.getName().getIdentifier();
    }
}
