package com.fangyou.vo.restful;


import lombok.Data;

/**
 * 消息存放实体封装
 */
@Data
public class Message {

    private Long id;
    private String text;
    private String summary;

}
