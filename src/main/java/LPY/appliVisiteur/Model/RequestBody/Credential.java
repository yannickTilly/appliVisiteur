package LPY.appliVisiteur.Model.RequestBody;

public class Credential {
    private String login;

    private String password;

    public String getLogin() {
        return login;
    }

    public Credential setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Credential setPassword(String password) {
        this.password = password;
        return this;
    }
}
