package com.lhx.haoke.dubbo.api.graphql;

import graphql.schema.DataFetchingEnvironment;

public interface MyDataFecher {
    String fieldName();
    Object dataFecher(DataFetchingEnvironment environment);
}
