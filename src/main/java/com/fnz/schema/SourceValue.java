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
public class SourceValue extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1930078917950229180L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SourceValue\",\"namespace\":\"com.fnz.schema\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"amountBefore\",\"type\":[\"null\",{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":13,\"scale\":6}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();
static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<SourceValue> ENCODER =
      new BinaryMessageEncoder<SourceValue>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SourceValue> DECODER =
      new BinaryMessageDecoder<SourceValue>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<SourceValue> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<SourceValue> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<SourceValue> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SourceValue>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this SourceValue to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a SourceValue from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a SourceValue instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static SourceValue fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String id;
   private java.math.BigDecimal amountBefore;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SourceValue() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param amountBefore The new value for amountBefore
   */
  public SourceValue(java.lang.String id, java.math.BigDecimal amountBefore) {
    this.id = id;
    this.amountBefore = amountBefore;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return amountBefore;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: amountBefore = (java.math.BigDecimal)value$; break;
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
   * Gets the value of the 'amountBefore' field.
   * @return The value of the 'amountBefore' field.
   */
  public java.math.BigDecimal getAmountBefore() {
    return amountBefore;
  }


  /**
   * Sets the value of the 'amountBefore' field.
   * @param value the value to set.
   */
  public void setAmountBefore(java.math.BigDecimal value) {
    this.amountBefore = value;
  }

  /**
   * Creates a new SourceValue RecordBuilder.
   * @return A new SourceValue RecordBuilder
   */
  public static com.fnz.schema.SourceValue.Builder newBuilder() {
    return new com.fnz.schema.SourceValue.Builder();
  }

  /**
   * Creates a new SourceValue RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SourceValue RecordBuilder
   */
  public static com.fnz.schema.SourceValue.Builder newBuilder(com.fnz.schema.SourceValue.Builder other) {
    if (other == null) {
      return new com.fnz.schema.SourceValue.Builder();
    } else {
      return new com.fnz.schema.SourceValue.Builder(other);
    }
  }

  /**
   * Creates a new SourceValue RecordBuilder by copying an existing SourceValue instance.
   * @param other The existing instance to copy.
   * @return A new SourceValue RecordBuilder
   */
  public static com.fnz.schema.SourceValue.Builder newBuilder(com.fnz.schema.SourceValue other) {
    if (other == null) {
      return new com.fnz.schema.SourceValue.Builder();
    } else {
      return new com.fnz.schema.SourceValue.Builder(other);
    }
  }

  /**
   * RecordBuilder for SourceValue instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SourceValue>
    implements org.apache.avro.data.RecordBuilder<SourceValue> {

    private java.lang.String id;
    private java.math.BigDecimal amountBefore;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.fnz.schema.SourceValue.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.amountBefore)) {
        this.amountBefore = data().deepCopy(fields()[1].schema(), other.amountBefore);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing SourceValue instance
     * @param other The existing instance to copy.
     */
    private Builder(com.fnz.schema.SourceValue other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.amountBefore)) {
        this.amountBefore = data().deepCopy(fields()[1].schema(), other.amountBefore);
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
    public com.fnz.schema.SourceValue.Builder setId(java.lang.String value) {
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
    public com.fnz.schema.SourceValue.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'amountBefore' field.
      * @return The value.
      */
    public java.math.BigDecimal getAmountBefore() {
      return amountBefore;
    }


    /**
      * Sets the value of the 'amountBefore' field.
      * @param value The value of 'amountBefore'.
      * @return This builder.
      */
    public com.fnz.schema.SourceValue.Builder setAmountBefore(java.math.BigDecimal value) {
      validate(fields()[1], value);
      this.amountBefore = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'amountBefore' field has been set.
      * @return True if the 'amountBefore' field has been set, false otherwise.
      */
    public boolean hasAmountBefore() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'amountBefore' field.
      * @return This builder.
      */
    public com.fnz.schema.SourceValue.Builder clearAmountBefore() {
      amountBefore = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SourceValue build() {
      try {
        SourceValue record = new SourceValue();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.amountBefore = fieldSetFlags()[1] ? this.amountBefore : (java.math.BigDecimal) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SourceValue>
    WRITER$ = (org.apache.avro.io.DatumWriter<SourceValue>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SourceValue>
    READER$ = (org.apache.avro.io.DatumReader<SourceValue>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}









