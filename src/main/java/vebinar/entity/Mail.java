package vebinar.entity;

public class Mail {
    String loginto;
    String loginfrom;
    String message;
    int id;

    public String getLoginto() {
        return loginto;
    }

    public void setLoginto(String loginto) {
        this.loginto = loginto;
    }

    public String getLoginfrom() {
        return loginfrom;
    }

    public void setLoginfrom(String loginfrom) {
        this.loginfrom = loginfrom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mail(String loginto, String loginfrom, String message, int id) {
        this.loginto = loginto;
        this.loginfrom = loginfrom;
        this.message = message;
        this.id = id;
    }

    public Mail() {
    }

}
