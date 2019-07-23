package com.github.mizool.tableaccess.business;

import java.io.Serializable;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import com.github.mizool.typemapping.business.DataType;

@Value
@Builder(toBuilder = true)
public class Column implements Serializable
{
    @NonNull
    String name;

    @NonNull
    DataType type;
}