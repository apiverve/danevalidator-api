// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     DANERecordValidatorData data = Converter.fromJsonString(jsonString);

package com.apiverve.danevalidator.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static DANERecordValidatorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(DANERecordValidatorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(DANERecordValidatorData.class);
        writer = mapper.writerFor(DANERecordValidatorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// DANERecordValidatorData.java

package com.apiverve.danevalidator.data;

import com.fasterxml.jackson.annotation.*;

public class DANERecordValidatorData {
    private String rawRecord;
    private Parsed parsed;
    private Interpretation interpretation;
    private Validation validation;

    @JsonProperty("raw_record")
    public String getRawRecord() { return rawRecord; }
    @JsonProperty("raw_record")
    public void setRawRecord(String value) { this.rawRecord = value; }

    @JsonProperty("parsed")
    public Parsed getParsed() { return parsed; }
    @JsonProperty("parsed")
    public void setParsed(Parsed value) { this.parsed = value; }

    @JsonProperty("interpretation")
    public Interpretation getInterpretation() { return interpretation; }
    @JsonProperty("interpretation")
    public void setInterpretation(Interpretation value) { this.interpretation = value; }

    @JsonProperty("validation")
    public Validation getValidation() { return validation; }
    @JsonProperty("validation")
    public void setValidation(Validation value) { this.validation = value; }
}

// Interpretation.java

package com.apiverve.danevalidator.data;

import com.fasterxml.jackson.annotation.*;

public class Interpretation {
    private Matching usage;
    private Matching selector;
    private Matching matching;
    private String securityLevel;
    private String recommendation;

    @JsonProperty("usage")
    public Matching getUsage() { return usage; }
    @JsonProperty("usage")
    public void setUsage(Matching value) { this.usage = value; }

    @JsonProperty("selector")
    public Matching getSelector() { return selector; }
    @JsonProperty("selector")
    public void setSelector(Matching value) { this.selector = value; }

    @JsonProperty("matching")
    public Matching getMatching() { return matching; }
    @JsonProperty("matching")
    public void setMatching(Matching value) { this.matching = value; }

    @JsonProperty("security_level")
    public String getSecurityLevel() { return securityLevel; }
    @JsonProperty("security_level")
    public void setSecurityLevel(String value) { this.securityLevel = value; }

    @JsonProperty("recommendation")
    public String getRecommendation() { return recommendation; }
    @JsonProperty("recommendation")
    public void setRecommendation(String value) { this.recommendation = value; }
}

// Matching.java

package com.apiverve.danevalidator.data;

import com.fasterxml.jackson.annotation.*;

public class Matching {
    private String name;
    private String description;
    private String fullDescription;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("full_description")
    public String getFullDescription() { return fullDescription; }
    @JsonProperty("full_description")
    public void setFullDescription(String value) { this.fullDescription = value; }
}

// Parsed.java

package com.apiverve.danevalidator.data;

import com.fasterxml.jackson.annotation.*;

public class Parsed {
    private String name;
    private long port;
    private String protocol;
    private String hostname;
    private long ttl;
    private String parsedClass;
    private long usage;
    private long selector;
    private long matching;
    private String certificateData;
    private long certificateDataLength;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("port")
    public long getPort() { return port; }
    @JsonProperty("port")
    public void setPort(long value) { this.port = value; }

    @JsonProperty("protocol")
    public String getProtocol() { return protocol; }
    @JsonProperty("protocol")
    public void setProtocol(String value) { this.protocol = value; }

    @JsonProperty("hostname")
    public String getHostname() { return hostname; }
    @JsonProperty("hostname")
    public void setHostname(String value) { this.hostname = value; }

    @JsonProperty("ttl")
    public long getTTL() { return ttl; }
    @JsonProperty("ttl")
    public void setTTL(long value) { this.ttl = value; }

    @JsonProperty("class")
    public String getParsedClass() { return parsedClass; }
    @JsonProperty("class")
    public void setParsedClass(String value) { this.parsedClass = value; }

    @JsonProperty("usage")
    public long getUsage() { return usage; }
    @JsonProperty("usage")
    public void setUsage(long value) { this.usage = value; }

    @JsonProperty("selector")
    public long getSelector() { return selector; }
    @JsonProperty("selector")
    public void setSelector(long value) { this.selector = value; }

    @JsonProperty("matching")
    public long getMatching() { return matching; }
    @JsonProperty("matching")
    public void setMatching(long value) { this.matching = value; }

    @JsonProperty("certificate_data")
    public String getCertificateData() { return certificateData; }
    @JsonProperty("certificate_data")
    public void setCertificateData(String value) { this.certificateData = value; }

    @JsonProperty("certificate_data_length")
    public long getCertificateDataLength() { return certificateDataLength; }
    @JsonProperty("certificate_data_length")
    public void setCertificateDataLength(long value) { this.certificateDataLength = value; }
}

// Validation.java

package com.apiverve.danevalidator.data;

import com.fasterxml.jackson.annotation.*;

public class Validation {
    private boolean isValid;
    private String certificateDataFormat;
    private boolean certificateDataLengthValid;

    @JsonProperty("is_valid")
    public boolean getIsValid() { return isValid; }
    @JsonProperty("is_valid")
    public void setIsValid(boolean value) { this.isValid = value; }

    @JsonProperty("certificate_data_format")
    public String getCertificateDataFormat() { return certificateDataFormat; }
    @JsonProperty("certificate_data_format")
    public void setCertificateDataFormat(String value) { this.certificateDataFormat = value; }

    @JsonProperty("certificate_data_length_valid")
    public boolean getCertificateDataLengthValid() { return certificateDataLengthValid; }
    @JsonProperty("certificate_data_length_valid")
    public void setCertificateDataLengthValid(boolean value) { this.certificateDataLengthValid = value; }
}