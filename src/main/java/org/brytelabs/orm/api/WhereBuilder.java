package org.brytelabs.orm.api;

public interface WhereBuilder {
    ConjunctionBuilder eq(Object value);
    ConjunctionBuilder gt(Object value);
    ConjunctionBuilder lt(Object value);
    ConjunctionBuilder lte(Object i);
}
