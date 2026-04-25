package com.mbtroads.resolver_auto;

public class ExpectedStatusResolver {

    public static int expected(String edge) {

        if (edge.contains("Invalid"))
            return 400;

        if (edge.contains("Register"))
            return 201;

        if (edge.contains("UnRegister"))
            return 200;

        return 200;
    }
}
