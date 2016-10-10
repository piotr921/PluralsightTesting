package com.pluralsight.testing;

import org.junit.Assert;
import org.junit.Test;
import com.pluralsight.testing.CoffeeType;

public class CafeTest {

    public static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;

    @Test
    public void canBrewEspresso(){
        // given
        Cafe cafe = cafeWithBeans();

        // when
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // then
        Assert.assertEquals("Wrong type of coffee", CoffeeType.Espresso, coffee.getType());
        Assert.assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
        Assert.assertEquals("Wrong number of beans", ESPRESSO_BEANS, coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans(){
        // given
        Cafe cafe = cafeWithBeans();

        // when
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // then
        Assert.assertEquals(NO_BEANS, cafe.getBeansInStock());
    }

    @Test
    public void canBrewLatte(){
        // given
        Cafe cafe = cafeWithBeans();
        cafe.restockMilk(CoffeeType.Latte.getRequiredMilk());

        // when
        Coffee coffee = cafe.brew(CoffeeType.Latte);

        // then
        Assert.assertEquals("Wrong coffee type", CoffeeType.Latte, coffee.getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk(){
        // given
        Cafe cafe = new Cafe();

        // when
        cafe.restockMilk(NO_MILK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBeans(){

        // given
        Cafe cafe = new Cafe();

        // when
        cafe.restockBeans(NO_BEANS);
    }

    // then
    @Test(expected = IllegalStateException.class)
    public void latteRequiresMilk(){

        // given
        Cafe cafe = cafeWithBeans();

        // when
        Coffee coffee = cafe.brew(CoffeeType.Latte);
    }

    private Cafe cafeWithBeans() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(ESPRESSO_BEANS);
        return cafe;
    }
}
