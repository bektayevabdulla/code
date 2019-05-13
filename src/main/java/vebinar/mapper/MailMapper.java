package vebinar.mapper;

import org.springframework.jdbc.core.RowMapper;
import vebinar.entity.Mail;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MailMapper implements RowMapper<Mail> {

    public Mail mapRow(ResultSet resultSet, int i) throws SQLException {
        Mail mail = new Mail();
        mail.setLoginfrom(resultSet.getString("loginfrom"));
        mail.setLoginto(resultSet.getString("loginto"));
        mail.setMessage(resultSet.getString("message"));
        mail.setId(resultSet.getInt("id"));
        return mail;
    }
}