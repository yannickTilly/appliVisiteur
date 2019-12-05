package LPY.appliVisiteur.CodeGen.Model;

import java.util.ArrayList;
import java.util.List;

public class RestControllerModel {
    private String name;
    private List<RouteModel> routeModels;

    public RestControllerModel(String name) {
        this.name = name;
        this.routeModels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public RestControllerModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<RouteModel> getRouteModels() {
        return routeModels;
    }

    public RestControllerModel addRouteModel(RouteModel routeModel) {
        this.routeModels.add(routeModel);
        return this;
    }
}
