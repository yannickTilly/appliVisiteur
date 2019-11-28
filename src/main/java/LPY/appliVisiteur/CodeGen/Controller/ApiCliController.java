package LPY.appliVisiteur.CodeGen.Controller;

import LPY.appliVisiteur.CodeGen.Model.ApiCliModel;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ApiCliController {
//    public class ApiCliBuilder {
//        private List<File> files;
//        public static void main(String[] args) {
//            ApiCliModel apliCliModel = new ApiCliModel();
//            apliCliModel.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Visiteur/VisitorReportController.java"));
//            apliCliModel.generate();
//        }
//
////        public ApiCliModel() {
////            this.files = new ArrayList<>();
////        }
//
//        public void addFile(File file)
//        {
//            files.add(file);
//        }
//
//        public void generate()
//        {
//            for(File file : files)
//            {
//                try {
//                    CompilationUnit compilationUnit = StaticJavaParser.parse(file);
//                    List<MethodDeclaration> requestFunction = getRequestFunction(compilationUnit);
//                    createApiCliClass(requestFunction, "test");
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        public List<ClassOrInterfaceDeclaration> getRestController(CompilationUnit compilationUnit)
//        {
//            List<MarkerAnnotationExpr> markerAnnotationExprs = compilationUnit.findAll(MarkerAnnotationExpr.class);
//            List<ClassOrInterfaceDeclaration> restControllers = new ArrayList<ClassOrInterfaceDeclaration>();
//            for (MarkerAnnotationExpr markerAnnotationExpr : markerAnnotationExprs)
//            {
//                if (markerAnnotationExpr.getName().getIdentifier().equals("RestController"))
//                {
//                    ClassOrInterfaceDeclaration restController;
//                    markerAnnotationExpr.findAncestor(ClassOrInterfaceDeclaration.class).ifPresent(restControllers::add);
//                }
//            }
//            return restControllers;
//        }
//
//        public List<MethodDeclaration> getRequestFunction(CompilationUnit compilationUnit)
//        {
//            List<MethodDeclaration> requestFunctions = new ArrayList<>();
//            for(ClassOrInterfaceDeclaration classOrInterfaceDeclaration : getRestController(compilationUnit))
//            {
//                List<MethodDeclaration> methodDeclarations = classOrInterfaceDeclaration.findAll(MethodDeclaration.class);
//                for (MethodDeclaration methodDeclaration : methodDeclarations) {
//                    if (isRequestFunction(methodDeclaration)) {
//                        requestFunctions.add(methodDeclaration);
//                    }
//                }
//            }
//            return requestFunctions;
//        }
//
//        public boolean isRequestFunction(MethodDeclaration methodDeclaration)
//        {
//            List<NormalAnnotationExpr> markerAnnotationExprs = methodDeclaration.findAll(NormalAnnotationExpr.class);
//            for (NormalAnnotationExpr markerAnnotationExpr: markerAnnotationExprs)
//            {
//                if(markerAnnotationExpr.getName().getIdentifier().equals("RequestMapping"))
//                {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public void createApiCliClass(List<MethodDeclaration> requestFunctions, String nomAPI)
//        {
//            CompilationUnit compilationUnit = new CompilationUnit();
//            compilationUnit.addImport("java.net.http.HttpRequest");
//            ClassOrInterfaceDeclaration apiCliClass = compilationUnit.addClass(nomAPI + "ApiCli");
//            for (MethodDeclaration requestFunction : requestFunctions)
//            {
//                String restVerb = getRouteVerb(getRequestMappingAnnotation(requestFunction));
//                MethodDeclaration requestFunctionCli = apiCliClass.addMethod(requestFunction.getName().getIdentifier());
//                BlockStmt block = new BlockStmt();
//                requestFunctionCli.setBody(block);
//                // add a statement do the method body
//                NameExpr clazz = new NameExpr("System");
//                FieldAccessExpr field = new FieldAccessExpr(clazz, "out");
//                MethodCallExpr call = new MethodCallExpr(field, "println");
//                call.addArgument(new StringLiteralExpr("Hello World!"));
//                block.addStatement(call);
//                ExpressionStmt expressionStmt = new ExpressionStmt();
//                VariableDeclarationExpr variableDeclarationExpr = new VariableDeclarationExpr();
//                VariableDeclarator variableDeclarator = new VariableDeclarator();
//                variableDeclarator.setName("request");
//                ClassOrInterfaceType httpCliClass = new ClassOrInterfaceType("HttpRequest");
//                variableDeclarator.setType(httpCliClass);
//                variableDeclarator.setInitializer(getHttpRequestInitializer(restVerb, "test/link"));
//                NodeList<VariableDeclarator> variableDeclarators = new NodeList<>();
//                variableDeclarators.add(variableDeclarator);
//                variableDeclarationExpr.setVariables(variableDeclarators);
//                expressionStmt.setExpression(variableDeclarationExpr);
//                block.addStatement(expressionStmt);
//            }
//            compilationUnit.toString();
//        }
//
//        public String getRouteVerb(NormalAnnotationExpr requestMapping)
//        {
//            for (MemberValuePair memberValuePair : requestMapping.findAll(MemberValuePair.class))
//            {
//                if (memberValuePair.getName().getIdentifier().equals("method"))
//                {
//                    return memberValuePair.getValue().asFieldAccessExpr().getName().getIdentifier();
//                }
//            }
//            return null;
//        }
//
//        private NormalAnnotationExpr getRequestMappingAnnotation(MethodDeclaration requestFunction)
//        {
//            List<NormalAnnotationExpr> annotations = requestFunction.findAll(NormalAnnotationExpr.class);
//            for (NormalAnnotationExpr markerAnnotationExpr: annotations)
//            {
//                if(markerAnnotationExpr.getName().getIdentifier().equals("RequestMapping"))
//                {
//                    return markerAnnotationExpr;
//                }
//            }
//            return null;
//        }
//
//
//    }

}
