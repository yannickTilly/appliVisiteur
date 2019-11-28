package LPY.appliVisiteur.CodeGen.Reader;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;

import java.util.ArrayList;
import java.util.List;

public class ApiCliReader {
    public static List<ClassOrInterfaceDeclaration> getRestController(CompilationUnit compilationUnit) {
        List<MarkerAnnotationExpr> markerAnnotationExprs = compilationUnit.findAll(MarkerAnnotationExpr.class);
        List<ClassOrInterfaceDeclaration> restControllers = new ArrayList<ClassOrInterfaceDeclaration>();
        for (MarkerAnnotationExpr markerAnnotationExpr : markerAnnotationExprs) {
            if (markerAnnotationExpr.getName().getIdentifier().equals("RestController")) {
                ClassOrInterfaceDeclaration restController;
                markerAnnotationExpr.findAncestor(ClassOrInterfaceDeclaration.class).ifPresent(restControllers::add);
            }
        }
        return restControllers;
    }

    public static List<MethodDeclaration> getRequestFunction(CompilationUnit compilationUnit) {
        List<MethodDeclaration> requestFunctions = new ArrayList<>();
        for (ClassOrInterfaceDeclaration classOrInterfaceDeclaration : getRestController(compilationUnit)) {
            List<MethodDeclaration> methodDeclarations = classOrInterfaceDeclaration.findAll(MethodDeclaration.class);
            for (MethodDeclaration methodDeclaration : methodDeclarations) {
                if (isRequestFunction(methodDeclaration)) {
                    requestFunctions.add(methodDeclaration);
                }
            }
        }
        return requestFunctions;
    }

    public static boolean isRequestFunction(MethodDeclaration methodDeclaration) {
        List<NormalAnnotationExpr> markerAnnotationExprs = methodDeclaration.findAll(NormalAnnotationExpr.class);
        for (NormalAnnotationExpr markerAnnotationExpr : markerAnnotationExprs) {
            if (markerAnnotationExpr.getName().getIdentifier().equals("RequestMapping")) {
                return true;
            }
        }
        return false;
    }


    public static String getRouteVerb(NormalAnnotationExpr requestMapping) {
        for (MemberValuePair memberValuePair : requestMapping.findAll(MemberValuePair.class)) {
            if (memberValuePair.getName().getIdentifier().equals("method")) {
                return memberValuePair.getValue().asFieldAccessExpr().getName().getIdentifier();
            }
        }
        return null;
    }

    public static NormalAnnotationExpr getRequestMappingAnnotation(MethodDeclaration requestFunction) {
        List<NormalAnnotationExpr> annotations = requestFunction.findAll(NormalAnnotationExpr.class);
        for (NormalAnnotationExpr markerAnnotationExpr : annotations) {
            if (markerAnnotationExpr.getName().getIdentifier().equals("RequestMapping")) {
                return markerAnnotationExpr;
            }
        }
        return null;
    }
}
