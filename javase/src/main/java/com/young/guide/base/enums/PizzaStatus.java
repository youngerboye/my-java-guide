package main.java.com.young.guide.base.enums;

/**
 * @author: young
 * @date: 2021/2/25
 */
public enum PizzaStatus {
    ORDER,
    READY,
    DELIVRED,
    ;
}


class PizzaStatusTest {
    public static void main(String[] args) {
        System.out.println(PizzaStatus.ORDER);
        System.out.println(PizzaStatus.ORDER.name());
        System.out.println(PizzaStatus.ORDER.getClass());
        System.out.println(PizzaStatus.ORDER.name().getClass());
    }
}

class Pizza {
    private PizzaStatus1 pizzaStatus1;

    public enum PizzaStatus1 {
        ORDER,
        READY,
        DELIVERED,
        ;
    }

    public PizzaStatus1 getPizzaStatus1() {
        return pizzaStatus1;
    }

    public void setPizzaStatus1(PizzaStatus1 pizzaStatus1) {
        this.pizzaStatus1 = pizzaStatus1;
    }

    public boolean isDelivered() {
        return getPizzaStatus1() == PizzaStatus1.DELIVERED;
    }

    public static void main(String[] args) {
        System.out.println(new Pizza().isDelivered());
    }

    public int getStatus() {
        switch (pizzaStatus1) {
            case ORDER:
                return 5;
            case READY:
                return 2;
            case DELIVERED:
                return 1;
        }
        return 0;
    }



}
