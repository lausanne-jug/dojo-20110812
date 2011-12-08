package ch.jugl.dojo;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class FooBarQixTest
{

    private FooBarQix fooBarQix = new FooBarQix();

    @Test
    public void shouldReturnFooWhenMultipleOfThree()
    {

        Assert.assertEquals("Foo", fooBarQix.analyse(6));
    }

    @Test
    public void shouldReturnFooWhenContainsThree()
    {
        Assert.assertEquals("Foo", fooBarQix.analyse(31));
    }

    @Test
    public void shouldReturnBarWhenMultipleOfFive()
    {
        Assert.assertEquals("Bar", fooBarQix.analyse(10));
    }

    @Test
    public void shouldReturnBarWhenContainsFive()
    {
        Assert.assertEquals("Bar", fooBarQix.analyse(52));
    }

    @Test
    public void shouldReturnQixWhenMultipleOfSeven()
    {
        Assert.assertEquals("Qix", fooBarQix.analyse(14));
    }

    @Test
    public void shouldReturnQixWhenContainsSeven()
    {
        Assert.assertEquals("Qix", fooBarQix.analyse(17));
    }

    @Test
    public void shouldReturnFooFooIfThree()
    {
        Assert.assertEquals("FooFoo", fooBarQix.analyse(3));
    }

    @Test
    public void shouldReturnBarBarIfFive()
    {
        Assert.assertEquals("BarBar", fooBarQix.analyse(5));
    }

    @Test
    public void shouldReturnQixQixIfSeven()
    {
        Assert.assertEquals("QixQix", fooBarQix.analyse(7));
    }

    @Test
    public void shouldReturnFooBarIfMultipleOfThreeAndContainsOneFive()
    {
        Assert.assertEquals("FooBar", fooBarQix.analyse(51));
    }

    @Test
    public void shouldReturnFooQixIfMultipleOfThreeAndContainsOneSeven()
    {
        Assert.assertEquals("FooQix", fooBarQix.analyse(27));
    }

    @Test
    public void shouldReturnBarFooIfContainsOneFiveThenOneThree()
    {
        Assert.assertEquals("BarFoo", fooBarQix.analyse(53));
    }

    @Test
    public void shouldCheckMultipleInFooBarQixOrder()
    {
        Assert.assertEquals("FooBarQix", fooBarQix.analyse(3 * 5 * 7 * 2));
    }

    @Test
    public void shouldReturnInTheOrderOfApparition()
    {
        Assert.assertEquals("BarFooQixQixFoo", fooBarQix.analyse(53773));
    }

    @Test
    public void shouldCheckMultipleBeforeContent()
    {
        Assert.assertEquals("FooBarQixBar", fooBarQix.analyse(3 * 5 * 7));
    }

    @Test
    public void testMiscellaneous()
    {
        check("FooFooFoo", 33);
        check("FooQix", 21);
        check("Foo", 13);
        check("FooBarBar", 15);
        check("FooFooFoo", 33);
        check("1", 1);
        check("2", 2);
        check("4", 4);
        check("8", 8);
        check("61", 61);
    }

    private void check(String expected, int number)
    {
        Assert.assertEquals(expected, fooBarQix.analyse(number));
    }

    @Test
    public void shouldPrintAsManyCarriageReturnAsNumber()
    {

        Assert.assertEquals(3, fooBarQix.print(1, 3).split("\\n").length);
        Assert.assertEquals(130, fooBarQix.print(1, 130).split("\\n").length);
    }

    @Test
    public void shouldPrintAnalysedNumbersFromOneToThree()
    {
        FooBarQix fooBar = mock(FooBarQix.class, Mockito.CALLS_REAL_METHODS);
        when(fooBar.analyse(1)).thenReturn("1");
        when(fooBar.analyse(2)).thenReturn("2");
        when(fooBar.analyse(3)).thenReturn("Foo");
        Assert.assertEquals("1\n2\nFoo\n", fooBar.print(1, 3));
    }
}
