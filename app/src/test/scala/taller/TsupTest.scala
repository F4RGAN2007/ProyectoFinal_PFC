package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TsupTest extends AnyFunSuite {
    val finca = Vector((10, 5, 1), (15, 6, 2), (20, 7, 3), (12, 8, 4), (15, 5, 5))

    test("Tiempo de supervivencia del tablon 1 en la finca") {
        assert(App.tsup(finca, 0) == 10)  // El tiempo de supervivencia del primer tablón debe ser 10
    }

    test("Tiempo de supervivencia del tablon 2 en la finca") {
        assert(App.tsup(finca, 1) == 15)  // El tiempo de supervivencia del segundo tablón debe ser 15
    }

    test("Tiempo de supervivencia del tablon 3 en la finca") {
        assert(App.tsup(finca, 2) == 20)  // El tiempo de supervivencia del tercer tablón debe ser 20
    }

    test("Tiempo de supervivencia del tablon 5 en finca vacía") {
        assert(App.tsup(finca, 4) == 15)  // Debe devolver 0 si no hay tablones
    }

    test("Tiempo de supervivencia del tablon 4 en la finca") {
        assert(App.tsup(finca, 3) == 12)  // El tiempo de supervivencia del tercer tablón debe ser 20
    }

    
}
