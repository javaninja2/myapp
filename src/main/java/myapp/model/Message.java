package myapp.model;

public class Message {
    long id;
    String message;

    public Message(long l, String format) {
        this.id = l;
        this.message = format;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
