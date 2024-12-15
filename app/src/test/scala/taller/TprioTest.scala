package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TprioTest extends AnyFunSuite {
    val finca = Vector((10, 5, 1), (15, 6, 2), (20, 7, 3), (12, 8, 4), (15, 5, 5))

test("Prioridad del tablon 0 en la finca") {
  assert(App.tprio(finca, 0) == 1)  // La prioridad del primer tablón debe ser 1
}

test("Prioridad del tablon 1 en la finca") {
  assert(App.tprio(finca, 1) == 2)  // La prioridad del segundo tablón debe ser 2
}

test("Prioridad del tablon 2 en la finca") {
  assert(App.tprio(finca, 2) == 3)  // La prioridad del tercer tablón debe ser 3
}

test("Prioridad fuera de rango") {
  assertThrows[IndexOutOfBoundsException] {
    App.tprio(finca, 5)  // Fuera de rango, debe lanzar una excepción
  }
}



test("Tiempo de supervivencia del tablon 5 en finca vacía") {
    assert(App.tprio(finca, 4) == 5)  // Debe devolver 0 si no hay tablones
}

}