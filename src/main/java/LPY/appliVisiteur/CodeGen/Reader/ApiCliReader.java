package LPY.appliVisiteur.CodeGen.Reader;

import LPY.appliVisiteur.CodeGen.Model.RestController;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ApiCliReader {
    private List<File> files;

    public static void main(String[] args)
    {
        ApiCliReader apiCliReader = new ApiCliReader();
        File file = new File("./src/main/java/LPY/appliVisiteur/Controller/Visiteur/VisitorReportController.java");
        List<RestController> restControllers =apiCliReader.getRestController();
        for (RestController restController : restControllers)
        {
            restController.getRequestMappingFunctions().get(0).getLink();
            restController.getRequestMappingFunctions().get(3).getRequestBody().getClassName();
            restController.getRequestMappingFunctions().get(3).getResponseBody().getClassName();
            restController.getRequestMappingFunctions().get(3).getName();
            restController.getSuffixe();

        }
    }

    public ApiCliReader() {
        this.files = new ArrayList<>();
    }

    public List<RestController> getRestController() {
        List<MarkerAnnotationExpr> markerAnnotationExprs = null;
        List<RestController> restControllers = new ArrayList<RestController>();
        try {
            for (File file : files)
            {
                markerAnnotationExprs = StaticJavaParser.parse(file).findAll(MarkerAnnotationExpr.class);
                for (MarkerAnnotationExpr markerAnnotationExpr : markerAnnotationExprs) {
                    if (markerAnnotationExpr.getName().getIdentifier().equals("RestController")) {
                        markerAnnotationExpr.findAncestor(ClassOrInterfaceDeclaration.class).ifPresent(classOrInterfaceDeclaration -> restControllers.add(new RestController(classOrInterfaceDeclaration)));
                    }
                }
            }
            return restControllers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public List<RestController> getRestControllerBySuffixe(String suffixe) {
        List<RestController> restControllers = getRestController();
        List<RestController> restControllersSelected = new ArrayList<>();
        for(RestController restController : restControllers)
        {
            if (restController.getSuffixe().equals(suffixe))
            {
                restControllersSelected.add(restController);
            }
        }
        return restControllersSelected;
    }

    public List<String> getSuffixes()
    {
        List<String> suffixes = new ArrayList<>();
        for (RestController restController : getRestController())
        {
            suffixes.add(restController.getSuffixe());
        }
        return suffixes;
    }
}
