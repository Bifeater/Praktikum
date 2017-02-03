package sockets;

/**
 * Created by Philipp on 18.01.2017.
 */
public class Response {

    private HttpResponseCode code;
    private String value;


    public Response(HttpResponseCode code, String value){
        this.code = code;
        this.value = value;
    }

    public HttpResponseCode getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
