package com.github.akovalchuk;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 3, jvmArgsAppend = { "-server", "-disablesystemassertions" })
public class Benchmark1 {

  int x = 8;

  @Benchmark
  @Warmup(iterations = 10, time = 3, timeUnit = TimeUnit.SECONDS)
  public int baseline() {
    return x;
  }
}
