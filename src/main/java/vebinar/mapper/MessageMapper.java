package vebinar.mapper;

import vebinar.entity.MessageEntity;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper<MessageEntity> {

    public MessageEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        MessageEntity message = new MessageEntity();
        message.setId(resultSet.getInt("id"));
        message.setName(resultSet.getString("name"));
        message.setMessage(resultSet.getString("email"));
        return message;
    }
}
