package LPY.appliVisiteur.CodeGen.Model;

import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;

public class RequestMappingAnnotation{
    private NormalAnnotationExpr annotationExpr;

    public RequestMappingAnnotation(NormalAnnotationExpr annotationExpr) {
        this.annotationExpr = annotationExpr;
    }

    public RequestMappingAnnotation() {
    }

    public NormalAnnotationExpr getAnnotationExpr() {
        return annotationExpr;
    }

    public RequestMappingAnnotation setAnnotationExpr(NormalAnnotationExpr annotationExpr) {
        this.annotationExpr = annotationExpr;
        return this;
    }

    public String getMethod()
    {
        for (MemberValuePair memberValuePair : annotationExpr.findAll(MemberValuePair.class))
            {
                if (memberValuePair.getName().getIdentifier().equals("method"))
                {
                    return memberValuePair.getValue().asFieldAccessExpr().getName().getIdentifier();
                }
            }
            return null;
    }

    public String getLink()
    {
        for (MemberValuePair memberValuePair : annotationExpr.findAll(MemberValuePair.class))
        {
            if (memberValuePair.getName().getIdentifier().equals("value"))
            {
                return memberValuePair.getValue().toString().replace("\"","");
            }
        }
        return null;
    }
}
