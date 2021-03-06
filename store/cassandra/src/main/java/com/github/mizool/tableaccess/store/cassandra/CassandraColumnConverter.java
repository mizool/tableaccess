package com.github.mizool.tableaccess.store.cassandra;

import javax.inject.Inject;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import com.datastax.driver.core.ColumnDefinitions;
import com.github.mizool.tableaccess.business.Column;
import com.github.mizool.typemapping.store.cassandra.CassandraValueLoadStrategyResolver;

@RequiredArgsConstructor(onConstructor = @__(@Inject), access = AccessLevel.PROTECTED)
class CassandraColumnConverter
{
    private final CassandraValueLoadStrategyResolver loadStrategyResolver;

    public Column toPojo(ColumnDefinitions.Definition columnDefinition)
    {
        Column pojo = null;

        if (columnDefinition != null)
        {
            Column.ColumnBuilder builder = Column.builder();
            builder.name(columnDefinition.getName());
            builder.type(loadStrategyResolver.resolve(columnDefinition.getType()).getTargetDataType());
            pojo = builder.build();
        }

        return pojo;
    }
}