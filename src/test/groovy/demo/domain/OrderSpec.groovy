package demo.domain;

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class OrderSpec extends Specification{

    def "testing-parameterized-constructor" (){

        when: "creating a object"
        def order = new Order(20, "itemA", 50)

        then:
        order instanceof Order

        and: "checking contents of object"
        order.itemName == "itemA"
        order.price == 50
        order.quantity == 20
        order.priceWithTax == 0
    }

    def "testing-getQuantity-returnType" () {
        setup: "creating and initializing a object"
        Order order = new Order(60, "itemB", 30)

        when: "calling getQuantity method"
        def quant = order.getQuantity()

        then:
        quant instanceof Integer
    }


    def "testing-getItemName-returnType" () {
        setup: "creating and initializing a object"
        Order order = new Order(60, "itemB", 30)

        when: "calling getItemName method"
        def name = order.getItemName()

        then:
        name instanceof String

        and:
        name != null
    }


    @Unroll
    def "Testing order setQuantity()"() {
        given: "Create order object"
        Order order = new Order()
        when:
        order.setQuantity(item)
        then:
        order.quantity == expectedItem
        where:
        sno | item | expectedItem
        1   | 20   | 20
        2   | 30   | 30
        3   |  0   | 0
    }
    @Unroll
    def "Testing order getQuantity()"() {
        given: "Create order object"
        Order order = new Order()
        and:
        order.setQuantity(item)
        when:
        int a=order.getQuantity()
        then:
        a == expectedItem
        where:
        sno | item | expectedItem
        1   | 20   | 20
        2   | 30   | 30
        3   |  0   | 0
    }
    @Unroll
    def "Testing order setItemName()"() {
        given: "Create order object"
        Order order = new Order()
        when:
        order.setItemName(item)
        then:
        order.itemName == expectedItem
        where:
        sno | item        | expectedItem
        1   | "banana"    | "banana"
        2   | "mango"     | "mango"
    }
    def "Testing order getItemName()"() {
        given: "Create order object"
        Order order = new Order()
        and:
        order.setItemName(item)
        when:
        String a=order.getItemName()
        then:
        a == expectedItem
        where:
        sno | item        | expectedItem
        1   | "banana"    | "banana"
        2   | "mango"     | "mango"
    }
    @Unroll
    def "Testing order setPrice()"() {
        given: "Create order object"
        Order order = new Order()
        when:
        order.setPrice(item)
        then:
        order.price == expectedItem
        where:
        sno | item | expectedItem
        1   | 20   | 20
        2   | 30   | 30
        3   |  0   | 0
        4   | 30D   | 30D
    }
    @Unroll
    def "Testing order getPrice()"() {
        given: "Create order object"
        Order order = new Order()
        and:
        order.setPrice(item)
        when:
        double a=order.getPrice()
        then:
        a == expectedItem
        where:
        sno | item | expectedItem
        1   | 20   | 20
        2   | 30   | 30
        3   |  0   | 0
        4   | 30D   | 30D
    }
    @Unroll
    def "Testing order setPriceWithTax()"() {
        given: "Create order object"
        Order order = new Order()
        when:
        order.setPriceWithTax(item)
        then:
        order.priceWithTax == expectedItem
        where:
        sno | item | expectedItem
        1   | 20   | 20
        2   | 30   | 30
        3   |  0   | 0
        4   | 30D   | 30D
    }
    @Unroll
    def 'Testing order getPriceWithTax()'() {
        given: "Create order object"
        Order order = new Order()
        and:
        order.setPriceWithTax(item)
        when:
        double a=order.getPriceWithTax()
        then:
        order.priceWithTax == expectedItem
        where:
        sno | item | expectedItem
        1   | 20   | 20
        2   | 30   | 30
        3   |  0   | 0
        4   | 30D   | 30D
    }

    @Ignore
    def "Testing order setQuantity() with wrong parameters"() {
        given: "Create order object"
        Order order = new Order()
        when:
        order.setQuantity(item)
        then:
        println "illegal argument"
        //   thrown(groovy.lang.MissingMethodException)
        where:
        sno | item
        1   | -20
        2   | 30L

    }
}