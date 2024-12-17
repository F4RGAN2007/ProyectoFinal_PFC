package taller

import org.scalameter.{Warmer, measure, withWarmer}

import scala.util.Random

import org.scalameter._

class Benchmark {
  def runBenchmarks(): Unit = {
    for (long <- 7 to 9) {
      println(s"\n=== Ejecutando Benchmarks con long = $long ===")

      val finca = App.fincaAlAzar(long)
      val distancia = App.distanciaAlAzar(long)

      BenchmarkRiegoOptimo(finca, distancia)
      BenchmarkGenerarProgramacionesRiego(finca)
      BenchmarkCostoRiegoFinca(finca)
      BenchmarkCostoMovilidad(finca, distancia)
    }
  }

  def BenchmarkRiegoOptimo(finca: App.Finca, distancia: App.Distancia): Unit = {
    val timeSeq = withWarmer(new Warmer.Default) measure {
      App.ProgramacionRiegoOptimo(finca, distancia)
    }
    val timePar = withWarmer(new Warmer.Default) measure {
      App.ProgramacionRiegoOptimoPar(finca, distancia)
    }
    println("\nBenchmark RiegoOptimo")
    println(s"Tamaño de la finca: ${finca.length}")
    println(s"Secuencial: $timeSeq ms")
    println(s"Paralelo: $timePar ms")
    println(s"Speedup: ${((timeSeq.value - timePar.value) / timeSeq.value) * 100}%")
  }

  def BenchmarkGenerarProgramacionesRiego(finca: App.Finca): Unit = {
    val timeSeq = withWarmer(new Warmer.Default) measure {
      App.generarProgramacionesRiego(finca)
    }
    val timePar = withWarmer(new Warmer.Default) measure {
      App.generarProgramacionesRiegoPar(finca)
    }
    println("\nBenchmark GenerarProgramacionesRiego")
    println(s"Tamaño de la finca: ${finca.length}")
    println(s"Secuencial: $timeSeq ms")
    println(s"Paralelo: $timePar ms")
    println(s"Speedup: ${((timeSeq.value - timePar.value) / timeSeq.value) * 100}%")
  }

  def BenchmarkCostoRiegoFinca(finca: App.Finca): Unit = {
    val timeSeq = withWarmer(new Warmer.Default) measure {
      App.costoRiegoFinca(finca, App.generarProgramacionesRiego(finca).head)
    }
    val timePar = withWarmer(new Warmer.Default) measure {
      App.costoRiegoFincaPar(finca, App.generarProgramacionesRiegoPar(finca).head)
    }
    println("\nBenchmark CostoRiegoFinca")
    println(s"Tamaño de la finca: ${finca.length}")
    println(s"Secuencial: $timeSeq ms")
    println(s"Paralelo: $timePar ms")
    println(s"Speedup: ${((timeSeq.value - timePar.value) / timeSeq.value) * 100}%")
  }

  def BenchmarkCostoMovilidad(finca: App.Finca, distancia: App.Distancia): Unit = {
    val timeSeq = withWarmer(new Warmer.Default) measure {
      App.costoMovilidad(finca, App.generarProgramacionesRiego(finca).head, distancia)
    }
    val timePar = withWarmer(new Warmer.Default) measure {
      App.costoMovilidadPar(finca, App.generarProgramacionesRiegoPar(finca).head, distancia)
    }
    println("\nBenchmark CostoMovilidad")
    println(s"Tamaño de la finca: ${finca.length}")
    println(s"Secuencial: $timeSeq ms")
    println(s"Paralelo: $timePar ms")
    println(s"Speedup: ${((timeSeq.value - timePar.value) / timeSeq.value) * 100}%")
  }
}