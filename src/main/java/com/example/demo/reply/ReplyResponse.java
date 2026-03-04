package com.example.demo.reply;

import java.sql.Timestamp;

import lombok.Data;

public class ReplyResponse {

    @Data
    public static class Detail {
        private Integer id;
        private String comment;
        private Integer userId;
        private Integer boardId;
        private Timestamp createdAt;

        public Detail(Reply reply) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.userId = reply.getUser().getId();
            this.boardId = reply.getBoard().getId();
            this.createdAt = reply.getCreatedAt();
        }
    }
}
