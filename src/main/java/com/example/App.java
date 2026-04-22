package com.example;

import com.example.work.WorkChunk01;
import com.example.work.WorkContext;

/** Small entry point that exercises generated work code for call-graph roots. */
public final class App {
    private App() {}

    public static void main(String[] args) {
        int sample = new WorkChunk01().u00001();
        int viaContext = WorkContext.echo(1);
        if (sample != viaContext) {
            throw new IllegalStateException("unexpected work result");
        }
    }
}
