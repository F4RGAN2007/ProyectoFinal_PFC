package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CostoRiegoFincaParTest extends AnyFunSuite {
    test("costoRiegoFincaPar calcula correctamente el costo total en paralelo") {
        val finca = Vector((10, 3, 2), (15, 5, 1))
        val progRiego = Vector(0, 1)
        assert(App.costoRiegoFincaPar(finca, progRiego) == App.costoRiegoFinca(finca, progRiego))
    }

    test("costoRiegoFincaPar devuelve 0 para una finca vacía") {
        val finca = Vector()
        val progRiego = Vector()
        assert(App.costoRiegoFincaPar(finca, progRiego) == 0)
    }

    test("costoRiegoFincaPar calcula correctamente con múltiples tablones y programación no trivial") {
        val finca = Vector((10, 3, 2), (15, 5, 1), (20, 4, 3))
        val progRiego = Vector(2, 0, 1)
        assert(App.costoRiegoFincaPar(finca, progRiego) == App.costoRiegoFinca(finca, progRiego))
    }

    test("costoRiegoFincaPar maneja casos límite donde todos los tiempos son iguales") {
        val finca = Vector.fill(3)((10, 5, 2))
        val progRiego = Vector(0, 1, 2)
        assert(App.costoRiegoFincaPar(finca, progRiego) == App.costoRiegoFinca(finca, progRiego))
    }

    test("costoRiegoFincaPar falla con índices fuera de rango en la programación") {
        val finca = Vector((10, 3, 2))
        val progRiego = Vector(0, 1) // Más elementos que tablones
        assertThrows[IndexOutOfBoundsException] {
            App.costoRiegoFincaPar(finca, progRiego)
        }
    }
}