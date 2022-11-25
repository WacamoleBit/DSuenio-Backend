package mx.uv;

import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        port(80);
        get("/hello", (req, res) -> "Hello World");
    }
}
