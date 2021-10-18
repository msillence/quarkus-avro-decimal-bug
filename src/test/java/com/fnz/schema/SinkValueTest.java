package com.fnz.schema;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.jupiter.api.Test;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;

public class SinkValueTest {

	@Test
	
	public void testSerialiseKafkaAvro() throws Exception {
		SinkValue v = createSinkValue();
		KafkaAvroSerializer s = new KafkaAvroSerializer();
		Map<String, String> config = new HashMap<String, String>() {{
			put("reconnect.backoff.max.ms", "10000");
			put("streams.consumer.session.timeout.ms", "250");
			put("avro.use.logical.type.converters", "true");
			put("batch.size", "100");
			put("acks", "1");
			put("bootstrap.servers", "mskafka:9092");
			put("registry.auto-register", "true");
			put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
			put("schema.registry.url", "http://schema-registry:8081");
			put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
			put("commit-strategy", "throttled");
			put("streams.consumer.heartbeat.interval.ms", "200");
			put("merge", "true");
			put("linger.ms", "1000");
			put("client.id", "test");
		}};
		KafkaAvroSerializerConfig kconf = new KafkaAvroSerializerConfig(config);
		s.configure(config, false);
		byte[] b = s.serialize("com.fnz.schema.SinkValue", v);
		System.out.println(new String(b));
		assertThat(b.length, greaterThan(0));	
	}

	@Test
	public void testSerialiseAvro() throws Exception {
		SinkValue v = createSinkValue();

		DatumWriter<SinkValue> writer = new SpecificDatumWriter<>(
				new Schema.Parser().parse("{\r\n"
						+ "  \"connect.name\": \"com.fnz.schema.SinkValue\",\r\n"
						+ "  \"fields\": [\r\n"
						+ "    {\r\n"
						+ "      \"name\": \"id\",\r\n"
						+ "      \"type\": {\r\n"
						+ "        \"avro.java.string\": \"String\",\r\n"
						+ "        \"type\": \"string\"\r\n"
						+ "      }\r\n"
						+ "    },\r\n"
						+ "    {\r\n"
						+ "      \"default\": null,\r\n"
						+ "      \"name\": \"amountAfter\",\r\n"
						+ "      \"type\": [\r\n"
						+ "        \"null\",\r\n"
						+ "        {\r\n"
						+ "          \"logicalType\": \"decimal\",\r\n"
						+ "          \"precision\": 13,\r\n"
						+ "          \"scale\": 6,\r\n"
						+ "          \"type\": \"bytes\"\r\n"
						+ "        }\r\n"
						+ "      ]\r\n"
						+ "    }\r\n"
						+ "  ],\r\n"
						+ "  \"name\": \"SinkValue\",\r\n"
						+ "  \"namespace\": \"com.fnz.schema\",\r\n"
						+ "  \"type\": \"record\"\r\n"
						+ "}"));
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Encoder encoder = EncoderFactory.get().binaryEncoder(stream, null);
		writer.write(v, encoder);
		encoder.flush();
		byte[] data = stream.toByteArray();
		System.out.println(new String(data));
		assertThat(data.length, greaterThan(0));
	}

	@Test
	public void testSerialiseAvroClassSchema() throws Exception {
		SinkValue v = createSinkValue();

		DatumWriter<SinkValue> writer = new SpecificDatumWriter<>(SinkValue.getClassSchema());

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Encoder encoder = EncoderFactory.get().binaryEncoder(stream, null);
		writer.write(v, encoder);
		encoder.flush();
		byte[] data = stream.toByteArray();
		System.out.println(new String(data));
		assertThat(data.length, greaterThan(0));
	}
	
	@Test
	public void testSerialiseAvroClass() throws Exception {
		SinkValue v = createSinkValue();

		DatumWriter<SinkValue> writer = new SpecificDatumWriter<>(SinkValue.class);

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Encoder encoder = EncoderFactory.get().binaryEncoder(stream, null);
		writer.write(v, encoder);
		encoder.flush();
		byte[] data = stream.toByteArray();
		System.out.println(new String(data));
		assertThat(data.length, greaterThan(0));
	}	
	
	SinkValue createSinkValue() {
		SinkValue.Builder b = SinkValue.newBuilder();
		b.setId("id");
		b.setAmountAfter(BigDecimal.valueOf(1.0));
		return b.build();
	}
}
