package ch.jugl.dojo;

public class FooBarQix
{

    public String analyse(int number)
    {
        StringBuilder builder = new StringBuilder();

        if ((number % 3) == 0)
        {
            builder.append("Foo");
        }
        if (number % 5 == 0)
        {
            builder.append("Bar");
        }
        if (number % 7 == 0)
        {
            builder.append("Qix");
        }

        for (char c : String.valueOf(number).toCharArray())
        {
            if (c == '5')
            {
                builder.append("Bar");
            } else if (c == '3')
            {
                builder.append("Foo");
            } else if (c == '7')
            {
                builder.append("Qix");
            }
        }

        if (builder.length() == 0)
        {
            return String.valueOf(number);
        }
        return builder.toString();
    }

    public String print(int fromNumber, int toNumber)
    {
        StringBuilder builder = new StringBuilder();
        for (int i = fromNumber; i <= toNumber; i++)
        {
            builder.append(analyse(i));
            builder.append("\n");
        }

        return builder.toString();
    }

    public static void main(String[] args)
    {
        int from = Integer.parseInt(args[0]);
        int to = Integer.parseInt(args[1]);
        System.out.println(new FooBarQix().print(from, to));
    }
}
