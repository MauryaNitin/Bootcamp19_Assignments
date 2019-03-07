package demo.service

import demo.domain.Order;
import spock.lang.Specification;

class EmailServiceSpec extends Specification{
    def "testing-singleton-design" () {
        setup: "create a initial object"
        EmailService oldInstance = EmailService.getInstance();

        when: "trying to create another object"
        EmailService newInstance = EmailService.getInstance();

        then:
        newInstance == oldInstance
    }

    def "testing-send-email-with-order"() {
        setup: "create order instance"
        Order order = new Order();

        and: "create emailService instance"
        EmailService emailService = new EmailService();

        when: "Sending email with order"
        emailService.sendEmail(order)

        then: "checking the status of exception"
        thrown(RuntimeException)

    }

    def "testing-send-email-with-order-and-String" () {
        setup: "creating order instance"
        Order order = new Order();

        and: "create emailService instance"
        EmailService emailService = new EmailService();

        and: "setting string value"
        String str = "nitin"

        when: "sending email with order and a string"
        boolean result  = emailService.sendEmail(order, str)

        then: "result will be"
        result == true
    }
}
