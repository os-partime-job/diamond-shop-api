package vn.fpt.diamond_shop.service;

public interface MailService {
    void push(String email, String subject, String content);
}
