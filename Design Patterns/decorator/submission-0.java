abstract class Coffee {
    public abstract double getCost();
}

class SimpleCoffee extends Coffee {
    @Override
    public double getCost() {
        return 1.1;
    }
}

abstract class CoffeeDecorator extends Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    protected Coffee decoratedCoffee;

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public double getCost(){
        return super.getCost() + 0.5 ;
    }

}

class SugarDecorator extends CoffeeDecorator {
     protected Coffee decoratedCoffee;

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public double getCost(){
        return super.getCost() + 0.2 ;
    }
}

class CreamDecorator extends CoffeeDecorator {
      protected Coffee decoratedCoffee;

    public CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    public double getCost(){
        return super.getCost() + 0.7 ;
    }
}
