package taller

import org.scalameter.{Warmer, measure, withWarmer}

import scala.math.random

class Benchmark {
  val long = 8
  val finca = App.fincaAlAzar(long);
  val distancia = App.distanciaAlAzar(long);

  def BenchmarkRiegoOptimo(): Unit = {
    val timeSeq = withWarmer(new Warmer.Default) measure {
      App.ProgramacionRiegoOptimo( finca , distancia )
    }
    val timePar = withWarmer(new Warmer.Default) measure {
      App.ProgramacionRiegoOptimoPar(finca , distancia )
    }
    println ("\nBenchmark RiegoOptimo")
    println (s"Secuencial: $timeSeq ms")
    println (s"Paralelo: $timePar ms")
    println (s"Speedup: ${timeSeq.value / timePar.value}")
  }
  def BenchmarkGenerarProgramacionesRiego(): Unit = {
    val timeSeq = withWarmer(new Warmer.Default) measure {
      App.generarProgramacionesRiego( finca )
    }
    val timePar = withWarmer(new Warmer.Default) measure {
      App.generarProgramacionesRiegoPar( finca )
    }
    println ("\nBenchmark GenerarProgramacionesRiego")
    println (s"Secuencial: $timeSeq ms")
    println (s"Paralelo: $timePar ms")
    println (s"Speedup: ${timeSeq.value / timePar.value}")
  }
  def BenchmarkCostoRiegoFinca(): Unit = {
    val timeSeq = withWarmer(new Warmer.Default) measure {
      App.costoRiegoFinca( finca , App.generarProgramacionesRiego( finca ).head )
    }
    val timePar = withWarmer(new Warmer.Default) measure {
      App.costoRiegoFincaPar( finca , App.generarProgramacionesRiegoPar( finca ).head )
    }
    println ("\nBenchmark CostoRiegoFinca")
    println (s"Secuencial: $timeSeq ms")
    println (s"Paralelo: $timePar ms")
    println (s"Speedup: ${timeSeq.value / timePar.value}")
  }

  def BenchmarCostoMovilidad(): Unit = {
    val timeSeq = withWarmer(new Warmer.Default) measure {
      App.costoMovilidad( finca , App.generarProgramacionesRiego( finca ).head , distancia )
    }
    val timePar = withWarmer(new Warmer.Default) measure {
      App.costoMovilidadPar( finca , App.generarProgramacionesRiegoPar( finca ).head , distancia )
    }
    println ("\nBenchmark CostoMovilidad")
    println (s"Secuencial: $timeSeq ms")
    println (s"Paralelo: $timePar ms")
    println (s"Speedup: ${timeSeq.value / timePar.value}")
  }
}
