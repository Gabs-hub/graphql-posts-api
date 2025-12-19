package com.gabs.graphql.exeption;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import graphql.GraphqlErrorException;
import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GraphQlExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof GraphQLError) {
            return (GraphQLError) ex;
        }
        return GraphqlErrorException.newErrorException().message(ex.getMessage()).build();
    }
}
