package com.foe.webmail.service.filters;

import com.foe.webmail.entity.Folder;
import com.foe.webmail.entity.Mail;
import com.foe.webmail.entity.MailAttachment;
import com.foe.webmail.entity.User;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDateTime;

public class MailSpecifications {

    public static Specification<Mail> hasSubjectLike(String subject) {
        return (root, query, cb) -> {
            return cb.like(root.get("subject"), "%" + subject + "%" );
        };
    }
    public static Specification<Mail> hasBodyLike(String body) {
        return (root, query, cb) -> {
            return cb.like(root.get("body"), "%" + body + "%");
        };
    }
    public static Specification<Mail> hasStatus(String status) {
        return (root, query, cb) -> {
            return cb.equal(root.get("status"), status);
        };
    }
    public static Specification<Mail> hasDateAfter(LocalDateTime date) {
        return (root, query, cb) -> {
            return cb.greaterThan(root.get("date"), date);
        };
    }
    public static Specification<Mail> hasAttachmentsLike(String attachmentName) {
        return (root, query, cb) -> {
            Join<Mail, MailAttachment> attachmentJoin = root.join("attachments");
            return cb.like(attachmentJoin.get("name"), "%" + attachmentName + "%");
        };
    }

    public static Specification<Mail> hasReceiver(String receiverUsername) {
        return (root, query, cb) -> {
            Join<Mail, User> receiversJoin = root.join("receivers");
            return cb.like(receiversJoin.get("username"), "%" + receiverUsername + "%" );
        };
    }

    public static Specification<Mail> hasSender(String senderUsername) {
        return (root, query, cb) -> {
            Join<Mail, User> senderJoin = root.join("sender");
            return cb.like(senderJoin.get("username"), "%" + senderUsername + "%" );
        };
    }

    public static Specification<Mail> hasFolder(String folderName) {
        return (root, query, cb) -> {
            Join<Mail, Folder> folderJoin = root.join("folders");
            return cb.equal(folderJoin.get("name"), folderName);
        };
    }

    public static Specification<Mail> hasImportance(String importance) {
        return (root, query, cb) -> {
            return cb.equal(root.get("importance"), importance);
        };
    }
}
