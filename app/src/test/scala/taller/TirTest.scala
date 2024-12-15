package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TirTest extends AnyFunSuite {    


    test("tIR calcula correctamente los tiempos de inicio para una programación secuencial") {
    val finca = Vector((10, 3, 2), (15, 5, 1), (20, 4, 3))
    val progRiego = Vector(0, 1, 2)
    assert(App.tIR(finca, progRiego) == Vector(0, 3, 8))
    }

    test("tIR calcula correctamente los tiempos de inicio para una programación diferente") {
    val finca = Vector((10, 3, 2), (15, 5, 1), (20, 4, 3))
    val progRiego = Vector(2, 0, 1)
    assert(App.tIR(finca, progRiego) == Vector(4, 7, 0))
    }

    test("tIR devuelve solo ceros para una finca vacía") {
    val finca = Vector()
    val progRiego = Vector()
    assert(App.tIR(finca, progRiego).isEmpty)
    }

    test("tIR calcula correctamente con una finca de un solo tablón") {
    val finca = Vector((10, 3, 2))
    val progRiego = Vector(0)
    assert(App.tIR(finca, progRiego) == Vector(0))
    }

    test("tIR falla con una programación que no corresponde a la finca") {
    val finca = Vector((10, 3, 2))
    val progRiego = Vector(0, 1) // Más elementos que tablones
    assertThrows[IndexOutOfBoundsException] {
        App.tIR(finca, progRiego)
    }
    }
}