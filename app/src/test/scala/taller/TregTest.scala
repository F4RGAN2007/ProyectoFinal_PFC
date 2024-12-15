package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TregTest extends AnyFunSuite {
    val finca = Vector((10, 5, 1), (15, 6, 2), (20, 7, 3), (12, 8, 4), (15, 5, 5))

test("Tiempo de regado del tablon 0 en la finca") {
  assert(App.treg(finca, 0) == 5)  // El tiempo de regado del primer tablón debe ser 5
}

test("Tiempo de regado del tablon 1 en la finca") {
  assert(App.treg(finca, 1) == 6)  // El tiempo de regado del segundo tablón debe ser 6
}

test("Tiempo de regado del tablon 2 en la finca") {
  assert(App.treg(finca, 2) == 7)  // El tiempo de regado del tercer tablón debe ser 7
}

test("Tiempo de regado fuera de rango") {
  assertThrows[IndexOutOfBoundsException] {
    App.treg(finca, 5)  // Fuera de rango, debe lanzar una excepción
  }
}


test("Tiempo de supervivencia del tablon 5 en finca vacía") {
    assert(App.treg(finca, 4) == 5)  // Debe devolver 0 si no hay tablones
}

}