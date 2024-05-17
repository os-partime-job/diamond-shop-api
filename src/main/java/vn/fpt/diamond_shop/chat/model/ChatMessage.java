package vn.fpt.diamond_shop.chat.model;

import lombok.*;

import java.nio.file.FileStore;
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }
}
