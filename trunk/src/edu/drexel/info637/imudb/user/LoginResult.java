package edu.drexel.info637.imudb.user;

import edu.drexel.info637.imudb.domain.User;

public class LoginResult {

    private boolean success  = false;
    private String  errorMsg = "not initialized";
    private User    user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
