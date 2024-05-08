package sample.commons.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class Response {

    private Response() {
    }

    public static ResponseEntity<MessageResponse> err(Map<String, String> errors) {
        return ResponseEntity.status(400).body(new MessageResponse("Invalid request"));
    }

    public static ResponseEntity<MessageResponse> err(String message) {
        return ResponseEntity.status(400).body(new MessageResponse(message));
    }

    public static ResponseEntity<MessageResponse> internalErr() {
        return ResponseEntity.status(500).body(new MessageResponse("Internal server error", 500));
    }

    public static ResponseEntity<MessageResponse> internalErr(String message) {
        return ResponseEntity.status(500).body(new MessageResponse(message));
    }

    public static <T> ResponseEntity<T> ok(T body) {
        return ResponseEntity.ok(body);
    }

    public static ResponseEntity<MessageResponse> unauthorized(String message) {
        return ResponseEntity.status(401).body(new MessageResponse(message));
    }

    @Getter
    @Setter
    public static class MessageResponse {
        private int code;
        private String data;
        private MetaData metaData;

        public MessageResponse(String data) {
            this.data = data;
        }

        public MessageResponse(String data, int code) {
            this.data = data;
            this.code = code;
        }

        public MessageResponse(String data, int code, MetaData metaData) {
            this.data = data;
            this.code = code;
            this.metaData = metaData;
        }
    }

    @Getter
    @Setter
    public static class MetaData {
        private String total;
        private String pageSize;
        private String pageIndex;
    }
}
