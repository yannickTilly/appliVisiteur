package LPY.appliVisiteur.CodeGen.Model;

import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;

public class ControllerRequestMappingAnnotation {
    private SingleMemberAnnotationExpr singleMemberAnnotationExpr;

    public ControllerRequestMappingAnnotation(SingleMemberAnnotationExpr singleMemberAnnotationExpr) {
        this.singleMemberAnnotationExpr = singleMemberAnnotationExpr;
    }

    public static boolean isControllerRequestMappingAnnotation(SingleMemberAnnotationExpr singleMemberAnnotationExpr) {
        return singleMemberAnnotationExpr.getName().getIdentifier().equals("RequestMapping");
    }

    public String getLink()
    {
        return singleMemberAnnotationExpr.getMemberValue().toString().replace("\"","");
    }

    public ControllerRequestMappingAnnotation() {
    }

    public SingleMemberAnnotationExpr getSingleMemberAnnotationExpr() {
        return singleMemberAnnotationExpr;
    }

    public ControllerRequestMappingAnnotation setSingleMemberAnnotationExpr(SingleMemberAnnotationExpr singleMemberAnnotationExpr) {
        this.singleMemberAnnotationExpr = singleMemberAnnotationExpr;
        return this;
    }
}
