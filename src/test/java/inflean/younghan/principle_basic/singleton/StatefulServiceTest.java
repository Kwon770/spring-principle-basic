package inflean.younghan.principle_basic.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A 사용자 10000원 주문
        int userAOrder = statefulService1.order("userA", 10000);
        // ThreadB: B 사용자 20000원 주문
        int userBOrder = statefulService2.order("userB", 20000);

        // ThreadA: A 사용자가 주문 금액 조회
//        int price = statefulService1.userAOrder();
        int price = userAOrder;
        System.out.println("price = " + price);

//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
        assertThat(price).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}

