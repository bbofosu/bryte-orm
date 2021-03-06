package org.brytelabs.orm.core.generators;

import java.util.stream.Collectors;
import org.brytelabs.orm.api.GroupByBuilder;
import org.brytelabs.orm.api.Table;
import org.brytelabs.orm.core.builders.GroupByBuilderImpl;
import org.brytelabs.orm.exceptions.SqlQueryException;

public class GroupByGenerator implements Generator {
  private final GroupByBuilderImpl groupByBuilder;
  private final Table fromTable;

  public GroupByGenerator(GroupByBuilder groupByBuilder, Table fromTable) {
    this.groupByBuilder = (GroupByBuilderImpl) groupByBuilder;
    this.fromTable = fromTable;
  }

  @Override
  public void validate() throws SqlQueryException {
    if (groupByBuilder.getFields() == null || groupByBuilder.getFields().isEmpty()) {
      throw new SqlQueryException("Group by fields should be provided");
    }
  }

  @Override
  public String generate() {
    return "group by "
        + groupByBuilder.getFields().stream()
            .map(f -> f.forCondition(fromTable))
            .collect(Collectors.joining(", "));
  }
}
