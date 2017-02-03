package sockets;

/**
 * Created by Philipp on 18.01.2017.
 */
public enum HttpResponseCode {

    Conflict(409, "Conflict"),
    NotFound(404, "Not Found"),
    Erstellt(201, "Created"),
    OK(200, "OK"),
    NoContent(204, "No Content");



    private int code;
    private String text;

    HttpResponseCode(int code, String text){
        this.code = code;
        this.text = text;
    }

    public int getCode(){
        return code;
    }



}
