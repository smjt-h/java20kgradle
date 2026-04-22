package com.example.work;

/**
 * Shared helper invoked by generated work units so static call graphs show a
 * common callee from many {@link WorkChunk01}-style entry points.
 */
public final class WorkContext {

    private WorkContext() {}

    public static int echo(int unitId) {
        return unitId;
    }
}
