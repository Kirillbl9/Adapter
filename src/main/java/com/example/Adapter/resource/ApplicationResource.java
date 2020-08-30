package com.example.Adapter.resource;

import com.example.Adapter.DTO.MessageADTO;
import com.example.Adapter.processor.MessageProcessor;
import com.example.Adapter.service.MessageService;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResource extends RouteBuilder {

    private final MessageService messageService;

    @BeanInject
    private MessageProcessor messageProcessor;

    public ApplicationResource(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void configure() {
        restConfiguration().component("servlet").port(8080).host("localhost").bindingMode(RestBindingMode.json);


        rest().get("/getMessage")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .route().setBody(messageService::getMessages)
                .endRest();

        rest().post("/addMessage")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .type(MessageADTO.class).outType(MessageADTO.class)
                .route().process(messageProcessor)
                .endRest();
    }
}