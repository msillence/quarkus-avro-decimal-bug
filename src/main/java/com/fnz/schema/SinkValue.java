/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.fnz.schema;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class SinkValue extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8282610758614378532L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SinkValue\",\"namespace\":\"com.fnz.schema\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"amountAfter\",\"type\":[\"null\",{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":13,\"scale\":6}],\"default\":null}],\"connect.name\":\"com.fnz.schema.SinkValue\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();
static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<SinkValue> ENCODER =
      new BinaryMessageEncoder<SinkValue>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SinkValue> DECODER =
      new BinaryMessageDecoder<SinkValue>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<SinkValue> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<SinkValue> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<SinkValue> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SinkValue>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this SinkValue to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a SinkValue from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a SinkValue instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static SinkValue fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String id;
   private java.math.BigDecimal amountAfter;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SinkValue() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param amountAfter The new value for amountAfter
   */
  public SinkValue(java.lang.String id, java.math.BigDecimal amountAfter) {
    this.id = id;
    this.amountAfter = amountAfter;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return amountAfter;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: amountAfter = (java.math.BigDecimal)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'amountAfter' field.
   * @return The value of the 'amountAfter' field.
   */
  public java.math.BigDecimal getAmountAfter() {
    return amountAfter;
  }


  /**
   * Sets the value of the 'amountAfter' field.
   * @param value the value to set.
   */
  public void setAmountAfter(java.math.BigDecimal value) {
    this.amountAfter = value;
  }

  /**
   * Creates a new SinkValue RecordBuilder.
   * @return A new SinkValue RecordBuilder
   */
  public static com.fnz.schema.SinkValue.Builder newBuilder() {
    return new com.fnz.schema.SinkValue.Builder();
  }

  /**
   * Creates a new SinkValue RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SinkValue RecordBuilder
   */
  public static com.fnz.schema.SinkValue.Builder newBuilder(com.fnz.schema.SinkValue.Builder other) {
    if (other == null) {
      return new com.fnz.schema.SinkValue.Builder();
    } else {
      return new com.fnz.schema.SinkValue.Builder(other);
    }
  }

  /**
   * Creates a new SinkValue RecordBuilder by copying an existing SinkValue instance.
   * @param other The existing instance to copy.
   * @return A new SinkValue RecordBuilder
   */
  public static com.fnz.schema.SinkValue.Builder newBuilder(com.fnz.schema.SinkValue other) {
    if (other == null) {
      return new com.fnz.schema.SinkValue.Builder();
    } else {
      return new com.fnz.schema.SinkValue.Builder(other);
    }
  }

  /**
   * RecordBuilder for SinkValue instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SinkValue>
    implements org.apache.avro.data.RecordBuilder<SinkValue> {

    private java.lang.String id;
    private java.math.BigDecimal amountAfter;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.fnz.schema.SinkValue.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.amountAfter)) {
        this.amountAfter = data().deepCopy(fields()[1].schema(), other.amountAfter);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing SinkValue instance
     * @param other The existing instance to copy.
     */
    private Builder(com.fnz.schema.SinkValue other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.amountAfter)) {
        this.amountAfter = data().deepCopy(fields()[1].schema(), other.amountAfter);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.fnz.schema.SinkValue.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.fnz.schema.SinkValue.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'amountAfter' field.
      * @return The value.
      */
    public java.math.BigDecimal getAmountAfter() {
      return amountAfter;
    }


    /**
      * Sets the value of the 'amountAfter' field.
      * @param value The value of 'amountAfter'.
      * @return This builder.
      */
    public com.fnz.schema.SinkValue.Builder setAmountAfter(java.math.BigDecimal value) {
      validate(fields()[1], value);
      this.amountAfter = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'amountAfter' field has been set.
      * @return True if the 'amountAfter' field has been set, false otherwise.
      */
    public boolean hasAmountAfter() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'amountAfter' field.
      * @return This builder.
      */
    public com.fnz.schema.SinkValue.Builder clearAmountAfter() {
      amountAfter = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SinkValue build() {
      try {
        SinkValue record = new SinkValue();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.amountAfter = fieldSetFlags()[1] ? this.amountAfter : (java.math.BigDecimal) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SinkValue>
    WRITER$ = (org.apache.avro.io.DatumWriter<SinkValue>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SinkValue>
    READER$ = (org.apache.avro.io.DatumReader<SinkValue>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










