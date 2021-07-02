package tech.klok.kear.hub.presentation.authentication.dto;

public class CredentialsDTO {
    private String userName;
    private String password;

    public CredentialsDTO() {
    }

    public CredentialsDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
