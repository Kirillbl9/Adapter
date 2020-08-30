package com.example.Adapter.processor;

import com.example.Adapter.DTO.MessageADTO;
import com.example.Adapter.service.MessageService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor implements Processor{

    private final MessageService messageService;

    public MessageProcessor(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        messageService.addMessage(exchange.getIn().getBody(MessageADTO.class));
    }

}
