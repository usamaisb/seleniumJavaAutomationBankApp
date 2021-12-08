package modules;

public class Base {
    private static String baseUrl = " http://demo.guru99.com/";
    public static String getBaseUrl()
    {
        System.out.print("Using Url>>>>>>>::" + baseUrl);
        return baseUrl;
    }
}
