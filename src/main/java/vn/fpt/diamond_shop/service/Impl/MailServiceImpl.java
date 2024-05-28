package vn.fpt.diamond_shop.service.Impl;

import org.springframework.stereotype.Service;
import vn.fpt.diamond_shop.service.MailService;

@Service
public class MailServiceImpl implements MailService {
    @Override
    public void push(String email, String subject, String content) {
    }
}
