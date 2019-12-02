package LPY.appliVisiteur.CodeGen.Model;

public class ResponseBody {
    private String className;

    public ResponseBody(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public ResponseBody setClassName(String className) {
        this.className = className;
        return this;
    }
}
