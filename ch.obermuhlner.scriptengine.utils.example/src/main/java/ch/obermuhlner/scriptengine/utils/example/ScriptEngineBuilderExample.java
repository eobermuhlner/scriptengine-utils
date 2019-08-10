package ch.obermuhlner.scriptengine.utils.example;

import ch.obermuhlner.scriptengine.utils.builder.ScriptEngineBuilder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineBuilderExample {
    public static void main(String[] args) {
        runExamples();
    }

    private static void runExamples() {
        ScriptEngineBuilder.byName("js")
                .setVar("alpha", 1)
                .setVar("beta", 2)
                .eval("var gamma = alpha+beta")
                .onResult(result -> {
                    System.out.println("Result: " + result);
                })
                .onException(ex -> {
                    System.out.println("Exception: " + ex);
                    ex.printStackTrace();
                })
                .getVar("gamma", (value) -> {
                    System.out.println("Gamma Var: " + value);
                })
                .getVars((key, value) -> {
                    System.out.println("Var: " + key + " = " + value);
                })
                .eval("gamma = gamma * 2")
                .getVar("gamma", (value) -> {
                    System.out.println("Gamma2 Var: " + value);
                });
    }
}
