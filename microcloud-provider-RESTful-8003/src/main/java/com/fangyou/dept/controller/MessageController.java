package com.fangyou.dept.controller;

import com.fangyou.entity.restful.Message;
import com.fangyou.dept.service.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * 获取所有消息体
     * @return
     */
    @GetMapping(value = "messages")
    public List<Message> list(){
        List<Message> messages = this.messageRepository.findAll();
        return messages;
    }

    /**
     * 创建一个消息体
     * @param message
     * @return
     */
    @PostMapping(value = "message")
    public Message create(Message message){
        message = this.messageRepository.save(message);
        return message;
    }

    /**
     * 使用PUT请求进行修改
     * @param message
     * @return
     */
    @PutMapping(value = "message")
    public Message modify(Message message){
        Message messageResult = this.messageRepository.update(message);
        return messageResult;
    }

    /**
     * 更新消息的text字段
     * @param message
     * @return
     */
    @PatchMapping(value = "/message/text")
    public Message patch(Message message){
        Message messageResult = this.messageRepository.updateText(message);
        return messageResult;
    }

    @GetMapping(value = "/message/{id}")
    public Message get(@PathVariable Long id){
        Message message = this.messageRepository.findMessage(id);
        return message;
    }

    @DeleteMapping(value = "/message/{id}")
    public void delete(@PathVariable("id") Long id){
        this.messageRepository.deleteMessage(id);
    }

}
