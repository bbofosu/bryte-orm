package org.brytelabs.orm.api;

import lombok.Value;

@Value(staticConstructor = "with")
public class Table {
    String name;
    String alias;

    public static Table with(String table) {
        return new Table(table, table);
    }
}
