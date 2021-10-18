package com.fnz.serialiser;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Random;

import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import com.fnz.schema.SinkKey;
import com.fnz.schema.SinkValue;
import com.fnz.schema.SourceKey;
import com.fnz.schema.SourceValue;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.annotations.Merge;
import io.smallrye.reactive.messaging.kafka.Record;
import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;

public class SerialiserSink {
	@Incoming("source")
	@Outgoing("sink") 
	@Merge
	@NonBlocking
	public Message<SinkValue> process(Message<SourceValue> incoming) throws Throwable {
		SourceValue source = incoming.getPayload();
		SinkValue.Builder sb = SinkValue.newBuilder();
		sb.setAmountAfter(source.getAmountBefore());
		sb.setId(source.getId());
		SinkKey.Builder keyb = SinkKey.newBuilder();
		keyb.setId(source.getId());
		return Message.of(sb.build()).addMetadata(OutgoingKafkaRecordMetadata.<SinkKey>builder().withKey(keyb.build()));
	}
	

    private final Random random = new Random();

    @Outgoing("source")
    public Multi<Message<SourceValue>> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
            .map(x -> createMessage("id", random.nextDouble()));
    }

	private Message<SourceValue> createMessage(String id, double value) {
		SourceKey.Builder keyb = SourceKey.newBuilder();
        keyb.setId(id);
        SourceValue.Builder valueb = SourceValue.newBuilder();
        valueb.setId("1").setAmountBefore(BigDecimal.valueOf(value));
        SourceValue sourceValue = valueb.build();
        Message<SourceValue> sourceMessage = Message.of(sourceValue)
        		.addMetadata(OutgoingKafkaRecordMetadata.<SourceKey>builder().withKey(keyb.build()));
        return sourceMessage;
	}
}
