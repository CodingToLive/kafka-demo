package dev.rafa.dispatch.service;

import dev.rafa.dispatch.message.OrderCreated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DispatchService {

    public void process(OrderCreated payload) {
        //no-op for now
        log.info("AAAAAAA");
    }

}