package LPY.appliVisiteur.CodeGen.Model;

import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.Name;

public class RestControllerAnnotation {
    private MarkerAnnotationExpr markerAnnotationExpr;

    public RestControllerAnnotation(MarkerAnnotationExpr markerAnnotationExpr) {
        this.markerAnnotationExpr = markerAnnotationExpr;
    }

    public RestControllerAnnotation() {

    }

    public static boolean isRestControllerAnnotation(MarkerAnnotationExpr markerAnnotationExpr) {
        return markerAnnotationExpr.getName().getIdentifier().equals("RestController");
    }

    public MarkerAnnotationExpr getMarkerAnnotationExpr() {
        return markerAnnotationExpr;
    }

    public RestControllerAnnotation setMarkerAnnotationExpr(MarkerAnnotationExpr markerAnnotationExpr) {
        this.markerAnnotationExpr = markerAnnotationExpr;
        return this;
    }
}
