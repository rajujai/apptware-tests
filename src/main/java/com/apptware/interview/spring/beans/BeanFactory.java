package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BeanFactory {

  @Autowired private ApplicationContext context;

  public OnDemand getOnDemandBean(SomeEnum someEnum, String someString) {
    return switch (someEnum) {
      case SOME_ENUM_A -> context.getBean(OnDemandA.class, someString);
      case SOME_ENUM_B -> context.getBean(OnDemandB.class, someString);
      default -> context.getBean(BaseOnDemand.class, someString);
    };
  }
}
