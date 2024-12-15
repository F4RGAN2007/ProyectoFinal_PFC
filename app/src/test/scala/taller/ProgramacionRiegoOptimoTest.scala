package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProgramacionRiegoOptimoTest extends AnyFunSuite {

  test("Programación óptima en finca Vector((10, 2, 1), (15, 3, 2), (12, 1, 3) (3 tablones)") {
    val finca = Vector((10, 2, 1), (15, 3, 2), (12, 1, 3))
    val distancia = Vector(
        Vector(0, 3, 2),
        Vector(3, 0, 4),
        Vector(2, 4, 0)
    )
    assert(App.ProgramacionRiegoOptimo(finca, distancia) == (Vector(1, 0, 2),28)) // Orden esperado
  }

  test("Programación óptima en finca Vector((8, 1, 3), (20, 2, 1), (18, 3, 2)) (3 tablones)") {
    val finca = Vector((8, 1, 3), (20, 2, 1), (18, 3, 2))
    val distancia = Vector(
        Vector(0, 5, 6),
        Vector(5, 0, 7),
        Vector(6, 7, 0)
    )
    assert(App.ProgramacionRiegoOptimo(finca, distancia) == (Vector(2, 0, 1),44)) // Orden esperado
  }

    test("Programación óptima en finca Vector((5, 1, 2), (10, 4, 1), (8, 2, 3), (12, 3, 2)) (4 tablones)") {
    val finca = Vector((5, 1, 2), (10, 4, 1), (8, 2, 3), (12, 3, 2))
    val distancia = Vector(
        Vector(0, 3, 2, 4),
        Vector(3, 0, 5, 6),
        Vector(2, 5, 0, 1),
        Vector(4, 6, 1, 0)
    )
    assert(App.ProgramacionRiegoOptimo(finca, distancia) == (Vector(1, 0, 2, 3),15)) // Orden esperado
  }

  test("Programación óptima en finca Vector((7, 2, 2), (14, 4, 1), (9, 3, 3), (13, 2, 2), (15, 5, 1)) (5 tablones)") {
    val finca = Vector((7, 2, 2), (14, 4, 1), (9, 3, 3), (13, 2, 2), (15, 5, 1))
    val distancia = Vector(
        Vector(0, 3, 4, 5, 6),
        Vector(3, 0, 7, 8, 9),
        Vector(4, 7, 0, 2, 3),
        Vector(5, 8, 2, 0, 4),
        Vector(6, 9, 3, 4, 0)
    )
    assert(App.ProgramacionRiegoOptimo(finca, distancia) == (Vector(1, 0, 2, 3, 4),27)) // Orden esperado
  }

    test("Programación óptima en finca Vector((6, 1, 1), (8, 2, 2), (10, 3, 3)) (3 tablones)") {
    val finca = Vector((6, 1, 1), (8, 2, 2), (10, 3, 3))
    val distancia = Vector(
        Vector(0, 1, 4),
        Vector(1, 0, 3),
        Vector(4, 3, 0)
    )
    assert(App.ProgramacionRiegoOptimo(finca, distancia) == (Vector(2, 1, 0),14)) // Orden esperado
  }
  

}