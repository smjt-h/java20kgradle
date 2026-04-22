#!/usr/bin/env python3
"""Regenerate com.example.work.WorkChunk* and matching *Test classes (20_000 units by default)."""

from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
MAIN = ROOT / "src/main/java/com/example/work"
TEST = ROOT / "src/test/java/com/example/work"

CHUNK_SIZE = 800
NUM_CHUNKS = 25


def main() -> None:
    MAIN.mkdir(parents=True, exist_ok=True)
    TEST.mkdir(parents=True, exist_ok=True)

    for c in range(1, NUM_CHUNKS + 1):
        lo = (c - 1) * CHUNK_SIZE + 1
        hi = c * CHUNK_SIZE
        cc = f"{c:02d}"
        cls = f"WorkChunk{cc}"

        lines_m = [
            "package com.example.work;",
            "",
            f"public final class {cls} {{",
            "",
        ]
        lines_t = [
            "package com.example.work;",
            "",
            "import static org.junit.jupiter.api.Assertions.assertEquals;",
            "",
            "import org.junit.jupiter.api.Test;",
            "import org.junit.jupiter.api.parallel.Execution;",
            "import org.junit.jupiter.api.parallel.ExecutionMode;",
            "",
            "@Execution(ExecutionMode.CONCURRENT)",
            f"final class {cls}Test {{",
            "",
            f"    private final {cls} subject = new {cls}();",
            "",
        ]

        for gid in range(lo, hi + 1):
            m = f"u{gid:05d}"
            lines_m.append(f"    public int {m}() {{")
            lines_m.append(f"        return WorkContext.echo({gid});")
            lines_m.append("    }")
            lines_m.append("")
            lines_t.append("    @Test")
            lines_t.append(f"    void {m}() {{")
            lines_t.append(f"        assertEquals({gid}, subject.{m}());")
            lines_t.append("    }")
            lines_t.append("")

        lines_m.append("}")
        lines_t.append("}")

        (MAIN / f"{cls}.java").write_text("\n".join(lines_m) + "\n")
        (TEST / f"{cls}Test.java").write_text("\n".join(lines_t) + "\n")

    print(f"Wrote {NUM_CHUNKS} production + {NUM_CHUNKS} test classes under {MAIN.parent} / {TEST.parent}")


if __name__ == "__main__":
    main()
