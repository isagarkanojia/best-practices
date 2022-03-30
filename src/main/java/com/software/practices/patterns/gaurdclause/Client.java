package com.software.practices.patterns.gaurdclause;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Sagar Kanojia
 */
@Component
@Slf4j
public class Client {

    public static void main(String[] args) {
        Response response = new Response();
        response.setId(UUID.randomUUID().toString());
        response.setStatus(ReesponseStatus.FAILED.name());


        Client client = new Client();
        client.someFuntion(response);

    }

    private void someFuntion(Response response) {

        try {
            ResponseGuard.AgainstNull(response, Response.class.getName());

            ResponseGuard.AgainstFailedResponse(response, Response.class.getName());

            // do something with response

        } catch (CustomException e) {
            // return custom response in case errors
            log.error(" ", e.getCause());
        }

    }
}
