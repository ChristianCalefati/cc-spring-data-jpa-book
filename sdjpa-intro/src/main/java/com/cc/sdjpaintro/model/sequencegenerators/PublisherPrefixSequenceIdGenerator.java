package com.cc.sdjpaintro.model.sequencegenerators;

import com.cc.sdjpaintro.model.Game;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class PublisherPrefixSequenceIdGenerator extends SequenceStyleGenerator {
    public static final String PREFIX = "Prefix";
    public static final String PREFIX_FORMAT_DEFAULT = "%s";

    public static final String SEPARATOR = "Separator";
    public static final String SEPARATOR_DEFAULT = "_";

    public static final String NUMERIC_SEQUENCE = "Sequence";
    public static final String NUMERIC_SEQUENCE_FORMAT = "%d";

    private String prefixFormat;
    private String separator;
    private String sequenceFormat;
    private String format;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        format = prefixFormat + separator + sequenceFormat;
        return String.format(format, ((Game) object).getPublisher(),super.generate(session, object));
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        prefixFormat = ConfigurationHelper.getString(PREFIX, params, PREFIX_FORMAT_DEFAULT);
        separator = ConfigurationHelper.getString(SEPARATOR, params, SEPARATOR_DEFAULT);
        sequenceFormat = ConfigurationHelper.getString(NUMERIC_SEQUENCE, params, NUMERIC_SEQUENCE_FORMAT);
    }
}
