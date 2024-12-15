package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CostoRiegoTablonTest extends AnyFunSuite {
    test("costoRiegoTablon calcula un costo positivo para un tablón regado correctamente") {
        val finca = Vector((10, 3, 2))
        val progRiego = Vector(0)
        assert(App.costoRiegoTablon(0, finca, progRiego) >= 0)
    }

    test("costoRiegoTablon penaliza si el tiempo de inicio es mayor al tiempo de supervivencia") {
        val finca = Vector((5, 3, 2)) // Tiempo de supervivencia bajo
        val progRiego = Vector(0)
        assert(App.costoRiegoTablon(0, finca, progRiego) > 0)
    }

    test("costoRiegoTablon devuelve 0 si el riego inicia exactamente a tiempo") {
        val finca = Vector((3, 3, 2)) // Tiempo de regado igual a supervivencia
        val progRiego = Vector(0)
        assert(App.costoRiegoTablon(0, finca, progRiego) == 0)
    }

    test("costoRiegoTablon funciona para múltiples tablones en una programación") {
        val finca = Vector((10, 3, 2), (15, 5, 1))
        val progRiego = Vector(0, 1)
        assert(App.costoRiegoTablon(1, finca, progRiego) >= 0)
    }

    test("costoRiegoTablon falla para índices fuera de rango") {
        val finca = Vector((10, 3, 2))
        val progRiego = Vector(0)
        assertThrows[IndexOutOfBoundsException] {
            App.costoRiegoTablon(1, finca, progRiego)
        }
    }

}