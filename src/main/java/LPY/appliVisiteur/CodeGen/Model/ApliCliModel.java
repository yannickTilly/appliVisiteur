package LPY.appliVisiteur.CodeGen.Model;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ApliCliModel {
    private List<File> files;
    public static void main(String[] args) {
        ApliCliModel apliCliModel = new ApliCliModel();
        apliCliModel.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Visiteur/VisitorDepartmentController.java"));
        apliCliModel.generate();
    }

    public ApliCliModel() {
        this.files = new ArrayList<>();
    }

    public void addFile(File file)
    {
        files.add(file);
    }

    public void generate()
    {
        for(File file : files)
        {
            try {
                CompilationUnit compilationUnit = StaticJavaParser.parse(file);
                List<ClassOrInterfaceDeclaration> rest = getRestController(compilationUnit);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ClassOrInterfaceDeclaration> getRestController(CompilationUnit compilationUnit)
    {
        List<MarkerAnnotationExpr> markerAnnotationExprs = compilationUnit.findAll(MarkerAnnotationExpr.class);
        List<ClassOrInterfaceDeclaration> restControllers = new ArrayList<ClassOrInterfaceDeclaration>();
        for (MarkerAnnotationExpr markerAnnotationExpr : markerAnnotationExprs)
        {
            if (markerAnnotationExpr.getName().getIdentifier().equals("RestController"))
            {
                ClassOrInterfaceDeclaration restController;
                markerAnnotationExpr.findAncestor(ClassOrInterfaceDeclaration.class).ifPresent(restControllers::add);
            }
        }
        return restControllers;
    }
}
