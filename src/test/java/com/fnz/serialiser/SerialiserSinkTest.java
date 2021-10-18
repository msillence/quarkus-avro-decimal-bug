package com.fnz.serialiser;



import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Message;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fnz.schema.SinkKey;
import com.fnz.schema.SinkValue;
import com.fnz.schema.SourceKey;
import com.fnz.schema.SourceValue;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.reactive.messaging.connectors.InMemoryConnector;
import io.smallrye.reactive.messaging.connectors.InMemorySink;
import io.smallrye.reactive.messaging.connectors.InMemorySource;
import io.smallrye.reactive.messaging.kafka.Record;
import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;

@QuarkusTest
public class SerialiserSinkTest {

    @BeforeAll
    public static void switchMyChannels() {
        InMemoryConnector.switchIncomingChannelsToInMemory("source");
        InMemoryConnector.switchOutgoingChannelsToInMemory("sink");
    }
    
    @AfterAll
    public static void revertMyChannels() {
        InMemoryConnector.clear();
    }


    @Inject
    @Any
    InMemoryConnector connector;
    
	@Test
	public void testProcess() {
        InMemorySource<Message<SourceValue>> in = connector.source("source");
        InMemorySink<SinkValue> out = connector.sink("sink");

        SourceKey.Builder keyb = SourceKey.newBuilder();
        keyb.setId("1");
        SourceValue.Builder valueb = SourceValue.newBuilder();
        valueb.setId("1").setAmountBefore(BigDecimal.valueOf(1.234));
        SourceValue sourceValue = valueb.build();
        Message<SourceValue> sourceMessage = Message.of(sourceValue)
        		.addMetadata(OutgoingKafkaRecordMetadata.<SourceKey>builder().withKey(keyb.build()));

        in.send(sourceMessage);
        
        java.util.List<? extends Message<com.fnz.schema.SinkValue>> recieved = out.received();

//        Assertions.assertEquals(1, out.received().size());
        Message<SinkValue> msg = recieved.get(0);
        SinkValue value = msg.getPayload();
        assertThat(sourceValue.getAmountBefore(), Matchers.comparesEqualTo(value.getAmountAfter()));
	}

}
