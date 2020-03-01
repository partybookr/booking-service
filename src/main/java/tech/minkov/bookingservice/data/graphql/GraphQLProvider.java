package tech.minkov.bookingservice.data.graphql;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GraphQLProvider {

  private GraphQL graphQL;

  private final GraphQLDataFetchers graphQLDataFetchers;

  public GraphQLProvider(GraphQLDataFetchers graphQLDataFetchers) {
    this.graphQLDataFetchers = graphQLDataFetchers;
  }

  @Bean
  public GraphQL graphQL() {
    return graphQL;
  }

  @SuppressWarnings("UnstableApiUsage")
  @PostConstruct
  public void init() throws IOException {
    var url = Resources.getResource("schema.graphqls");
    var sdl = Resources.toString(url, Charsets.UTF_8);
    var graphQlSchema = buildSchema(sdl);
    this.graphQL = GraphQL.newGraphQL(graphQlSchema).build();
  }

  private GraphQLSchema buildSchema(String sdl) {
    TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
    RuntimeWiring runtimeWiring = buildWiring();
    SchemaGenerator schemaGenerator = new SchemaGenerator();
    return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
  }

  private RuntimeWiring buildWiring() {
    return RuntimeWiring.newRuntimeWiring()
      .type(newTypeWiring("Query")
        .dataFetcher("parties", graphQLDataFetchers.getPartiesDataFetcher()))
      .type(newTypeWiring("Query")
        .dataFetcher("partyById", graphQLDataFetchers.getPartyByIdDataFetcher()))
      .type(newTypeWiring("PartyDetails")
        .dataFetcher("details", graphQLDataFetchers.getPartyDetailsDataFetcher()))
      .build();
  }
}
