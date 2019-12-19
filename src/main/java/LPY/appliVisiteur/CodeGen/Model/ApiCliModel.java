package LPY.appliVisiteur.CodeGen.Model;

import LPY.appliVisiteur.CodeGen.Reader.ApiCliReader;
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

public class ApiCliModel {
    private List<RestControllerModel> routeModels;
    private String name;

    public ApiCliModel() {
        this.routeModels = new ArrayList<>();
    }

    public List<RestControllerModel> getRestControllerModels() {
        return routeModels;
    }

    public ApiCliModel addRestControllerModel(RestControllerModel restController)
    {
        routeModels.add(restController);
        return this;
    }

    public String getName() {
        return name;
    }

    public ApiCliModel setName(String name) {
        this.name = name;
        return this;
    }
}
