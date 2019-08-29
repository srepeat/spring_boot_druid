package cn.jcet.domain;

import java.util.List;

/**
 * @author 鲜磊 on 2019/8/26
 **/
public class UserActive {

    private User user;
    private List<String> roles;
    private List<String> perssiom;

    public UserActive(){

    }

    public UserActive(User user, List<String> roles, List<String> perssiom) {
        this.user = user;
        this.roles = roles;
        this.perssiom = perssiom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPerssiom() {
        return perssiom;
    }

    public void setPerssiom(List<String> perssiom) {
        this.perssiom = perssiom;
    }
}
