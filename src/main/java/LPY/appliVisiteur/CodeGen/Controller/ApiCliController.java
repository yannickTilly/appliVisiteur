package LPY.appliVisiteur.CodeGen.Controller;

import LPY.appliVisiteur.CodeGen.Builder.ApiCliBuilder;
import LPY.appliVisiteur.CodeGen.Model.*;
import LPY.appliVisiteur.CodeGen.Reader.ApiCliReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiCliController {
    List<File> files;
    ApiCliReader apiCliReader;
    List<ApiCliModel> apiCliModels;

    public static void main(String[] args)
    {
        ApiCliController apiCliController = new ApiCliController();
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Administrator/AdministratorReportController.java"));
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Administrator/AdministratorDepartmentController.java"));
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Administrator/AdministratorRegionController.java"));
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Administrator/AdministratorDiplomaController.java"));
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Administrator/AdministratorDrugController.java"));
        apiCliController.addFile(new File("./src/main/java/LPY/appliVisiteur/Controller/Administrator/AdministratorSectorController.java"));
        apiCliController.generate();
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
            ApiCliModel apiCliModel = new ApiCliModel();
            apiCliModel.setName(suffixe);
            apiCliModels.add(apiCliModel);
            for (RestController restController : apiCliReader.getRestControllerBySuffixe(suffixe))
            {
                RestControllerModel restControllerModel = new RestControllerModel(restController.getName());
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
                    restControllerModel.addRouteModel(routeModel);
                    routeModel.getIdNames();
                }
                apiCliModel.addRestControllerModel(restControllerModel);
            }
        }
    }

    public void generate()
    {
        generateModel();
        for (ApiCliModel apiCliModel: apiCliModels)
        {
            ApiCliBuilder apiCliBuilder = new ApiCliBuilder(apiCliModel.getName());
            for(RestControllerModel restControllerModel : apiCliModel.getRestControllerModels())
            {
                apiCliBuilder.addRoutes(restControllerModel.getRouteModels());
            }
            File file = new File("./output/codegen/apiclient/" + apiCliModel.getName() + ".java");
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write(apiCliBuilder.getApiClassStr());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ApiCliController addFile(File file)
    {
        apiCliReader.addFile(file);
        return this;
    }
}
