package hexlet.code;

public class User {

    private String userName;

    /**
     * @param name - user name
     */
    public User(String name) {
        this.userName = name;
    }

    /**
     * @return name - user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param name - user name
     */
    public void setUserName(String name) {
        this.userName = name;
    }
}
