package dev.rafa.dispatch.handler;

import dev.rafa.dispatch.message.OrderCreated;
import dev.rafa.dispatch.service.DispatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderCreatedHandler {


    private final DispatchService dispatchService;

    @KafkaListener(
            id = "orderConsumerClient",
            topics = "order.created",
            groupId = "dispatch.order.created.consumer",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(OrderCreated payload) {
        log.info("Received Message: payload: " + payload);
        try {
            dispatchService.process(payload);
        } catch (Exception e) {
            log.error("PROCESSING FAILED: ", e.getMessage());
        }
    }

}
