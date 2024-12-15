package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GenerarProgramacionRiegoTest extends AnyFunSuite {
test("Generar programaciones de riego para una finca con 3 tablones") {
  val finca = Vector((10, 5, 1), (15, 6, 2), (20, 7, 3))
  val programaciones = App.generarProgramacionesRiego(finca)
  assert(programaciones.size == 6)  // 3! = 6 permutaciones posibles
}

test("Generar programaciones de riego para una finca con 1 tablón") {
  val finca = Vector((10, 5, 1))
  val programaciones = App.generarProgramacionesRiego(finca)
  assert(programaciones.size == 1)  // Solo hay una permutación para un solo tablón
}

test("Generar programaciones de riego para una finca con 4 tablones") {
  val finca = Vector((10, 5, 1), (15, 6, 2), (20, 7, 3), (25, 8, 4))
  val programaciones = App.generarProgramacionesRiego(finca)
  assert(programaciones.size == 24)  // 4! = 24 permutaciones posibles
}

test("Generar programaciones con más de 5 tablones") {
  val finca = Vector((10, 5, 1), (15, 6, 2), (20, 7, 3), (25, 8, 4), (30, 9, 5))
  val programaciones = App.generarProgramacionesRiego(finca)
  assert(programaciones.size == 120)  // 5! = 120 permutaciones posibles
}

test("Generar programaciones con más de 6 tablones") {
  val finca = Vector((10, 5, 1), (15, 6, 2), (20, 7, 3), (25, 8, 4), (30, 9, 5), (35, 10, 6))
  val programaciones = App.generarProgramacionesRiego(finca)
  assert(programaciones.size == 720)  // 6! = 720 permutaciones
}

}