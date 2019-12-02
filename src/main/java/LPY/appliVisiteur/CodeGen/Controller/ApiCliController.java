package LPY.appliVisiteur.CodeGen.Controller;

import LPY.appliVisiteur.CodeGen.Model.*;
import LPY.appliVisiteur.CodeGen.Reader.ApiCliReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ApiCliController {
    List<File> files;
    ApiCliReader apiCliReader;
    List<ApiCliModel> apiCliModels;

    public static void main(String[] args)
    {
        ApiCliController apiCliController = new ApiCliController();
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Visiteur/VisitorReportController.java"));
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Delegues/DelegueDepartmentController.java"));
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Visiteur/VisitorRegionController.java"));
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Delegues/DelegueDiplomaController.java"));
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Visiteur/VisitorDrugController.java"));
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Delegues/DelegueSectorController.java"));
        apiCliController.generateModel();
    }
    public ApiCliController()
    {
        files = new ArrayList<>();
        apiCliReader = new ApiCliReader();
        apiCliModels = new ArrayList<>();
    }
    public void generateModel()
    {
        for(String suffixe : apiCliReader.getSuffixes())
        {
            for (RestController restController : apiCliReader.getRestControllerBySuffixe(suffixe))
            {
                ApiCliModel apiCliModel = new ApiCliModel();
                apiCliModel.setName(restController.getSuffixe() + restController.getName());
                apiCliModels.add(apiCliModel);
                for (RequestMappingFunction requestMappingFunction : restController.getRequestMappingFunctions())
                {
                    RouteModel routeModel = new RouteModel();
                    routeModel.setLink(requestMappingFunction.getLink());
                    routeModel.setMethod(requestMappingFunction.getMethod());
                    routeModel.setName(requestMappingFunction.getName());
                    RequestBody requestBody = requestMappingFunction.getRequestBody();
                    if(requestBody !=  null)
                    {
                        routeModel.setRequestBody(requestBody.getClassName());
                    }
                    routeModel.setResponseBody(requestMappingFunction.getResponseBody().getClassName());
                    apiCliModel.addRouteModel(routeModel);
                }
            }
        }
    }

    public ApiCliController addFile(File file)
    {
        apiCliReader.addFile(file);
        return this;
    }
}
