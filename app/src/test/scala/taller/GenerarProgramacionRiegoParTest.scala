package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GenerarProgramacionRiegoParTest extends AnyFunSuite {
    test("generarProgramacionesRiegoPar genera todas las permutaciones posibles de manera paralela") {
        val finca = Vector((10, 3, 2), (15, 5, 1), (20, 4, 3))
        val programaciones = App.generarProgramacionesRiegoPar(finca)
        assert(programaciones.size == 6) // factorial(3)
    }

    test("generarProgramacionesRiegoPar genera correctamente todas las permutaciones en fincas de 4") {
        val finca = Vector.fill(4)((10, 3, 2)) // Finca de 4 tablones
        val programaciones = App.generarProgramacionesRiegoPar(finca)
        assert(programaciones.size == 24) // factorial(4)
    }

    test("generarProgramacionesRiegoPar funciona con una finca de un solo tablón") {
        val finca = Vector((10, 3, 2))
        assert(App.generarProgramacionesRiegoPar(finca).size == 1)
    }

    test("generarProgramacionesRiegoPar es consistente con la versión no paralela") {
        val finca = Vector((10, 3, 2), (15, 5, 1))
        assert(App.generarProgramacionesRiegoPar(finca) == App.generarProgramacionesRiego(finca))
    }

    test("generarProgramacionesRiegoPar genera correctamente todas las permutaciones en fincas grandes") {
        val finca = Vector.fill(5)((10, 3, 2)) // Finca de 5 tablones
        val programaciones = App.generarProgramacionesRiegoPar(finca)
        assert(programaciones.size == 120) // factorial(5)
    }
}