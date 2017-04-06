package mathew;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class Js {

    public static void main(String[] args) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        try {
            engine.eval(new FileReader("D:\\git-code\\mathew\\src\\test\\java\\mathew\\test.js"));
            Invocable invocable = (Invocable) engine;
//            System.out.println(result);
//            System.out.println(result.getClass());
            invocable.invokeFunction("testThread");
        } catch (ScriptException | FileNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        
    }

    public static String hello(String name) {
        return "hello" + name;
    }

    public static void fun4(ScriptObjectMirror person) {
        System.out.println("Full Name is: " + person.callMember("getFullName"));
    }
}
