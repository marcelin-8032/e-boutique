package fr.spring.eBoutique.project.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.Flow;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandler;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@Configuration
public class WebFlowconfiguration extends AbstractFlowConfiguration {


    @Bean
    public FlowDefinitionRegistry flowDefinitionRegistry() {
        return getFlowDefinitionRegistryBuilder().setBasePath("WEB-INF/flow")
                .addFlowLocation("/check/check-flow.xml", "checkout").build();
    }

    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowDefinitionRegistry()).build();
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter() {
        FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
        handlerAdapter.setFlowExecutor(flowExecutor());
        return handlerAdapter;
    }

    @Bean
    public FlowHandlerMapping flowHandlerMapping() {
        FlowHandlerMapping flowHandlerMapping = new FlowHandlerMapping();
        flowHandlerMapping.setFlowRegistry(flowDefinitionRegistry());
        return flowHandlerMapping;
    }


}
