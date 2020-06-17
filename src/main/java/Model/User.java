package Model;

import java.util.Objects;

public class User {
    private Participant username;
    private Participant password;
    private Participant role;

    public User(){
    }

    public User(Participant username, Participant password, Participant role){
        this.username=username;
        this.password=password;
        this.role=role;
    }

    public Participant getUsername() {
        return username;
    }

    public void setUsername(Participant username) {
        this.username = username;
    }

    public Participant getPassword() {
        return password;
    }

    public void setPassword(Participant password) {
        this.password = password;
    }

    public void setRole(Participant role) {
        this.role=role;
    }

    public Participant getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

}
