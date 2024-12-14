package com.foe.webmail.repository;

import com.foe.webmail.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface MailRepository extends JpaRepository<Mail, Long> {

//    @Query(value = "SELECT * FROM mail m "+
//                   "JOIN mail_Receiver mr on m.id = mr.mail_id " +
//                   "JOIN user r on mr.receiver_id = r.id " +
//                   , nativeQuery = true)

}
