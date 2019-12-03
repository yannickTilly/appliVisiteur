package LPY.appliVisiteur.CodeGen.Model;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AnnotationExpr;

import java.util.List;

public class RequestBody {
    private Parameter parameter;
    public RequestBody(Parameter parameter) {
        this.parameter = parameter;
    }

    public RequestBody() {
    }

    public static boolean is(Parameter parameter) {
        List<AnnotationExpr> annotationExprs = parameter.getAnnotations();
        for (AnnotationExpr annotationExpr: annotationExprs)
        {
            if (annotationExpr.getName().getIdentifier().equals("RequestBody"))
            {
                return true;
            }
        }
        return false;
    }

    public String getClassName()
    {
        return parameter.getType().toString();
    }

    public Parameter getParameter() {
        return parameter;
    }

    public RequestBody setParameter(Parameter parameter) {
        this.parameter = parameter;
        return this;
    }
}
